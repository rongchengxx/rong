package com.rcb.entity;

import java.io.Serializable;

public class Gbook implements Serializable{

	private static final long serialVersionUID = -7014995130366848973L;
	private String id;//留言ID  varchar(32)
	private String name;//留言人名字 varchar(255)
	private String tel;//电话 varchar(255)
	private String mail;//邮箱 varchar(255)
	private String others;//其他 varchar(255)
	private String content;//内容 text
	private String time;//留言时间 datetime
	public Gbook() {
		// TODO Auto-generated constructor stub
	}
	public Gbook(String id, String name, String tel, String mail, String others, String content, String time) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.mail = mail;
		this.others = others;
		this.content = content;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
		Gbook other = (Gbook) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Gbook [id=" + id + ", name=" + name + ", tel=" + tel + ", mail=" + mail + ", others=" + others
				+ ", content=" + content + ", time=" + time + "]";
	}
	
	
	
}
