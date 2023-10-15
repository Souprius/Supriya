package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] book = new Book[20];

        book[0] = new Book(1, "978-1234567890", true, "John Smith", "The Secret Garden");
        book[1] = new Book(2, "978-2345678901", false, "Sarah Johnson", "To Kill A Mocking Bird");
        book[2] = new Book(3, "978-3456789012", true, "Michael Green", "Pride and Prejudice");
        book[3] = new Book(4, "978-4567890123", true, "Emily Davis", "The Great Gatsby");
        book[4] = new Book(5, "978-5678901234", false, "David Wilson", "1984");
        book[5] = new Book(6, "978-6789012345", true, "Jessica White", "To the Lighthouse");
        book[6] = new Book(7, "978-7890123456", true, "Christopher Anderson", "Brave New World");
        book[7] = new Book(8, "978-8901234567", false, "Olivia Taylor", "Moby Dick");
        book[8] = new Book(9, "978-9012345678", false, "Matthew Miller", "The Catcher in the Rye");
        book[9] = new Book(10, "978-0123456789", true, "Laura Martinez", "The Lord of the Rings");
        book[10] = new Book(11, "978-1230456789", true, "Kevin Adams", "Wuthering Heights");
        book[11] = new Book(12, "978-2341567890", true, "Hannah Garcia", "War and Peace");
        book[12] = new Book(13, "978-3452678901", true, "Samuel Robinson", "The Odyssey");
        book[13] = new Book(14, "978-4563789012", true, "Sophia Lewis", "The Hobbit");
        book[14] = new Book(15, "978-5674890123", true, "Daniel Moore", "Frankenstein");
        book[15] = new Book(16, "978-6785901234", true, "Isabella Turner", "The Alchemist");
        book[16] = new Book(17, "978-7896012345", true, "Benjamin Hall", "Alice's Adventures in Wonderland");
        book[17] = new Book(18, "978-8907123456", false, "Grace Wright", "The Road");
        book[18] = new Book(19, "978-9018234567", false, "Peter Parker", "Crime and Punishment");
        book[19] = new Book(20, "978-0129345678", false, "Ava Foster", "One Hundred Years of Solitude");

        /*boolean libraryTime = true;
        while (libraryTime) {*/

            System.out.println("Welcome to the Neighborhood Library. Please choose from the below options");
            System.out.println("1) Show available books");
            System.out.println("2) Show checked out books");
            System.out.println("3) Exit");

            System.out.println("Enter option here: ");
            String userInput = scanner.nextLine();


            String checking;


            switch (userInput) {
                case "1":

                    availableBooks(book);

                    System.out.println("Would you like to check out a book or exit? (type: check out)");
                    String answer = scanner.nextLine();

                    //trying to get check out to redirect to the method :(
                    if (answer.equalsIgnoreCase("check out")) {
                        checkOut(book);

                    } else {
                        System.exit(0);
                    }

                    break;
                case "2":

                    checkedOutBooks(book);

                    System.out.println("Would you like to check in a book? If so, please type C. If not, please type X ");
                    checking = scanner.nextLine();

                    ///want to give the option to exit, may need to refer back to home
                    if (checking.equalsIgnoreCase("C")) {
                        checkIn(book);
                    } else if (checking.equalsIgnoreCase("X")) {
                        System.out.println("Returning Home");
                        System.exit(0);



                    }
                    break;

                case "3":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please select a valid option or Exit");
            }


    }

    public static void availableBooks(Book[] book){
        for(Book b: book){
            if(!b.isCheckedOut()){
                System.out.printf("Book ID: %d, ISBN: %s, and Title: %s  ",
                        b.getId(), b.getIsbn(), b.getBookTitle());
            }
        }
    }

    public static void checkedOutBooks(Book[] book) {
        for (Book b : book) {
            if (b.isCheckedOut()) {
                System.out.printf("Book ID: %d, ISBN: %s, and Title: %s is checked out.",
                        b.getId(), b.getIsbn(), b.getBookTitle());
            }
        }

    }

    static Scanner scanner = new Scanner(System.in);

    public static void checkOut(Book[] book) {
        for (Book b : book) {

            System.out.println("What is your name? (First and Last) ");
            String newName = scanner.nextLine();

            System.out.println("What book would you like to check out?");
            String title = scanner.nextLine();

            if (!b.isCheckedOut() && b.getBookTitle().equalsIgnoreCase(title)) {

                b.checkOut(newName);

                System.out.printf("Book ID: %d, ISBN: %s and Title: %s is checked out to " + newName,
                        b.getId(), b.getIsbn(), b.getBookTitle());


            }

        }
    }
        //want to prompt user for info
        public static void checkIn (Book[]book){
            for (Book b : book) {
                System.out.println("Time to check in the book.");
                System.out.println("What is the Book ID");
                int bookID = scanner.nextInt();
                    //ensures that can only check in a book that is checked out
                if (b != null && bookID == b.getId() && b.isCheckedOut()) {
                    b.checkIn();
                    System.out.printf("The Book ID %d has been checked in.", b.getId());
                }
            }

        }
}