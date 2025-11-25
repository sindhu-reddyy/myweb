import java.util.*;

class BookRes {
    String title;
    boolean isIssued = false;
    Queue<String> reservationQueue = new LinkedList<>();

    BookRes(String title) { this.title = title; }
}

public class Reservation {
    static Map<String, BookRes> books = new HashMap<>();

    static void addBook(String title) {
        books.put(title, new BookRes(title));
    }

    static void borrowBook(String student, String title) {
        BookRes b = books.get(title);
        if (b.isIssued) {
            System.out.println(title + " already issued! Added " + student + " to waitlist.");
            b.reservationQueue.add(student);
            return;
        }
        b.isIssued = true;
        System.out.println(student + " borrowed " + title);
    }

    static void returnBook(String title) {
        BookRes b = books.get(title);
        if (!b.isIssued) return;
        b.isIssued = false;
        if (!b.reservationQueue.isEmpty()) {
            String nextStudent = b.reservationQueue.poll();
            System.out.println("Book available for " + nextStudent);
        } else {
            System.out.println(title + " is now available for borrowing.");
        }
    }

    public static void main(String[] args) {
        addBook("Java Fundamentals");
        borrowBook("Sindhu", "Java Fundamentals");
        borrowBook("Rahul", "Java Fundamentals");
        borrowBook("Riya", "Java Fundamentals");

        returnBook("Java Fundamentals");
        returnBook("Java Fundamentals");
    }
}
