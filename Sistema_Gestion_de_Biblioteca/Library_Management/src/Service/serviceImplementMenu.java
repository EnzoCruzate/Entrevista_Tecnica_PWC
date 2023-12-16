package Service;

import java.util.Scanner;

public class serviceImplementMenu implements serviceMenu{

    @Override
    public void menuStructure() {
        serviceImplementEmployee servEmpl = new serviceImplementEmployee();
        serviceImplementUser servUser = new serviceImplementUser();
        serviceImplementBook servBook = new serviceImplementBook();

        Scanner sc = new Scanner(System.in);

        String opcion = "";

        while (!opcion.equals("4")) {

            System.out.println(
                    "Menú Principal\n--------------\n1. Menú Empleado\n2. Menú Cliente\n3. Menú Libros\n4. Salir\nElige:\n");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    while (!opcion.equals("5")) {
                        System.out.println(
                                "Menú Empleado\n--------------\n1. Registrar Empleado\n2. Ver Empleados\n3. Modificar Empleado\n4. Eliminar Empleado\n5. Volver\nElige:\n");
                        opcion = sc.nextLine();

                        switch (opcion) {
                            case "1":
                                System.out.println("\n");
                                servEmpl.employeeRegistration();
                                System.out.println("\n");
                                break;
                            case "2":
                                System.out.println("\n");
                                servEmpl.displayEmployeeAll();
                                System.out.println("\n");
                                break;

                            case "3":
                                System.out.println("\n");
                                servEmpl.updateEmployee();
                                System.out.println("\n");
                                break;

                            case "4":
                                System.out.println("\n");
                                servEmpl.deleteEmployee();
                                System.out.println("\n");
                                break;

                            case "5":
                                break;

                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                                break;
                        }

                    }
                    break;

                case "2":
                    while (!opcion.equals("6")) {
                        System.out.println(
                                "Menú Cliente\n--------------\n1. Registrar Cliente\n2. Ver Clientes\n3. Modificar Cliente\n4. Eliminar Cliente\n5. Ver Clientes con Libros Prestados\n6. Volver\nElige:\n");
                        opcion = sc.nextLine();

                        switch (opcion) {
                            case "1":
                                System.out.println("\n");
                                servUser.userRegistration();
                                System.out.println("\n");
                                break;

                            case "2":
                                System.out.println("\n");
                                servUser.displayUserAll();
                                System.out.println("\n");
                                break;

                            case "3":
                                System.out.println("\n");
                                servUser.updateUser();
                                System.out.println("\n");
                                break;

                            case "4":
                                System.out.println("\n");
                                servUser.deleteUser();
                                System.out.println("\n");
                                break;

                            case "5":
                                System.out.println("\n");
                                servUser.displayUserRentedBook();
                                System.out.println("\n");
                                break;

                            case "6":
                                break;

                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                                break;
                        }
                    }
                    break;

                case "3":
                    while (!opcion.equals("9")) {
                        System.out.println("Menú Libros\n--------------\n1. Cargar Libro\n2. Ver Libros\n3. Modificar Libro\n4. Eliminar Libro\n5. Prestamo de Libros\n6. Devolución de Libros\n7. Ver libros prestados\n8. Buscar libros por Género\n9. Volver\nElige:\n");
                        opcion = sc.nextLine();

                        switch (opcion) {
                            case "1":
                                System.out.println("\n");
                                servBook.bookRegistration();
                                System.out.println("\n");
                                break;

                            case "2":
                                System.out.println("\n");
                                servBook.displayBookAll();
                                System.out.println("\n");
                                break;

                            case "3":
                                System.out.println("\n");
                                servBook.updateBook();
                                System.out.println("\n");
                                break;

                            case "4":
                                System.out.println("\n");
                                servBook.deleteBook();
                                System.out.println("\n");
                                break;

                            case "5":
                                System.out.println("\n");
                                servBook.bookLoan();
                                System.out.println("\n");
                                break;

                            case "6":
                                System.out.println("\n");
                                servBook.bookReturn();
                                System.out.println("\n");
                                break;

                            case "7":
                                System.out.println("\n");
                                servBook.displayRentedBook();
                                System.out.println("\n");
                                break;

                            case "8":
                                System.out.println("\n");
                                servBook.listBookGenre();
                                System.out.println("\n");
                                break;

                            case "9":
                                break;

                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                                break;
                        }
                    }
                    break;

                case "4":
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;


            }
        }
    }
}