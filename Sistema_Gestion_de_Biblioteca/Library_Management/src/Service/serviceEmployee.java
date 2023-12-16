package Service;

import Entity.Book;
import Entity.Employee;

import javax.swing.text.LabelView;
import java.util.List;


public interface serviceEmployee {

    public abstract void employeeCreate();
    public abstract void employeeRegistration();
    public abstract void structureDisplayEmployeeAll(List<Employee> employeeList);
    public abstract void displayEmployeeAll();
    public  abstract void deleteEmployee();
    public abstract void updateEmployee();
    public abstract void parameterUpdateEmployee();
    public abstract int parameteridpeopleEmployee();

}
