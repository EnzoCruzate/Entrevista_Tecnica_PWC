package Entity;

public class User extends People {
    private int numberClient;
    private int rentedBooks;
    private int totalBooksRented;
    private int People_idPeople;


    public User() {
    }

    public User(String name, String surname, int identificacionNumber, String maritalStatus, int numberClient) {
        super(name, surname, identificacionNumber, maritalStatus);
        this.numberClient = numberClient;
    }

    public User(String name, String surname, int identificacionNumber, String maritalStatus, int numberClient, int rentedBooks, int totalBooksRented) {
        super(name, surname, identificacionNumber, maritalStatus);
        this.numberClient = numberClient;
        this.rentedBooks = rentedBooks;
        this.totalBooksRented = totalBooksRented;
    }

    public User(int numberClient, int rentedBooks, int totalBooksRented) {
        this.numberClient = numberClient;
        this.rentedBooks = rentedBooks;
        this.totalBooksRented = totalBooksRented;
    }

    public User(String name, String surname, int identificacionNumber, String maritalStatus, int numberClient, int rentedBooks, int totalBooksRented, int people_idPeople) {
        super(name, surname, identificacionNumber, maritalStatus);
        this.numberClient = numberClient;
        this.rentedBooks = rentedBooks;
        this.totalBooksRented = totalBooksRented;
        People_idPeople = people_idPeople;
    }


    public int getNumberClient() {
        return numberClient;
    }

    public void setNumberClient(int numberClient) {
        this.numberClient = numberClient;
    }

    public int getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(int rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public int getTotalBooksRented() {
        return totalBooksRented;
    }

    public void setTotalBooksRented(int totalBooksRented) {
        this.totalBooksRented = totalBooksRented;
    }

    public int getPeople_idPeople() {
        return People_idPeople;
    }

    public void setPeople_idPeople(int people_idPeople) {
        People_idPeople = people_idPeople;
    }


}
