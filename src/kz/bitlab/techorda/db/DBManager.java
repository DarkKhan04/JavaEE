package kz.bitlab.techorda.db;

import java.util.ArrayList;
import java.util.stream.Stream;

public class DBManager {

    private static final ArrayList<Book> books = new ArrayList<>();
    private static int id = 6;


    
    public static ArrayList<Book> getBooks(){
        return books;
    }

    public static void addBook(Book book){
        books.add(book);
        book.setId(id);
        id++;
    }

    public static Book getBook(int id){
        return books.stream().filter(book -> book.getId()==id).findFirst().orElse(null);
    }

    public static void Update(Book book){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId()==book.getId()){
                books.set(i, book);
                break;
            }
        }
    }

    public static void deleteBook(int id){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId()==id){
                books.remove(i);
                break;
            }
        }
    }
}
