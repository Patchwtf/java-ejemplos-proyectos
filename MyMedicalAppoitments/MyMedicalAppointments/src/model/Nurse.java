package model;

public class Nurse extends User {

    private String specialty;

    public Nurse(String name, String email) {
        super(name, email);
    }

    public void setSpeciality(String specialty) {
        this.specialty = specialty;
    }

    public String getSpeciality() {
        return this.specialty;
    }

    @Override
    public void showDatauser() {
        System.out.println("Nurse: " + getName() + "\nEmail: " + getEmail() + "\nDireccion: " + getAddress() + "\nTelefono: " + getPhoneNumber() + "\nEspecialidad: " + specialty);
    }

}
