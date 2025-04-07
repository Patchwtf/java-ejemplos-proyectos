
import java.util.*;

public class Doctor {

    //Propiedades
    static int id = 0; //autoincrement
    private String name;
    private String email;
    private String speciality;

    //Constructor
    // Doctor(String name, String speciality) {
    //     this.name = name;
    //     this.speciality = speciality;
    // }
    Doctor() {
        System.out.println("Contructor Doctor() called");
    }

    Doctor(String name, String speciality) {
        System.out.println("El nombre asignado al doctor es: " + name);
        this.name = name;
        this.speciality = speciality;
        id++;
    }

    //Comportamientos - Metodos
    public void showName() {
        System.out.println("Doctor name: " + name);
    }

    public void showId() {
        System.out.println("Doctor id: " + id);
    }

    public ArrayList<AvaibleAppointments> getAvailableAppointments() {
        return availableAppointments;
    }

    ArrayList<AvaibleAppointments> availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(Date date, String time) {
        availableAppointments.add(new AvaibleAppointments(date, time));
    }

    public static class AvaibleAppointments {

        private int id;
        private Date date;
        private String time;

        //Avaible appointment
        public AvaibleAppointments(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
