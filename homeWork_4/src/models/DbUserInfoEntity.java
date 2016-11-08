package models;

import java.util.Date;

import models.intefaces.IDbEntity;

public class DbUserInfoEntity implements IDbEntity{
	
    public int id;
    public String name;
    public Date birthday;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
