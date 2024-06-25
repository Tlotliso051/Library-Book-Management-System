package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);
        BookService service = new BookServ();

        do{
            System.out.println("Welcome to Book Management Application System");
            System.out.println("""
                            1.Add Book
                            2. Show all Books
                            3. Show available Books
                            4.Borrow Book
                            5.Return Book
                            6.Exit
                            """
                    );
            System.out.println("Enter Your Choice !");
            int choice= sc.nextInt();
            switch (choice) {
                case 1:
                    service.addBook();
                    break;
                case 2:
                    service.showAllBooksWeHave();
                    break;
                case 3:
                    service.showAllAvailableBooks();
                    break;
                case 4:
                    service.borrowBook();
                    break;
                case 5:
                    service.returnBook();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Please choose Choice from provided options\nYou have selected invalid choice.");
                    System.out.println();
            }
        }while(true);

    }
}
