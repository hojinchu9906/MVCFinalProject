package com.news.dao;

import javax.xml.bind.annotation.XmlElement;

public class Item {
   private String title;
   private String description;
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
   
}
