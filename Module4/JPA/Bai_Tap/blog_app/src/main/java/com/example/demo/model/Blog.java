package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBlog;
    private String nameBlog;
    private String contentBlog;

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
