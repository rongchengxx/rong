package com.rcb.entity;

import java.io.Serializable;

public class Settings implements Serializable {

	
	private static final long serialVersionUID = -3832725500619470518L;
	
	private String id; //首页设置表ID varchar(32)
	private String userId;//用户ID varchar(36)
	private String title;//标题 varchar(255)
	private String logo; //logo varchar(255)
	private String uri;//域名 varchar(255)
	private String key_word;//关键字 varchar(255)
	private String contacts;//联系人 varchar(255)
	private int tel;//电话 varchar(255)
	private int phone;//手机 varchar(255)
	private int fax;//传真 varchar(255)
	private int qq;//QQ varchar(255)
	private String email;//邮箱 varchar(255)
	private String site;//地址 varchar(255)
	private String content;//内容 text
	public Settings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Settings(String id, String userId, String title, String logo, String uri, String key_word, String contacts,
			int tel, int phone, int fax, int qq, String email, String site, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.logo = logo;
		this.uri = uri;
		this.key_word = key_word;
		this.contacts = contacts;
		this.tel = tel;
		this.phone = phone;
		this.fax = fax;
		this.qq = qq;
		this.email = email;
		this.site = site;
		this.content = content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + fax;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key_word == null) ? 0 : key_word.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + phone;
		result = prime * result + qq;
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + tel;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax != other.fax)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (key_word == null) {
			if (other.key_word != null)
				return false;
		} else if (!key_word.equals(other.key_word))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (phone != other.phone)
			return false;
		if (qq != other.qq)
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (tel != other.tel)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Settings [id=" + id + ", userId=" + userId + ", title=" + title + ", logo=" + logo + ", uri=" + uri
				+ ", key_word=" + key_word + ", contacts=" + contacts + ", tel=" + tel + ", phone=" + phone + ", fax="
				+ fax + ", qq=" + qq + ", email=" + email + ", site=" + site + ", content=" + content + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getKey_word() {
		return key_word;
	}
	public void setKey_word(String key_word) {
		this.key_word = key_word;
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
	
	

}
