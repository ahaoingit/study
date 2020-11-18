package com.ahao.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ahao
 */
public class BookShop implements Cloneable{
    private String bookShopName;
    private List<Book> books = new ArrayList<>();

    public BookShop(String bookShopName, List<Book> books) {
        this.bookShopName = bookShopName;
        this.books = books;
    }

    public BookShop() {
    }

    public String getBookShopName() {
        return bookShopName;
    }

    public void setBookShopName(String bookShopName) {
        this.bookShopName = bookShopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public void loading() throws CloneNotSupportedException {
        Book book = new Book();
        for (int i = 0; i < 1000 ; i++) {
            books.add((Book) book.clone());
        }
    }

    protected BookShop shallowCopy() throws CloneNotSupportedException {
        return (BookShop) super.clone();
    }
    protected BookShop DeepCopy() throws CloneNotSupportedException {
        BookShop clone = (BookShop)super.clone();
        List<Book> booksClone = new ArrayList<>();
        booksClone.addAll(this.books);
        clone.setBooks(booksClone);
        return clone;
    }
}
