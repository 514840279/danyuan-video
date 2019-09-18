package com.shumeng.application.video;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @文件名 FileInfo.java
 * @包名 com.shumeng.application.video
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年9月18日 上午10:21:00
 * @author Administrator
 * @版本 V1.0
 */
@Entity
public class FileInfo {
	@Id
	private String	uuid;
	private String	fileName;
	private String	filePath;
	private Long	size;
	private String	img;
	private String	instro;
	private String	label;
	private String	mimetype;
	private Date	createDate;

	/**
	 * @方法名 getMimetype
	 * @功能 返回变量 mimetype 的值
	 * @return String
	 */
	public String getMimetype() {
		return mimetype;
	}

	/**
	 * @方法名 setMimetype
	 * @功能 设置变量 mimetype 的值
	 */
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	/**
	 * @方法名 getUuid
	 * @功能 返回变量 uuid 的值
	 * @return String
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * @方法名 setUuid
	 * @功能 设置变量 uuid 的值
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * @方法名 getFileName
	 * @功能 返回变量 fileName 的值
	 * @return String
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * @方法名 setFileName
	 * @功能 设置变量 fileName 的值
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * @方法名 getFilePath
	 * @功能 返回变量 filePath 的值
	 * @return String
	 */
	public String getFilePath() {
		return filePath;
	}
	
	/**
	 * @方法名 setFilePath
	 * @功能 设置变量 filePath 的值
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * @方法名 getSize
	 * @功能 返回变量 size 的值
	 * @return String
	 */
	public Long getSize() {
		return size;
	}
	
	/**
	 * @方法名 setSize
	 * @功能 设置变量 size 的值
	 */
	public void setSize(Long size) {
		this.size = size;
	}
	
	/**
	 * @方法名 getImg
	 * @功能 返回变量 img 的值
	 * @return String
	 */
	public String getImg() {
		return img;
	}
	
	/**
	 * @方法名 setImg
	 * @功能 设置变量 img 的值
	 */
	public void setImg(String img) {
		this.img = img;
	}
	
	/**
	 * @方法名 getInstro
	 * @功能 返回变量 instro 的值
	 * @return String
	 */
	public String getInstro() {
		return instro;
	}
	
	/**
	 * @方法名 setInstro
	 * @功能 设置变量 instro 的值
	 */
	public void setInstro(String instro) {
		this.instro = instro;
	}
	
	/**
	 * @方法名 getLabel
	 * @功能 返回变量 label 的值
	 * @return String
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * @方法名 setLabel
	 * @功能 设置变量 label 的值
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * @方法名 getCreateDate
	 * @功能 返回变量 createDate 的值
	 * @return Date
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * @方法名 setCreateDate
	 * @功能 设置变量 createDate 的值
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 * @params @param uuid
	 * @author Administrator
	 * @throws
	 */
	public FileInfo(String uuid) {
		super();
		this.uuid = uuid;
	}
	
	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 * @params
	 * @author Administrator
	 * @throws
	 */
	public FileInfo() {
		super();
	}
	
	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @方法名 toString
	 * @参数 @return
	 * @参考 @see java.lang.Object#toString()
	 * @author Administrator
	 */

	@Override
	public String toString() {
		return "FileInfo [uuid=" + uuid + ", fileName=" + fileName + ", filePath=" + filePath + ", size=" + size + ", img=" + img + ", instro=" + instro + ", label=" + label + ", mimetype=" + mimetype + ", createDate=" + createDate + "]";
	}
	
}
