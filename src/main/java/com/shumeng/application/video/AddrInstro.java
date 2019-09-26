/**
 *
 */
package com.shumeng.application.video;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author wth
 */
@Entity
public class AddrInstro {
	@Id
	private String	uuid;
	private String	md5;
	private String	webname;
	private String	name;
	@Column(columnDefinition = " TEXT ")
	private String	webaddr;
	private String	label;
	@Column(columnDefinition = " TEXT ")
	private String	instro;
	private String	labeltype;
	@Column(columnDefinition = "TEXT ")
	private String	context;
	@Column(columnDefinition = " TEXT ")
	private String	fileaddr;
	private String	filename;

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the md5
	 */
	public String getMd5() {
		return md5;
	}

	/**
	 * @param md5
	 *            the md5 to set
	 */
	public void setMd5(String md5) {
		this.md5 = md5;
	}

	/**
	 * @return the webname
	 */
	public String getWebname() {
		return webname;
	}

	/**
	 * @param webname
	 *            the webname to set
	 */
	public void setWebname(String webname) {
		this.webname = webname;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the webaddr
	 */
	public String getWebaddr() {
		return webaddr;
	}

	/**
	 * @param webaddr
	 *            the webaddr to set
	 */
	public void setWebaddr(String webaddr) {
		this.webaddr = webaddr;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the instro
	 */
	public String getInstro() {
		return instro;
	}

	/**
	 * @param instro
	 *            the instro to set
	 */
	public void setInstro(String instro) {
		this.instro = instro;
	}

	/**
	 * @return the labeltype
	 */
	public String getLabeltype() {
		return labeltype;
	}

	/**
	 * @param labeltype
	 *            the labeltype to set
	 */
	public void setLabeltype(String labeltype) {
		this.labeltype = labeltype;
	}

	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * @return the fileaddr
	 */
	public String getFileaddr() {
		return fileaddr;
	}

	/**
	 * @param fileaddr
	 *            the fileaddr to set
	 */
	public void setFileaddr(String fileaddr) {
		this.fileaddr = fileaddr;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
