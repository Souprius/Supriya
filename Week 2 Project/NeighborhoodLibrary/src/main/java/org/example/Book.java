package org.example;

public class Book {
    private int id;
    private String isbn;
    private boolean isCheckedOut;
    private String checkedOutTo;
    private String bookTitle;
    private String name;

    public Book(int id, String isbn, boolean isCheckedOut, String checkedOutTo, String bookTitle) {
        this.id = id;
        this.isbn = isbn;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
        this.bookTitle = bookTitle;
    }


    public void checkOut(String name){
        if(!isCheckedOut){
            isCheckedOut = true;
            checkedOutTo = name;
            //bookTitle = title;
        }
    }

    public void checkIn(){
        if(isCheckedOut){
            isCheckedOut = false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
