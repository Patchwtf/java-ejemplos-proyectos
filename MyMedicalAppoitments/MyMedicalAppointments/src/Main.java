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

        Patient patient = new Patient("Alex", "nobody@mail.com");
        patient.setWeight(70.0);
        System.err.println(patient.getWeight());

        patient.setPhoneNumber("1234567890");
        System.err.println(patient.getPhoneNumber());
    }
}