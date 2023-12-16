package Service;

import Entity.Book;
import Entity.User;

import java.util.List;

public interface serviceUser {

    public abstract void userRegistration();
    public abstract void userCreate();
    public abstract void displayUserAll();
    public abstract void deleteUser();
    public abstract void displayUserRentedBook();
    public abstract void structureUserRentedBook(List<User> rentedUserBook);
    public abstract void updateUser();
    public abstract void parameterUpdateUser();
    public abstract int parameteridpeopleUser();
}
