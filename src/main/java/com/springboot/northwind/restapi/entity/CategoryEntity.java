package com.springboot.northwind.restapi.entity;
import lombok.Data;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name="Categories")
public class CategoryEntity implements Serializable {
//compositvd entity
public CategoryEntity(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer CategoryID;

    @Column(name = "CategoryName")
    private String CategoryName;

    @Column(name = "Description")
    private String Description;
    @Column(name = "Picture")
    private byte[] Picture;
    // Getters and setters

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public byte[] getPicture() {
        return Picture;
    }

    public void setPicture(byte[] picture) {
        Picture = picture;
    }
}
