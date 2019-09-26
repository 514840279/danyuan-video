package com.shumeng.application.video;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shumeng.application.BaseResult;
import com.shumeng.application.Pagination;
import com.shumeng.application.ResultUtil;

/**
 * @文件名 VideoController.java
 * @包名 com.shumeng.application.video
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年9月18日 上午10:20:37
 * @author Administrator
 * @版本 V1.0
 */
@RestController
@RequestMapping("/video")
public class VideoController {
	@Autowired
	public VideoService videoService;

	@RequestMapping(path = "/find", method = RequestMethod.POST)
	public BaseResult<List<FileInfo>> find(@RequestBody FileInfo info) {
		try {
			List<FileInfo> list = videoService.find(info.getFilePath(), info.getFileName());
			return ResultUtil.success(list);
		} catch (Exception e) {
			return ResultUtil.error(e.getMessage());
		}
	}

	@RequestMapping(path = "/page", method = RequestMethod.POST)
	public BaseResult<Page<FileInfo>> page(@RequestBody Pagination<FileInfo> info) {
		try {
			Page<FileInfo> list = videoService.page(info);
			return ResultUtil.success(list);
		} catch (Exception e) {
			return ResultUtil.error(e.getMessage());
		}
	}
	
	@RequestMapping(path = "/findOne", method = RequestMethod.POST)
	public BaseResult<AddrInstro> findOne(@RequestBody AddrInstro info) {
		try {
			AddrInstro instro = videoService.findOne(info);
			return ResultUtil.success(instro);
		} catch (Exception e) {
			return ResultUtil.error(e.getMessage());
		}
	}
	
	@RequestMapping(path = "/find2", method = RequestMethod.GET)
	public void find2() throws SQLException {
		videoService.find2();
	}
}
