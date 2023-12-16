package testLibrary;
import Entity.Book;
import Service.*;
import Entity.Employee;
import Service.dbConnectionTest;

import java.util.Scanner;


public class mainLibrary {
    public static void main(String[] args) {
        serviceImplementMenu servMenu = new serviceImplementMenu();

        servMenu.menuStructure();

    }
}
