
public class Doctor {

    //Propiedades
    static int id = 0; //autoincrement
    String name;
    String speciality;

    //Constructor
    // Doctor(String name, String speciality) {
    //     this.name = name;
    //     this.speciality = speciality;
    // }

    Doctor(){
        System.out.println("Contructor Doctor() called");
        id++;
    }

    //Comportamientos - Metodos
    public void showName() {
        System.out.println("Doctor name: " + name);
    }

    public void showId() {
        System.out.println("Doctor id: " + id);
    }
}