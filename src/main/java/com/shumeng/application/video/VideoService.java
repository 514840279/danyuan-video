/**
 * 文件名：SysPlantChartDimensionDataService.java 版本信息： 日期：2018年5月22日 Copyright 足下 Corporation 2018 版权所有
 */
package com.shumeng.application.video;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
	
}
