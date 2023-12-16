package Service;

import Entity.Book;
import Entity.Employee;
import Entity.People;
import Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class serviceImplementBook implements serviceBook {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<Book>();

    @Override
    public void bookCreate() {
        Book book = new Book();
        bookList.clear();

        System.out.println("Ingrese el titulo: ");
        book.setTitle(scanner.nextLine());

        System.out.println("Ingrese el autor: ");
        book.setAuthor(scanner.nextLine());

        System.out.println("Ingrese el género: ");
        book.setGender(scanner.nextLine());

        System.out.println("Ingrese el año de publicación: ");
        book.setYearPublication(scanner.nextInt());
        scanner.nextLine();

        System.out.println("¿El Libro está disponible? (SI=true/NO=false): ");
        book.setState(scanner.nextBoolean());

        bookList.add(book);
    }

    @Override
    public void bookRegistration() {
        Connection connection = null;

        bookCreate();

        try {
            connection = dbConnection.getdbConnection();

            String sqlBook = "INSERT INTO Book (title, author, gender, yearPublication, state) " +
                    "VALUES ('" + bookList.get(0).getTitle() + "', '" + bookList.get(0).getAuthor() + "', '" +
                    bookList.get(0).getGender() + "', '" + bookList.get(0).getYearPublication() + "', '" +
                    (bookList.get(0).isState() ? 1 : 0) + "')";

            PreparedStatement statementBook = connection.prepareStatement(sqlBook);
            statementBook.executeUpdate();


            System.out.println("El libro se cargo correctamente.");

            dbConnection.closedb(connection);
        } catch (SQLException e) {
            System.out.println("Error al cargar el libro: " + e.getMessage());
        }

    }

    @Override
    public void displayBookAll() {
        Connection connection = null;
        bookList.clear();

        try {

            connection = dbConnection.getdbConnection();
            String sql = "SELECT * FROM book";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setIdBook(resultSet.getInt("idBook"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGender(resultSet.getString("gender"));
                book.setYearPublication(resultSet.getInt("yearPublication"));
                book.setState(resultSet.getBoolean("state"));
                bookList.add(book);
            }

            dbConnection.closedb(connection);

        } catch (SQLException e){
            System.out.println("Error al buscar los libros en la base de datos: " + e.getMessage());
        }

        structureBooks(bookList);
    }

    @Override
    public void deleteBook() {
        Connection connection = null;

        Book book = new Book();

        System.out.println("Ingrese el ID del Libro que desea eliminar: ");
        book.setIdBook(scanner.nextInt());
        scanner.nextLine();

        try {
            connection = dbConnection.getdbConnection();

            String sql = "DELETE FROM book WHERE idbook = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, book.getIdBook());
            statement.executeUpdate();

            System.out.println("El libro con ID " + book.getIdBook() + " ha sido eliminado de la base de datos.");

        } catch (SQLException e){
            System.out.println("Error al eliminar el empleado de la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void parameterUpdateBook() {
        Book book = new Book();
        bookList.clear();

        System.out.println("Ingrese el ID del libro que desea actualizar: ");
        book.setIdBook(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el titulo: ");
        book.setTitle(scanner.nextLine());

        System.out.println("Ingrese el genero: ");
        book.setGender(scanner.nextLine());

        System.out.println("Ingrese el autor: ");
        book.setAuthor(scanner.nextLine());

        System.out.println("Ingrese el año de publicación: ");
        book.setYearPublication(scanner.nextInt());
        scanner.nextLine();

        bookList.add(book);
    }

    @Override
    public void updateBook() {
        Connection connection = null;

        parameterUpdateBook();


        try {
            connection = dbConnection.getdbConnection();

            String sql = "UPDATE book SET title = '" + bookList.get(0).getTitle() + "', gender = '" + bookList.get(0).getGender() +
                    "', author = '" + bookList.get(0).getAuthor() + "', yearPublication = '" + bookList.get(0).getYearPublication() +
                    "' WHERE idbook = '" + bookList.get(0).getIdBook() + "'";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();


            System.out.println("El libro con ID " + bookList.get(0).getIdBook() + " ha sido actualizado exitosamente!");


            dbConnection.closedb(connection);

        } catch (SQLException e){
            System.out.println("Error al actualizar el libro en la base de datos: " + e.getMessage());
        }
    }

    @Override
    public Book searchBook(String nameBook) {
        Connection connection = null;

        try {
            connection = dbConnection.getdbConnection();
            String sql = "SELECT * FROM book WHERE title = ?";
            PreparedStatement statementSearchBook = connection.prepareStatement(sql);

            statementSearchBook.setString(1, nameBook);
            ResultSet resultSet = statementSearchBook.executeQuery();

            if (resultSet.next()) {
                Book book = new Book();
                book.setIdBook(resultSet.getInt("idBook"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGender(resultSet.getString("gender"));
                book.setYearPublication(resultSet.getInt("yearPublication"));
                book.setState(resultSet.getBoolean("state"));
                book.setUser_numberClient(resultSet.getInt("user_numberClient"));

                dbConnection.closedb(connection);
                return book;

            } else {
                return null;
            }

        }catch (SQLException e) {
            System.out.println("Error al buscar el libro en la base de datos: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void updateStatusBook(int idBook, boolean state) {
        Connection connection = null;

        try {
            connection = dbConnection.getdbConnection();
            String sql = "UPDATE Book SET state = ? WHERE idBook = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, state);
            statement.setInt(2, idBook);
            statement.executeUpdate();

            dbConnection.closedb(connection);

        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado del libro en la base de datos: " + e.getMessage());
        }

    }

    @Override
    public void updateUser_numberClient(int idBook, int numberClient) {
        Connection connection = null;

        try {
            connection = dbConnection.getdbConnection();

            String sql = "UPDATE Book SET user_numberClient = ? WHERE idBook = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, numberClient);
            statement.setInt(2, idBook);
            statement.executeUpdate();

            dbConnection.closedb(connection);

        } catch (SQLException e) {
            System.out.println("Error al actualizar el numero de cliente del libro en la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void updateRentedBook(int numberClient) {
        Connection connection = null;

        try {
            connection = dbConnection.getdbConnection();

            String sql = "UPDATE user SET rentedBooks = rentedBooks + 1 WHERE numberClient = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, numberClient);
            statement.executeUpdate();

            dbConnection.closedb(connection);
        } catch (SQLException e){
            System.out.println("Error al actualizar la información del usuario en la base de datos: " + e.getMessage());
        }

    }

    @Override
    public void updateReturnBook(int numberClient) {
        Connection connection = null;

        try {
            connection = dbConnection.getdbConnection();

            String sql = "UPDATE user SET rentedBooks = rentedBooks - 1 WHERE numberClient = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, numberClient);
            statement.executeUpdate();

            dbConnection.closedb(connection);
        } catch (SQLException e){
            System.out.println("Error al actualizar la información del usuario en la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void updateReturnUser_numberClient(int idBook) {
        Connection connection = null;

        try {
            connection = dbConnection.getdbConnection();

            String sql = "UPDATE Book SET user_numberClient = NULL WHERE idBook = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idBook);
            statement.executeUpdate();

            dbConnection.closedb(connection);

        } catch (SQLException e){
            System.out.println("Error al actualizar el numero de cliente del libro en la base de datos: " + e.getMessage());
        }
    }

    @Override
    public int bookReturnVerification(int idBook, String nameBook, int numberClient) {
        Connection connection = null;

        try {
            connection = dbConnection.getdbConnection();

            String sql = "SELECT COUNT(*) FROM book WHERE idBook = ? AND title = ? AND user_numberClient = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idBook);
            statement.setString(2, nameBook);
            statement.setInt(3, numberClient);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("\n");
            }

            return count;

        } catch (SQLException e){
            System.out.println("Error al momento de realizar la verificación: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void updateTotalBooksRented(int numberClient) {
        Connection connection = null;

        try {
            connection = dbConnection.getdbConnection();

            String sql = "UPDATE user SET totalBooksRented = totalBooksRented + 1 WHERE numberClient = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, numberClient);
            statement.executeUpdate();

            dbConnection.closedb(connection);
        } catch (SQLException e) {
            System.out.println("Error al actualizar la información del usuario en la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void bookLoan() {

        System.out.println("Ingrese el nombre del libro que desea prestar: ");
        String nameBook = scanner.nextLine();

        System.out.println("Ingrese el número de cliente al que desea prestar el libro: ");
        int numberClient = scanner.nextInt();
        scanner.nextLine();

        Book book = searchBook(nameBook);

        if (book == null) {
            System.out.println("El libro no se encuentra en la biblioteca.");
            return;
        }

        if (book.isState()) {

            updateStatusBook(book.getIdBook(), false);

            updateUser_numberClient(book.getIdBook(), numberClient);

            updateRentedBook(numberClient);

            updateTotalBooksRented(numberClient);

        }else {
            System.out.println("El libro no está disponible para prestar.");
            return;
        }

        System.out.println("El libro se ha prestado correctamente.");

    }

    @Override
    public void bookReturn() {

            System.out.println("Ingrese el nombre del libro que desea devolver: ");
            String nameBook = scanner.nextLine();

            System.out.println("Ingrese el número de cliente que devolvió el libro: ");
            int numberClient = scanner.nextInt();
            scanner.nextLine();

            Book book = searchBook(nameBook);

            if (book == null) {
                System.out.println("El libro no se encuentra en la biblioteca.");
                return;
            }

            int count = bookReturnVerification(book.getIdBook(), nameBook, numberClient);

            if (!book.isState() && count > 0) {
                updateStatusBook(book.getIdBook(), true);

                updateReturnUser_numberClient(book.getIdBook());

                updateReturnBook(numberClient);

                System.out.println("El libro se ha devuelto correctamente.");

            } else if (book.isState()){

                System.out.println("El libro ya está disponible para prestar.");
            }else {

                System.out.println("El libro no se puede devolver porque el nombre del libro y/o el número de cliente no coinciden con los detalles de préstamo.");
            }
    }

    @Override
    public void structureBooks(List<Book> bookList) {
        System.out.printf("%-5s %-50s %-25s %-25s %-15s %-10s\n", "ID", "Título", "Autor", "Género", "Año", "Estado");

        int consoleWidth = 135;
        String line = "-".repeat(consoleWidth);
        System.out.println(line);

        for (Book book : bookList) {
            System.out.printf("%-5d %-50s %-25s %-25s %-15d %-10s\n", book.getIdBook(), book.getTitle(), book.getAuthor(), book.getGender(), book.getYearPublication(), book.isState() ? "Disponible" : "Prestado");
        }
    }

    @Override
    public void structureRentedBooks(List<Book> bookList) {
            System.out.printf("%-5s %-50s %-25s %-25s %-15s %-10s %-25s %-15s %-15s\n", "ID", "Título", "Autor", "Género", "Año", "Estado", "Número de cliente", "Nombre", "Apellido");

            int consoleWidth = 190;
            String line = "-".repeat(consoleWidth);
            System.out.println(line);

            for (Book book : bookList) {
                User user = book.getUser();

                System.out.printf("%-5d %-50s %-25s %-25s %-15d %-10s %-25d %-15s %-15s\n", book.getIdBook(), book.getTitle(), book.getAuthor(), book.getGender(), book.getYearPublication(), book.isState() ? "Disponible" : "Prestado", user.getNumberClient(), user.getName(), user.getSurname());
            }
    }

    @Override
    public void displayRentedBook() {
        Connection connection = null;
        bookList.clear();

        try {

            connection = dbConnection.getdbConnection();

            String sql = "SELECT book.idBook, book.title, book.author, book.gender, book.yearPublication, book.state, user.numberClient, people.name, people.surname " +
                    "FROM book " +
                    "JOIN user ON book.user_numberClient = user.numberClient " +
                    "JOIN people ON user.people_idPeople = people.idPeople " +
                    "WHERE book.state = false";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setIdBook(resultSet.getInt("idBook"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGender(resultSet.getString("gender"));
                book.setYearPublication(resultSet.getInt("yearPublication"));
                book.setState(resultSet.getBoolean("state"));

                User user = new User();
                user.setNumberClient(resultSet.getInt("numberClient"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));

                book.setUser(user);

                bookList.add(book);
            }

            dbConnection.closedb(connection);

        } catch (SQLException e){
            System.out.println("Error al buscar los libros en la base de datos: " + e.getMessage());
        }

        structureRentedBooks(bookList);
    }

    @Override
    public void listBookGenre() {
        Connection connection = null;
        bookList.clear();

        System.out.println("Ingrese el género: ");
        String genre = scanner.nextLine();
        System.out.println("\n");

        try {
            connection = dbConnection.getdbConnection();

            String sql = "SELECT * FROM book WHERE gender = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, genre);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setIdBook(resultSet.getInt("idBook"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setGender(resultSet.getString("gender"));
                book.setYearPublication(resultSet.getInt("yearPublication"));
                book.setState(resultSet.getBoolean("state"));
                bookList.add(book);
            }

            dbConnection.closedb(connection);

        } catch (SQLException e) {
            System.out.println("Error al buscar los libros en la base de datos: " + e.getMessage());
        }

        structureBooks(bookList);

    }

}
