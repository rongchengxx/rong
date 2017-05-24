package com.rcb.entity;

import java.io.Serializable;

public class OneMenu implements Serializable{

	private static final long serialVersionUID = -5820435607524498598L;
	
	private String id;//id varchar(32)
	private String title;//标题 varchar(255)
	private String thumb;//略缩图 varchar(255)
	private String content;//内容 text
	private int seq;//排序 int(1)
	private int isshow;//是否显示 int(1)
	private String intro;//简介 varchar(255)
	
	public OneMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OneMenu(String id, String title, String thumb, String content, int seq, int isshow, String intro) {
		super();
		this.id = id;
		this.title = title;
		this.thumb = thumb;
		this.content = content;
		this.seq = seq;
		this.isshow = isshow;
		this.intro = intro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + isshow;
		result = prime * result + seq;
		result = prime * result + ((thumb == null) ? 0 : thumb.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		OneMenu other = (OneMenu) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (isshow != other.isshow)
			return false;
		if (seq != other.seq)
			return false;
		if (thumb == null) {
			if (other.thumb != null)
				return false;
		} else if (!thumb.equals(other.thumb))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getIsshow() {
		return isshow;
	}
	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "OneMenu [id=" + id + ", title=" + title + ", thumb=" + thumb + ", content=" + content + ", seq=" + seq
				+ ", isshow=" + isshow + ", intro=" + intro + "]";
	}
	
	
}
