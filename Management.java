import java.util.*;

class Book {
    String title;
    boolean isBorrowed = false;
    Book(String title) { this.title = title; }
}

class Student {
    String name;
    int borrowLimit = 3;
    List<String> borrowedBooks = new ArrayList<>();
    List<String> history = new ArrayList<>();

    Student(String name) { this.name = name; }

    boolean canBorrow() {
        return borrowedBooks.size() < borrowLimit;
    }

    void borrowBook(Book book) {
        if (book.isBorrowed) {
            System.out.println(book.title + " is already borrowed.");
            return;
        }
        if (!canBorrow()) {
            System.out.println(name + " reached borrow limit!");
            return;
        }
        book.isBorrowed = true;
        borrowedBooks.add(book.title);
        history.add("Borrowed: " + book.title);
    }

    void returnBook(Book book) {
        if (borrowedBooks.remove(book.title)) {
            book.isBorrowed = false;
            history.add("Returned: " + book.title);
        }
    }
}

public class Management {
    static Map<String, Student> students = new HashMap<>();

    static void registerStudent(String name) {
        students.put(name, new Student(name));
        System.out.println("Registered: " + name);
    }

    static void searchStudent(String name) {
        if (students.containsKey(name))
            System.out.println("Found: " + students.get(name).name);
        else
            System.out.println("No student found with name " + name);
    }

    public static void main(String[] args) {
        registerStudent("Sindhu");
        registerStudent("Rahul");

        Book b1 = new Book("Java Basics");
        Book b2 = new Book("Python Essentials");

        Student s = students.get("Sindhu");
        s.borrowBook(b1);
        s.borrowBook(b2);
        s.returnBook(b1);

        System.out.println("Sindhu history: " + s.history);
        searchStudent("Rahul");
    }
}
