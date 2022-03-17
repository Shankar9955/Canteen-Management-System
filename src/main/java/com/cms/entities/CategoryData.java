/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.entities;

public class CategoryData {
	private String id;
	private String title;
	private String Desc;
	private String image;

	public CategoryData() {
	}

	public CategoryData(String id, String title, String Desc, String image) {
		this.id = id;
		this.title = title;
		this.Desc = Desc;
		this.image = image;
	}

	public CategoryData(String title, String Desc, String image) {
		this.title = title;
		this.Desc = Desc;
		this.image = image;
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

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String Desc) {
		this.Desc = Desc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CategoryData{" + "id=" + id + ", title=" + title + ", Desc=" + Desc + ", image=" + image + '}';
	}

}
