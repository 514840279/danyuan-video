package com.shumeng.application.video;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @文件名 VideoDao.java
 * @包名 com.shumeng.application.video
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年9月18日 下午3:29:11
 * @author Administrator
 * @版本 V1.0
 */
@Repository
public interface VideoDao extends JpaRepository<FileInfo, Serializable>, JpaSpecificationExecutor<FileInfo> {

}
