package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        this.speciality = speciality;
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

    public void addAvailableAppointment(String date, String time) {

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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        //Avaible appointment
        public AvaibleAppointments(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                System.out.println("Error parsing date: " + e.getMessage());
            }
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

        public String getDate(String date) {
            return format.format(date);
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
