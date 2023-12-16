package Service;

import java.util.*;

import Entity.Book;
import Entity.Employee;
import Entity.People;
import Entity.User;

import java.sql.*;
public class serviceImplementEmployee implements serviceEmployee {
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    Scanner scanner = new Scanner(System.in);


    @Override

    public void employeeCreate() {
        Employee employee = new Employee();

        employeeList.clear();

        System.out.println("Ingrese el nombre del empleado: ");
        employee.setName(scanner.nextLine());

        System.out.println("Ingrese el apellido del empleado: ");
        employee.setSurname(scanner.nextLine());

        System.out.println("Ingrese el número de identificación del empleado: ");
        employee.setIdentificacionNumber(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el año de incorporacion del empleado: ");
        employee.setYearIncorporation(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el estado civil del empleado: ");
        employee.setMaritalStatus(scanner.nextLine());

        System.out.println("Ingrese el sector del empleado: ");
        employee.setSector(scanner.nextLine());

        employeeList.add(employee);

    }


    @Override
    public void employeeRegistration() {
        Connection connection = null;

        employeeCreate();

        try {
            connection = dbConnection.getdbConnection();

            String sqlPeople = "INSERT INTO People (name, surname, identificacionNumber, maritalStatus) " +
                    "VALUES ('" + employeeList.get(0).getName() + "', '" + employeeList.get(0).getSurname() + "', '" +
                    employeeList.get(0).getIdentificacionNumber() + "', '" + employeeList.get(0).getMaritalStatus() + "')";

            PreparedStatement statementPeople = connection.prepareStatement(sqlPeople);
            statementPeople.executeUpdate();


            String sqlEmployee = "INSERT INTO Employee (yearIncorporation, sector, people_idpeople) " +
                    "VALUES ('" + employeeList.get(0).getYearIncorporation() + "', '" +
                    employeeList.get(0).getSector() + "', LAST_INSERT_ID())";

            PreparedStatement statementEmployee = connection.prepareStatement(sqlEmployee);
            statementEmployee.executeUpdate();

            System.out.println("El empleado se cargo correctamente.");

            dbConnection.closedb(connection);
        } catch (SQLException e) {
            System.out.println("Error al guardar el empleado: " + e.getMessage());
        }

    }

    @Override
    public void structureDisplayEmployeeAll(List<Employee> employeeList) {
        System.out.printf("%-5s %-15s %-15s %-30s %-20s %-30s %-20s\n", "ID", "Nombre", "Apellido", "Numero de Identificacion", "Estado Civil", "Año de Incorporación" , "Sector");

        int consoleWidth = 130;
        String line = "-".repeat(consoleWidth);
        System.out.println(line);

        for (Employee employee : employeeList) {
            System.out.printf("%-5d %-15s %-15s %-30d %-20s %-30d %-20s\n", employee.getIdEmployee(), employee.getName(), employee.getSurname(), employee.getIdentificacionNumber(), employee.getMaritalStatus(), employee.getYearIncorporation(), employee.getSector());
        }
    }

    @Override
    public void displayEmployeeAll() {
        Connection connection = null;
        employeeList.clear();

        try {

            connection = dbConnection.getdbConnection();
            String sql = "SELECT e.*, p.name, p.surname, p.identificacionNumber, p.maritalStatus " +
                    "FROM employee e " + "JOIN people p ON e.people_idpeople = p.idpeople ";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setIdEmployee(resultSet.getInt("idEmployee"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setIdentificacionNumber(resultSet.getInt("identificacionNumber"));
                employee.setMaritalStatus(resultSet.getString("maritalStatus"));
                employee.setYearIncorporation(resultSet.getInt("yearIncorporation"));
                employee.setSector(resultSet.getString("sector"));
                employeeList.add(employee);
            }

            dbConnection.closedb(connection);
        } catch (SQLException e){
            System.out.println("Error al buscar los empleados en la base de datos: " + e.getMessage());
        }
        structureDisplayEmployeeAll(employeeList);
    }

    @Override
    public void deleteEmployee() {
        Connection connection = null;

        Employee employee = new Employee();

        System.out.println("Ingrese el ID del empleado que desea eliminar: ");
        employee.setIdEmployee(scanner.nextInt());
        scanner.nextLine();

        try {
            connection = dbConnection.getdbConnection();

            String sql = "DELETE FROM employee WHERE idEmployee = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employee.getIdEmployee());
            statement.executeUpdate();

            System.out.println("El empleado con ID " + employee.getIdEmployee() + " ha sido eliminado de la base de datos.");

        } catch (SQLException e){
            System.out.println("Error al eliminar el empleado de la base de datos: " + e.getMessage());
        }

    }

    @Override
    public int parameteridpeopleEmployee() {
        Connection connection = null;

        int idEmployee = employeeList.get(0).getIdEmployee();

         try {
             connection = dbConnection.getdbConnection();

             String sql = "SELECT people_idPeople FROM employee WHERE idEmployee = ?";

             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setInt(1, idEmployee);
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
    public void updateEmployee() {
        Connection connection = null;
        int idPeople = 0;

        parameterUpdateEmployee();
        idPeople = parameteridpeopleEmployee();


        try {
            connection = dbConnection.getdbConnection();

            String sql = "UPDATE people SET name = '" + employeeList.get(0).getName() + "', surname = '" + employeeList.get(0).getSurname() +
                    "', identificacionNumber = '" + employeeList.get(0).getIdentificacionNumber() + "', maritalStatus = '" + employeeList.get(0).getMaritalStatus() +
                    "' WHERE idPeople = '" + idPeople + "'";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            sql = "UPDATE employee SET yearIncorporation = '" + employeeList.get(0).getYearIncorporation() + "', sector = '" +
                    employeeList.get(0).getSector() + "' WHERE idemployee = '" + employeeList.get(0).getIdEmployee() + "'";

            statement = connection.prepareStatement(sql);
            statement.executeUpdate();

            System.out.println("El empleado con ID " + employeeList.get(0).getIdEmployee() + " ha sido actualizado exitosamente!");


            dbConnection.closedb(connection);

        } catch (SQLException e){
            System.out.println("Error al actualizar el empleado en la base de datos: " + e.getMessage());
        }

    }

    @Override
    public void parameterUpdateEmployee() {
        Employee employee = new Employee();
        employeeList.clear();

        System.out.println("Ingrese el ID del empleado que desea actualizar: ");
        employee.setIdEmployee(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el nombre: ");
        employee.setName(scanner.nextLine());

        System.out.println("Ingrese el apellido: ");
        employee.setSurname(scanner.nextLine());

        System.out.println("Ingrese el número de identificación: ");
        employee.setIdentificacionNumber(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el estado civil: ");
        employee.setMaritalStatus(scanner.nextLine());

        System.out.println("Ingrese el año de incorporación: ");
        employee.setYearIncorporation(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Ingrese el sector: ");
        employee.setSector(scanner.nextLine());

        employeeList.add(employee);


    }
}
