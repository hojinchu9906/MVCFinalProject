package com.news.dao;
import java.util.*;
/*
 *   <rss>
 *    <channel>
 *      <item>
 *      <item>
 *    </channel>
 *   </rss>
 */
import javax.xml.bind.annotation.XmlElement;
public class Channel {
    private List<Item> item=new ArrayList<Item>();

	public List<Item> getItem() {
		return item;
	}
	@XmlElement
	public void setItem(List<Item> item) {
		this.item = item;
	}
   
}
