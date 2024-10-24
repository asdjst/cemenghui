package com.jst.entity;

public class Book {
    private Integer bookId;
    private String title;
    private Double price;
    private String desci;

    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDesc() {
        return desci;
    }

    public void setDesc(String desc) {
        this.desci = desc;
    }
}
