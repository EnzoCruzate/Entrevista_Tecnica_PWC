package Entity;

public class People {
    protected int idPeople;
    protected String name;
    protected String surname;
    protected int identificacionNumber;
    protected String maritalStatus;

    public People() {

    }

    public People(String name, String surname, int identificacionNumber, String maritalStatus) {
        this.name = name;
        this.surname = surname;
        this.identificacionNumber = identificacionNumber;
        this.maritalStatus = maritalStatus;
    }

    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdentificacionNumber() {
        return identificacionNumber;
    }

    public void setIdentificacionNumber(int identificacionNumber) {
        this.identificacionNumber = identificacionNumber;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
