//import static ui.UIMenu.*;

import java.util.Date;

import model.Doctor;
import model.Patient;

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
        Doctor myDoctor = new Doctor("Parche", "partche@mail.com", "Neuro");
        myDoctor.addAvailableAppointment(new Date(), "4 pm");
        myDoctor.addAvailableAppointment(new Date(), "10 pm");
        myDoctor.addAvailableAppointment(new Date(), "1 pm");
        System.out.println("=============================================================");
        System.out.println(myDoctor.getAvailableAppointments().get(1));
        for (Doctor.AvaibleAppointments avaibleAppointments : myDoctor.getAvailableAppointments()) {
            System.out.println(avaibleAppointments.getDate() + " " + avaibleAppointments.getTime());
        }
        System.out.println("=============================================================");
        //System.out.println(myDoctor.name + "\t" + myDoctor.speciality);
        Patient patient = new Patient("Alex", "nobody@mail.com");
        patient.setWeight(70.0);
        patient.setPhoneNumber("1234567890");
        System.out.println(patient.getPhoneNumber());
        System.out.println("=============================================================");
        System.out.println(patient);
        System.out.println("=============================================================");
        System.out.println(myDoctor);
        System.out.println("=============================================================");
    }
}
