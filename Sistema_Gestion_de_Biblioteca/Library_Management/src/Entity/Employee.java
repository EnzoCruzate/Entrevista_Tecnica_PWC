package Entity;

public class Employee extends People {
    private int idEmployee;
    private int yearIncorporation;
    private String sector;
    private int People_idPeople;

    public Employee() {

    }

    public Employee(String name, String surname, int identificacionNumber, String maritalStatus, int yearIncorporation, String sector) {
        super(name, surname, identificacionNumber, maritalStatus);
        this.yearIncorporation = yearIncorporation;
        this.sector = sector;
    }

    public Employee(String name, String surname, int identificacionNumber, String maritalStatus, int yearIncorporation, String sector, int people_idPeople) {
        super(name, surname, identificacionNumber, maritalStatus);
        this.yearIncorporation = yearIncorporation;
        this.sector = sector;
        People_idPeople = people_idPeople;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getYearIncorporation() {
        return yearIncorporation;
    }

    public void setYearIncorporation(int yearIncorporation) {
        this.yearIncorporation = yearIncorporation;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getPeople_idPeople() {
        return People_idPeople;
    }

    public void setPeople_idPeople(int people_idPeople) {
        People_idPeople = people_idPeople;
    }


}
