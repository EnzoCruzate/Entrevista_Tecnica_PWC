package Service;

import Entity.Book;
import Entity.Employee;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class serviceImplementUser implements serviceUser{
    Scanner scanner = new Scanner(System.in);
    ArrayList<User> userList = new ArrayList<User>();

    @Override
    public void userCreate() {
        User user = new User();
        userList.clear();

        System.out.println("Ingrese el nombre del usuario: ");
        user.setName(scanner.nextLine());

        System.out.println("Ingrese el apellido del usuario: ");
        user.setSurname(scanner.nextLine());

        System.out.println("Ingrese el número de identificación del usuario: ");
        user.setIdentificacionNumber(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el estado civil del usuario: ");
        user.setMaritalStatus(scanner.nextLine());

        System.out.println("Ingrese el número de cliente: ");
        user.setNumberClient(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el número de libros rentados: ");
        user.setRentedBooks(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el total de libros rentados: ");
        user.setTotalBooksRented(scanner.nextInt());
        scanner.nextLine();

        userList.add(user);
    }

    @Override
    public void userRegistration() {
        Connection connection = null;

        userCreate();

        try {
            connection = dbConnection.getdbConnection();

            String sqlPeople = "INSERT INTO People (name, surname, identificacionNumber, maritalStatus) " +
                    "VALUES ('" + userList.get(0).getName() + "', '" + userList.get(0).getSurname() + "', '" +
                    userList.get(0).getIdentificacionNumber() + "', '" + userList.get(0).getMaritalStatus() + "')";

            PreparedStatement statementPeople = connection.prepareStatement(sqlPeople);
            statementPeople.executeUpdate();


            String sqlUser = "INSERT INTO User (numberClient, rentedBooks, totalBooksRented, people_idPeople) " +
                    "VALUES ('" + userList.get(0).getNumberClient() + "', '" + userList.get(0).getRentedBooks() + "', '" +
                    userList.get(0).getTotalBooksRented() + "', LAST_INSERT_ID())";

            PreparedStatement statementUser = connection.prepareStatement(sqlUser);
            statementUser.executeUpdate();

            System.out.println("El usuario se cargo correctamente.");

            dbConnection.closedb(connection);
        } catch (SQLException e) {
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }

    }

    @Override
    public void displayUserAll() {
        Connection connection = null;
        userList.clear();

        try {

            connection = dbConnection.getdbConnection();
            String sql = "SELECT u.*, p.name, p.surname, p.identificacionNumber, p.maritalStatus " +
                    "FROM user u " + "JOIN people p ON u.people_idpeople = p.idpeople ";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setNumberClient(resultSet.getInt("numberClient"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setIdentificacionNumber(resultSet.getInt("identificacionNumber"));
                user.setMaritalStatus(resultSet.getString("maritalStatus"));
                user.setRentedBooks(resultSet.getInt("rentedBooks"));
                user.setTotalBooksRented(resultSet.getInt("totalBooksRented"));
                userList.add(user);
            }

            dbConnection.closedb(connection);
        } catch (SQLException e){
            System.out.println("Error al buscar los empleados en la base de datos: " + e.getMessage());
        }
        structureUserRentedBook(userList);
    }

    @Override
    public void deleteUser() {
        Connection connection = null;

        User user = new User();

        System.out.println("Ingrese el número de cliente que desea eliminar: ");
        user.setNumberClient(scanner.nextInt());

        try {
            connection = dbConnection.getdbConnection();

            String sql = "DELETE FROM user WHERE numberClient = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getNumberClient());
            statement.executeUpdate();

            System.out.println("El cliente con el número de cliente " + user.getNumberClient() + " ha sido eliminado de la base de datos.");

        } catch (SQLException e){
            System.out.println("Error al eliminar el cliente de la base de datos: " + e.getMessage());
        }
    }

    @Override
    public int parameteridpeopleUser() {
        Connection connection = null;

        int numberClient = userList.get(0).getNumberClient();

        try {
            connection = dbConnection.getdbConnection();

            String sql = "SELECT people_idPeople FROM user WHERE numberClient = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, numberClient);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                int idPeople = resultSet.getInt("people_idPeople");
                return idPeople;
            }


        } catch (SQLException e){

            System.out.println("Error al obtener la clave foránea people_idpeople: " + e.getMessage());

        }
        return 0;
    }

    @Override
    public void parameterUpdateUser() {
        User user = new User();
        userList.clear();

        System.out.println("Ingrese el número de cliente que desea actualizar: ");
        user.setNumberClient(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el nombre: ");
        user.setName(scanner.nextLine());

        System.out.println("Ingrese el apellido: ");
        user.setSurname(scanner.nextLine());

        System.out.println("Ingrese el número de identificación: ");
        user.setIdentificacionNumber(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el estado civil: ");
        user.setMaritalStatus(scanner.nextLine());

        userList.add(user);
    }

    @Override
    public void updateUser() {
        Connection connection = null;

        parameterUpdateUser();

        int idPeople = parameteridpeopleUser();


        try {
            connection = dbConnection.getdbConnection();

            String sql = "UPDATE people SET name = '" + userList.get(0).getName() + "', surname = '" + userList.get(0).getSurname() +
                    "', identificacionNumber = '" + userList.get(0).getIdentificacionNumber() + "', maritalStatus = '" + userList.get(0).getMaritalStatus() +
                    "' WHERE idpeople = '" + idPeople + "'";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            sql = "UPDATE user SET numberClient = '" + userList.get(0).getNumberClient() + "' WHERE numberClient = '" + userList.get(0).getNumberClient() + "'";

            statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            System.out.println("El cliente con el número de cleinte " + userList.get(0).getNumberClient() + " ha sido actualizado exitosamente!");


            dbConnection.closedb(connection);

        } catch (SQLException e){
            System.out.println("Error al actualizar el cliente en la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void structureUserRentedBook(List<User> userList) {
        System.out.printf("%-20s %-15s %-15s %-30s %-20s %-20s %-20s\n", "Numero de Cliente", "Nombre", "Apellido", "Numero de Identificacion", "Estado Civil", "Libros Rentados" , "Total de Libros Rentados");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (User user : userList) {
            System.out.printf("%-20d %-15s %-15s %-30d %-20s %-20d %-20d\n", user.getNumberClient(), user.getName(), user.getSurname(), user.getIdentificacionNumber(), user.getMaritalStatus(), user.getRentedBooks(), user.getTotalBooksRented());
        }
    }

    @Override
    public void displayUserRentedBook() {
        Connection connection = null;
        userList.clear();

            try {

                connection = dbConnection.getdbConnection();
                String sql = "SELECT u.*, p.name, p.surname, p.identificacionNumber, p.maritalStatus " +
                        "FROM user u " + "JOIN people p ON u.people_idpeople = p.idpeople " +
                        "WHERE u.rentedBooks > 0";

                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    User user = new User();
                    user.setNumberClient(resultSet.getInt("numberClient"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setIdentificacionNumber(resultSet.getInt("identificacionNumber"));
                    user.setMaritalStatus(resultSet.getString("maritalStatus"));
                    user.setRentedBooks(resultSet.getInt("rentedBooks"));
                    user.setTotalBooksRented(resultSet.getInt("totalBooksRented"));
                    userList.add(user);
                }

                dbConnection.closedb(connection);
            } catch (SQLException e){
                System.out.println("Error al buscar los usuarios en la base de datos: " + e.getMessage());
            }

            structureUserRentedBook(userList);
    }

}



