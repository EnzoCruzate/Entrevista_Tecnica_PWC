package Service;

import Entity.Book;

import java.util.List;

public interface serviceBook {

    public abstract void bookRegistration();
    public abstract void bookCreate();
    public abstract void displayBookAll();
    public abstract void deleteBook();
    public abstract void updateBook();
    public abstract void parameterUpdateBook();
    public abstract Book searchBook(String nameBook);
    public abstract void updateStatusBook(int idBook, boolean state);
    public abstract void updateUser_numberClient(int idBook, int numberClient);
    public abstract void updateReturnUser_numberClient(int idBook);
    public abstract void updateRentedBook(int numberClient);
    public abstract void updateReturnBook(int numberClient);
    public abstract int bookReturnVerification(int idBook, String nameBook, int numberClient);
    public abstract void updateTotalBooksRented(int numberClient);
    public abstract void bookLoan();
    public abstract void bookReturn();
    public abstract void displayRentedBook();
    public abstract void structureBooks(List<Book> bookList);
    public abstract void structureRentedBooks(List<Book> bookList);
    public abstract void listBookGenre();


}
