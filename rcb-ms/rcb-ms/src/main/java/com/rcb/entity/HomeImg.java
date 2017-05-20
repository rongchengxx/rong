package com.rcb.entity;

import java.io.Serializable;

public class HomeImg implements Serializable{

	
	private static final long serialVersionUID = -2158812736253956533L;
	private String id;//首页图片表ID varchar(32)
	private String url;//图片地址 varchar(255)
	private String title;//标题 varchar(255)
	private int seq;//排序  int 11
	private int type;//类型（） int 1
	private String content;//内容 text
	private String link;//链接 varchar(255)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private int source;//来源 int 1
	private int isshow;//是否显示 int 1
	public HomeImg() {
		// TODO Auto-generated constructor stub
	}
	public HomeImg(String id, String url, String title, int seq, int type, String content, String link, int source,
			int isshow) {
		super();
		this.id = id;
		this.url = url;
		this.title = title;
		this.seq = seq;
		this.type = type;
		this.content = content;
		this.link = link;
		this.source = source;
		this.isshow = isshow;
	}
	public String getUrl() {
		return url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getIsshow() {
		return isshow;
	}
	public void setIsshow(int isshow) {
		this.isshow = isshow;
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
		HomeImg other = (HomeImg) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HomeImg [id=" + id + ", url=" + url + ", title=" + title + ", seq=" + seq + ", type=" + type
				+ ", content=" + content + ", link=" + link + ", source=" + source + ", isshow=" + isshow + "]";
	}
	
	

}
