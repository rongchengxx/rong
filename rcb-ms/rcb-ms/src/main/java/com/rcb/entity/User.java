package com.rcb.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = -5492885071527668287L;
	private String id;	//id varchar(32)
	private String account; //用户账号 varchar(255)
	private String password;//用户密码 varchar(255)
	public User() {
	}

public User(String id, String account, String password) {
	super();
	this.id = id;
	this.account = account;
	this.password = password;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
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
	User other = (User) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

@Override
public String toString() {
	return "User [id=" + id + ", account=" + account + ", password=" + password + "]";
}

}
