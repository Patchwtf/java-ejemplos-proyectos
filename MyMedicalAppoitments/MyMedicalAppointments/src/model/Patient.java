package model;

public class Patient extends User {

    private String birthday;
    private double weight;
    private double height;
    private String blood;

    public Patient(String name, String email) {
        super(name, email);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return this.weight + " kg";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getHeight() {
        return this.height + " mts";
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getBlood() {
        return this.blood;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }

    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFecha de nacimiento: " + birthday + "\nPeso: " + getWeight() + "\nAltura: " + getHeight() + "\nTipo de sangre: " + blood;
    }

    @Override
    public void showDatauser() {
        System.out.println("Paciente: " + getName() + "\nEmail: " + getEmail() + "\nTelefono: " + getPhoneNumber() + "\nFecha de nacimiento: " + birthday + "\nPeso: " + getWeight() + "\nAltura: " + getHeight() + "\nTipo de sangre: " + blood);
    }
}
