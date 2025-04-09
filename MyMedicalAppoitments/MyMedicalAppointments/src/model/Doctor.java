package model;

import java.util.*;

public class Doctor extends User {

    private String speciality;

    //Propiedades
    //Constructor
    // Doctor(String name, String speciality) {
    //     this.name = name;
    //     this.speciality = speciality;
    // }
    // Doctor() {
    //     System.out.println("Contructor Doctor() called");
    // }
    public Doctor(String name, String email, String speciality) {
        super(name, email);
        System.out.println("El nombre asignado al doctor es: " + name);
        this.speciality = speciality;
        System.out.println("La especialidad del doctor es: " + speciality);
    }

    //Comportamientos - Metodos
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public ArrayList<AvaibleAppointments> getAvailableAppointments() {
        return availableAppointments;
    }

    ArrayList<AvaibleAppointments> availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(Date date, String time) {
        availableAppointments.add(new AvaibleAppointments(date, time));
    }

    @Override
    public String toString() {
        return super.toString() + "\nEspecialidad: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    @Override
    public void showDatauser() {
        System.out.println("Doctor: " + getName() + "\nEmail: " + getEmail() + "\nDireccion: " + getAddress() + "\nTelefono: " + getPhoneNumber() + "\nEspecialidad: " + speciality);
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

        @Override
        public String toString() {
            return "Available Appointments: \nDate " + date + "\nTime: " + time;
        }
    }

}
