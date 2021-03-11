package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBlog;
    private String nameBlog;
    private String contentBlog;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id" , referencedColumnName = "id")
    private Category category;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }




    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(String nameBlog , String contentBlog){
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
    }

    public Blog(Integer idBlog,String nameBlog , String contentBlog){
        this.idBlog = idBlog;
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }
}
