package com.maciej.imiela.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

    @Id
    @org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private Integer id;

    private String title;

    private String description;

    private String link;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @Column(name = "published_date")
    private Date publishedDate;

    public Blog getBlog() {
        return this.blog;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getId() {
        return this.id;
    }

    public String getLink() {
        return this.link;
    }

    public Date getPublishedDate() {
        return this.publishedDate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPublishedDate(Date publishDate) {
        this.publishedDate = publishDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
