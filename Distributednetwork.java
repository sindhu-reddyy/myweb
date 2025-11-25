import java.util.*;

class BookD {
    String title;
    boolean isIssued = false;
    BookD(String title) { this.title = title; }
}

class Library {
    String name;
    Map<String, BookD> books = new HashMap<>();

    Library(String name) { this.name = name; }

    void addBook(String title) {
        books.put(title, new BookD(title));
    }

    BookD findBook(String title) {
        return books.get(title);
    }

    void borrowBook(String title) {
        BookD b = books.get(title);
        if (b == null) System.out.println("Book not found in " + name);
        else if (b.isIssued) System.out.println("Already issued.");
        else {
            b.isIssued = true;
            System.out.println("Borrowed " + title + " from " + name);
        }
    }
}

public class Distributednetwork {
    static List<Library> libraries = new ArrayList<>();

    static void addLibrary(Library lib) {
        libraries.add(lib);
    }

    static void searchBook(String title) {
        for (Library lib : libraries) {
            if (lib.findBook(title) != null)
                System.out.println(title + " found in " + lib.name);
        }
    }

    static void transferBook(String title, Library from, Library to) {
        BookD b = from.findBook(title);
        if (b != null && !b.isIssued) {
            from.books.remove(title);
            to.addBook(title);
            System.out.println("Transferred " + title + " from " + from.name + " to " + to.name);
        }
    }

    public static void main(String[] args) {
        Library cs = new Library("CS Library");
        Library mech = new Library("ME Library");

        cs.addBook("Java");
        mech.addBook("Thermodynamics");

        addLibrary(cs);
        addLibrary(mech);

        searchBook("Java");
        transferBook("Thermodynamics", mech, cs);
        searchBook("Thermodynamics");
    }
}
