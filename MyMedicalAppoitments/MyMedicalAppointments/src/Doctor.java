
public class Doctor {

    //Propiedades
    int id;
    String name;
    String speciality;

    //Constructor
    Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    //Comportamientos - Metodos
    public void showName() {
        System.out.println("Doctor name: " + name);
    }
}
