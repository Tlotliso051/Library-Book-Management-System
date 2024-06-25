package src;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0M";
    private static final Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static final Pattern authorTitle_Pttern = Pattern.compile("^[a-zA-Z]+$");
    private static final Pattern PublishYear_Pattern = Pattern.compile("^\\d{4}$");

    Scanner sc = new Scanner(System.in);

    public String validateId() {
        String bookid;
        while (true) {
            System.out.println("Enter Book ID ");
            bookid = sc.nextLine();
            if (!ID_PATTERN.matcher(bookid).matches()) {
                System.out.println(RED + "SORRY ! PLEASE ENTER VALID BOOK ID \"4 Digits\" " + RESET);
            } else {
                break;
            }
        }
        return bookid;
    }

    public String validateAuthor(String input) {
        String bookauthor;
        while (true) {
            if (Objects.equals(input, "Title")) {
                System.out.println("Enter Title ");
            } else {
                System.out.println("Enter Author");
            }

            bookauthor = sc.nextLine();
            if (!authorTitle_Pttern.matcher(bookauthor).matches()) {
                System.out.println(RED + "Please Enter Valid " + input + RESET);
            } else {
                break;
            }

        }
        return bookauthor;
    }

    public String validatePublishYear() {
        String publishYear;
        while (true) {
            System.out.println("Enter publish year ");
            publishYear = sc.nextLine();
            if (!PublishYear_Pattern.matcher(publishYear).matches()) {
                System.out.println(RED + "SORRY ! ENTER CORRECT PUBLISH YEAR" + RESET);
            } else {
                break;
            }
        }
        return publishYear;
    }
}
