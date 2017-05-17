package com.rcb.entity;

import java.io.Serializable;

public class Settings implements Serializable {

	
	private static final long serialVersionUID = -3832725500619470518L;
	
	private String id; //首页设置表ID varchar(32)
	private String title;//标题 varchar(255)
	private String logo; //logo varchar(255)
	private String uri;//域名 varchar(255)
	private String keyWord;//关键字 varchar(255)
	private String contacts;//联系人 varchar(255)
	private int tel;//电话 varchar(255)
	private int phone;//手机 varchar(255)
	private int fax;//传真 varchar(255)
	private int qq;//QQ varchar(255)
	private String email;//邮箱 varchar(255)
	private String site;//地址 varchar(255)
	private String content;//内容 text
	public Settings() {
		// TODO Auto-generated constructor stub
	}
	public Settings(String id, String title, String logo, String uri, String keyWord, String contacts, int tel, int phone,
			int fax, int qq, String email, String site, String content) {
		super();
		this.id = id;
		this.title = title;
		this.logo = logo;
		this.uri = uri;
		this.keyWord = keyWord;
		this.contacts = contacts;
		this.tel = tel;
		this.phone = phone;
		this.fax = fax;
		this.qq = qq;
		this.email = email;
		this.site = site;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getkeyWord() {
		return keyWord;
	}
	public void setkeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getFax() {
		return fax;
	}
	public void setFax(int fax) {
		this.fax = fax;
	}
	public int getQq() {
		return qq;
	}
	public void setQq(int qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Settings other = (Settings) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Settings [id=" + id + ", title=" + title + ", logo=" + logo + ", uri=" + uri + ", keyWord=" + keyWord
				+ ", contacts=" + contacts + ", tel=" + tel + ", phone=" + phone + ", fax=" + fax + ", qq=" + qq
				+ ", email=" + email + ", site=" + site + ", content=" + content + "]";
	}
	
	
	

}
