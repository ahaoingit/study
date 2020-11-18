package com.ahao.designpatterns.prototype;

/**
 * @author ahao
 */
public class Book implements Cloneable{
    private String name;
    private String price;
    private Integer page;

    public Book() {
    }

    public Book(String name, String price, Integer page) {
        this.name = name;
        this.price = price;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
