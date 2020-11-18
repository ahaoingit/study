package com.ahao.designpatterns.prototype;

import java.util.List;

/**
 * @author ahao
 */
public class Test {
    @org.junit.Test
    public void prototypeTest() throws CloneNotSupportedException {
        BookShop bookShop = new BookShop();
        bookShop.loading();
        List<Book> books = bookShop.getBooks();
        System.out.println(books.size());
    }
}
