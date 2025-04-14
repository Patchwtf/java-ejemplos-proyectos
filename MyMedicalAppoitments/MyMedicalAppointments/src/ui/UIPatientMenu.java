package ui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import model.Doctor;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("Patient Menu:");
            System.out.println("Welcome: " + UIMenu.patienLogged);
            System.out.println("1. Book an appointment");
            System.out.println("2. View my appointments");
            System.out.println("3. Logout");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (response) {
                case 1:
                    System.out.println("Booking an appointment...");
                    // Call the method to book an appointment
                    break;
                case 2:
                    System.out.println("Viewing my appointments...");
                    // Call the method to view appointments
                    break;
                case 0:
                    System.out.println("Logging out...");
                    UIMenu.showMenu();
                    ;
                    // Call the method to log out
                    break;
            }

        } while (response != 0);
    }

    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("::Book an appointment::");
            System.out.println("Select a date:");

            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();

            int k = 0;

            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvaibleAppointments> avaibleAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();  
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < avaibleAppointments.size(); j++){
                    k++;
                    System.out.println(k + ". " + avaibleAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
                
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine()); 
            

        } while (response != 0);
    }
}
