package Entity;

public class Book {
    private int idBook;
    private String title;
    private String gender;
    private String author;
    private int yearPublication;
    private boolean state;
    private int user_numberClient;

    private User user;

    public Book() {

    }

    public Book(int idBook) {
        this.idBook = idBook;
    }

    public Book(String title, String gender, String author, int yearPublication, boolean state) {
        this.title = title;
        this.gender = gender;
        this.author = author;
        this.yearPublication = yearPublication;
        this.state = state;
    }

    public Book(int idBook, String title, String gender, String author, int yearPublication, boolean state) {
        this.idBook = idBook;
        this.title = title;
        this.gender = gender;
        this.author = author;
        this.yearPublication = yearPublication;
        this.state = state;
    }

    public Book(int idBook, String title, String gender, String author, int yearPublication, boolean state, int user_numberClient) {
        this.idBook = idBook;
        this.title = title;
        this.gender = gender;
        this.author = author;
        this.yearPublication = yearPublication;
        this.state = state;
        this.user_numberClient = user_numberClient;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public boolean isState() {
        return state;
    }


    public void setState(boolean state) {
        this.state = state;
    }

    public int getUser_numberClient() {
        return user_numberClient;
    }

    public void setUser_numberClient(int user_numberClient) {
        this.user_numberClient = user_numberClient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
