/**
 * 文件名：SysPlantChartDimensionDataService.java 版本信息： 日期：2018年5月22日 Copyright 足下 Corporation 2018 版权所有
 */
package com.shumeng.application.video;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.shumeng.application.MysqlConnUtils;
import com.shumeng.application.Pagination;

/**
 * 文件名 ： SysPlantChartDimensionDataService.java
 * 包 名 ： com.shumeng.application.application.plant.service
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年5月22日 下午2:29:54
 * 版 本 ： V1.0
 */
@Service("videoService")
public class VideoService {

	@Autowired
	VideoDao				videoDao;

	@Autowired
	AddrInstroDao			addrInstroDao;

	@Value(value = "${spring.media}")
	private List<String>	media;
	
	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @return
	 * @方法名 find
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @param path
	 * @参数 @param filename
	 * @返回 void
	 * @author Administrator
	 * @throws
	 */
	public List<FileInfo> find(String path, String filename) throws FileNotFoundException, IOException {
		List<FileInfo> list = dceFileinfo(path, filename);
		return list;
		
	}
	
	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @方法名 dceFileinfo
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @param path
	 * @参数 @param filename
	 * @参数 @return
	 * @返回 List<FileInfo>
	 * @author Administrator
	 * @throws
	 */
	private List<FileInfo> dceFileinfo(String path, String filename) throws FileNotFoundException, IOException {
		List<FileInfo> list = new ArrayList<>();
		File filepath = new File(path);

		for (File file : filepath.listFiles()) {
			if (file.isHidden()) {
				continue;
			}
			if (file.isFile()) {
				FileInfo info = new FileInfo();
				info.setMimetype(file.getName().substring(file.getName().lastIndexOf(".")));
				if (media.contains(info.getMimetype())) {
					info.setFileName(file.getName());
				} else {
					continue;
				}
				info.setFilePath(file.getAbsolutePath());
				info.setSize(file.length());
				FileInputStream stream = new FileInputStream(file);
				info.setUuid(DigestUtils.md5DigestAsHex(stream));
				stream.close();
				System.err.println(info);
				videoDao.save(info);
				if (!"".equals(filename)) {
					if (file.getName().contains(filename)) {
						list.add(info);
					}
				} else {
					list.add(info);
				}
			} else if (file.isDirectory()) {
				list.addAll(dceFileinfo(file.getAbsolutePath(), filename));
			}
		}
		return list;
	}

	/**
	 * @throws SQLException
	 */
	public void find2() throws SQLException {
		Connection conn = MysqlConnUtils.getConnection();
		Statement st = conn.createStatement();
		ResultSet re = st.executeQuery("select * from application.addr_instro");
		while (re.next()) {
			AddrInstro instro = new AddrInstro();
			instro.setUuid(re.getString("uuid"));
			instro.setMd5(re.getString("主键"));
			instro.setWebname(re.getString("网站"));
			instro.setName(re.getString("资料名称"));
			instro.setWebaddr(re.getString("地址"));
			instro.setLabel(re.getString("日期"));
			instro.setInstro(re.getString("简介"));
			instro.setLabeltype(re.getString("分类"));
			instro.setContext(re.getString("内容"));
			instro.setFileaddr(re.getString("ADDR"));
			instro.setFilename(re.getString("FILE_NAME"));
			addrInstroDao.save(instro);
		}
		
	}

	/**
	 * @param info
	 * @return
	 */
	public Page<FileInfo> page(Pagination<FileInfo> info) {
		Example.of(info.getInfo());
		if (info.getSortName() != null) {
			Order order = Order.asc(info.getSortName());
			Sort sort = Sort.by(order);
			PageRequest request = PageRequest.of(info.getPageNumber() - 1, info.getPageSize(), sort);
			return videoDao.findAll(new Specification<FileInfo>() {
				/**
				 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
				 */
				private static final long serialVersionUID = 1L;
				
				@Override
				public Predicate toPredicate(Root<FileInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<>();
					list.add(cb.like(root.get("fileName").as(String.class), "%" + info.getInfo().getFileName() + "%"));
					return cb.and(list.toArray(new Predicate[list.size()]));
				}
			}, request);
		} else {
			PageRequest request = PageRequest.of(info.getPageNumber() - 1, info.getPageSize());
			return videoDao.findAll(new Specification<FileInfo>() {
				/**
				 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
				 */
				private static final long serialVersionUID = 1L;
				
				@Override
				public Predicate toPredicate(Root<FileInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<>();
					list.add(cb.like(root.get("fileName").as(String.class), "%" + info.getInfo().getFileName() + "%"));
					return cb.and(list.toArray(new Predicate[list.size()]));
				}
			}, request);
		}
		
	}

	/**
	 * @param info
	 * @return
	 */
	public AddrInstro findOne(AddrInstro info) {
		Example<AddrInstro> example = Example.of(info);
		Optional<AddrInstro> optional = addrInstroDao.findOne(example);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
}
