package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BookServ implements BookService{
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String BLACK = "\u001B[30m";
    Scanner sc= new Scanner(System.in);
    Validator validator = new Validator();

    List<Book> books = new ArrayList<>();

    @Override
    public void addBook() {
        String bookid = validator.validateId();
        String Authour = validator.validateAuthor("Author");
        String Title = validator.validateAuthor("Title");
        String year = validator.validatePublishYear();
        Book book = new Book(bookid, Authour, Title, year, "Available");
        books.add(book);
        System.out.println(GREEN + "Book added Successfully !!!" + RESET);
    }

    @Override
    public void showAllAvailableBooks() {
        boolean flag = false;
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.format(CYAN + "%s%15s%15s%15s%15s", "ID", "TITLE", "AUTHOR", "PUBLISH", "STATUS"+RESET);
        System.out.println("\n-------------------------------------------------------------------------------");

        for (Book book: books) {
            if(Objects.equals(book.getStatus(), "Available")) {
                System.out.format("%s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getStatus());
                System.out.println();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println(RED+ "There are no Books in Library" + RESET);
        }
    }

    @Override
    public void borrowBook() {
        String bookid = validator.validateId();
        boolean flag = false;
        for (Book book:books) {
            if (book.getId().equals(bookid) && book.getStatus().equals("Available")) {
                flag = true;
                System.out.println(GREEN + "Book Borrowed Successfully !!!" + RESET);
                book.setStatus("Not Available");
                System.out.println("Borrowed Book Details: "+ book);
            }
        }
        if (!flag) {
            System.out.println(RED + "This book is not available to borrow" + RESET);
        }
    }

    @Override
    public void returnBook() {
        String bookid = validator.validateId();
        boolean flag = false;
        for (Book book:books) {
            if (book.getId().equals(bookid) && book.getStatus().equals("Available")) {
                flag = true;
                System.out.println(GREEN + "Book returned Successfully !!!" + RESET);
                book.setStatus("Available");
                System.out.println("Returned Book Details: "+ book);
            }
        }
        if (!flag) {
            System.out.println(RED + "We can not return this book"+ bookid + RESET);
        }
    }

    @Override
    public void showAllBooksWeHave() {
        boolean flag = false;
        System.out.println("\n-------------------------------------------------------------------------------");
        System.out.format(CYAN + "%15s%15s%15s", "TITLE", "AUTHOR", "PUBLISH"+RESET);
        System.out.println("\n-------------------------------------------------------------------------------");

        for (Book book: books) {
            System.out.format("%15s%15s%15s", book.getTitle(),book.getAuthor(),book.getPublishYear());
            System.out.println();
            flag = true;
        }
        if (!flag) {
            System.out.println(RED+ "There are no Books in Library yet" + RESET);
        }
    }
}
