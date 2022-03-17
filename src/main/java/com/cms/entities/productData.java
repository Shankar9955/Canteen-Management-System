
package com.cms.entities;

import com.cms.Database.CategoryDatabase;



public class productData {
    
    int id;
    String title;
    String description;
    int price;
    String image;
    String Cid;
   
   CategoryDatabase category;

    public productData(String title, String description, int price, String image, String Cid) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.Cid = Cid;
    }

   
   
    public productData() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String Cid) {
        this.Cid = Cid;
    }

    public CategoryDatabase getCategory() {
        return category;
    }

    public void setCategory(CategoryDatabase category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "productData{" + "id=" + id + ", title=" + title + ", description=" + description + ", price=" + price + ", image=" + image + ", Cid=" + Cid + ", category=" + category + '}';
    }

   
  
    
    
}
