package design.mode.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appenBook(new Book("《环游世界80天》"));
        bookShelf.appenBook(new Book("《圣经》"));
        bookShelf.appenBook(new Book("《灰姑娘》"));
        bookShelf.appenBook(new Book("《白雪公主》"));
        Iterator it = bookShelf.itetator();
        while(it.hasNext()){
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
