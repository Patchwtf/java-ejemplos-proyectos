import static ui.UIMenu.*;


public class Main {
    public static void main(String[] args) {
        // Doctor myDoctor = new Doctor();
        // myDoctor.name = "John Doe";
        // myDoctor.showName();
        // myDoctor.showId();

        // Doctor myDoctorAnn = new Doctor();
        // myDoctorAnn.showId();
        
        //?Implementacion de menu
        //showMenu();

        //*implementacion de sobre carga y pasarle variables al instancias objetos */
        Doctor myDoctor = new Doctor("Parche", "Neuro");
        System.err.println(myDoctor.name + "\t" + myDoctor.speciality);
    }
}