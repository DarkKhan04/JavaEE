package kz.bitlab.techorda.db;

import java.util.ArrayList;
import java.util.stream.Stream;

public class DBManager {

    private static final ArrayList<Book> books = new ArrayList<>();
    private static int id = 6;


    static{
        books.add(
                new Book(1,
                        "Harry Potter and Philosophy Stone",
                        "Joane Rowling",
                        "Fantasy",
                        5000,
                        "First part of Harry Potter books"
                )
        );
        books.add(
                new Book(2,
                        "Harry Potter and Azkaban Prisoner",
                        "Joane Rowling",
                        "Fantasy",
                        6000,
                        "Part about Sirius Black"
                )
        );
        books.add(
                new Book(3,
                        "Twilight",
                        "Stefano Mayer",
                        "Fantasy",
                        7000,
                        "Oborotender koroche"
                )
        );
        books.add(
                new Book(4,
                        "Abay Zholy",
                        "Mukhtar Auezov",
                        "Roman",
                        50000,
                        "legend book about legend"
                )
        );
        books.add(
                new Book(5,
                        "I am Zlatan",
                        "Zlatan Ibrahimovich",
                        "Biography",
                        8000,
                        "bio go krch"
                )
        );
    }

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
