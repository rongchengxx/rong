package com.rcb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SinglePage implements Serializable {

	private static final long serialVersionUID = -3055776793344637667L;

	private String id;//id varchar(32)
	private String oneMenuId;//一级菜单id varchar(32)
	private String twoMenuId;//二级菜单id varchar(32)
	private String title;//标题 varchar(255)
	private String picture;//图片 varchar(255);
	private String sortTitle;//分类标题 varchar(255)
	private String narration;//描述 varchar(255)
	private String content;//内容 text
	private String keyWord;//关键词 varchar(255)
	private String keyWordTitle;//关键词标题 varchar(255)
	private String keyWordDesc;//关键词描述
	private int seq;//排序 int(1)
	private Timestamp createTime;//创建时间 datetime
	private Timestamp changeTime;//更改时间 datetime
	private String author;//作者 varchar(255)
	private int clicks;//点击量 int(11)
	private int isshow;//是否显示 int(1)
	
	public SinglePage(String id, String oneMenuId, String twoMenuId, String title, String picture, String sortTitle,
			String narration, String content, String keyWord, String keyWordTitle, String keyWordDesc, int seq,
			Timestamp createTime, Timestamp changeTime, String author, int clicks, int isshow) {
		super();
		this.id = id;
		this.oneMenuId = oneMenuId;
		this.twoMenuId = twoMenuId;
		this.title = title;
		this.picture = picture;
		this.sortTitle = sortTitle;
		this.narration = narration;
		this.content = content;
		this.keyWord = keyWord;
		this.keyWordTitle = keyWordTitle;
		this.keyWordDesc = keyWordDesc;
		this.seq = seq;
		this.createTime = createTime;
		this.changeTime = changeTime;
		this.author = author;
		this.clicks = clicks;
		this.isshow = isshow;
	}

	public SinglePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((changeTime == null) ? 0 : changeTime.hashCode());
		result = prime * result + clicks;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + isshow;
		result = prime * result + ((keyWord == null) ? 0 : keyWord.hashCode());
		result = prime * result + ((keyWordDesc == null) ? 0 : keyWordDesc.hashCode());
		result = prime * result + ((keyWordTitle == null) ? 0 : keyWordTitle.hashCode());
		result = prime * result + ((narration == null) ? 0 : narration.hashCode());
		result = prime * result + ((oneMenuId == null) ? 0 : oneMenuId.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + seq;
		result = prime * result + ((sortTitle == null) ? 0 : sortTitle.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((twoMenuId == null) ? 0 : twoMenuId.hashCode());
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
		SinglePage other = (SinglePage) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (changeTime == null) {
			if (other.changeTime != null)
				return false;
		} else if (!changeTime.equals(other.changeTime))
			return false;
		if (clicks != other.clicks)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isshow != other.isshow)
			return false;
		if (keyWord == null) {
			if (other.keyWord != null)
				return false;
		} else if (!keyWord.equals(other.keyWord))
			return false;
		if (keyWordDesc == null) {
			if (other.keyWordDesc != null)
				return false;
		} else if (!keyWordDesc.equals(other.keyWordDesc))
			return false;
		if (keyWordTitle == null) {
			if (other.keyWordTitle != null)
				return false;
		} else if (!keyWordTitle.equals(other.keyWordTitle))
			return false;
		if (narration == null) {
			if (other.narration != null)
				return false;
		} else if (!narration.equals(other.narration))
			return false;
		if (oneMenuId == null) {
			if (other.oneMenuId != null)
				return false;
		} else if (!oneMenuId.equals(other.oneMenuId))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (seq != other.seq)
			return false;
		if (sortTitle == null) {
			if (other.sortTitle != null)
				return false;
		} else if (!sortTitle.equals(other.sortTitle))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (twoMenuId == null) {
			if (other.twoMenuId != null)
				return false;
		} else if (!twoMenuId.equals(other.twoMenuId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SinglePage [id=" + id + ", oneMenuId=" + oneMenuId + ", twoMenuId=" + twoMenuId + ", title=" + title
				+ ", picture=" + picture + ", sortTitle=" + sortTitle + ", narration=" + narration + ", content="
				+ content + ", keyWord=" + keyWord + ", keyWordTitle=" + keyWordTitle + ", keyWordDesc=" + keyWordDesc
				+ ", seq=" + seq + ", createTime=" + createTime + ", changeTime=" + changeTime + ", author=" + author
				+ ", clicks=" + clicks + ", isshow=" + isshow + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOneMenuId() {
		return oneMenuId;
	}

	public void setOneMenuId(String oneMenuId) {
		this.oneMenuId = oneMenuId;
	}

	public String getTwoMenuId() {
		return twoMenuId;
	}

	public void setTwoMenuId(String twoMenuId) {
		this.twoMenuId = twoMenuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSortTitle() {
		return sortTitle;
	}

	public void setSortTitle(String sortTitle) {
		this.sortTitle = sortTitle;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getKeyWordTitle() {
		return keyWordTitle;
	}

	public void setKeyWordTitle(String keyWordTitle) {
		this.keyWordTitle = keyWordTitle;
	}

	public String getKeyWordDesc() {
		return keyWordDesc;
	}

	public void setKeyWordDesc(String keyWordDesc) {
		this.keyWordDesc = keyWordDesc;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Timestamp changeTime) {
		this.changeTime = changeTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getclicks() {
		return clicks;
	}

	public void setclicks(int clicks) {
		this.clicks = clicks;
	}

	public int getIsshow() {
		return isshow;
	}

	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}
	
	
}
