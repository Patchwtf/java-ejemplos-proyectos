package ui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.UIManager;

import model.Doctor;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("Patient Menu:");
            System.out.println("Welcome: " + UIMenu.patienLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. View my appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (response) {
                case 1:
                    System.out.println("Booking an appointment...");
                    // Call the method to book an appointment
                    showBookAppointmentMenu();
                    break;
                case 2:
                    System.out.println("Viewing my appointments...");
                    // Call the method to view appointments
                    showPatientMyAppointments();
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
            System.out.println(UIMenu.doctorLogged.getAvailableAppointments());
            System.out.println("::Book an appointment::");
            System.out.println("Select a date:");

            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();

            int k = 0;

            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvaibleAppointments> avaibleAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                        
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < avaibleAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + avaibleAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }

            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "", "");

            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println("Doctor: " + doctorSelected.getName() + "\nTime: "
                    + doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                    + "\nDate" + doctorSelected.getAvailableAppointments().get(indexDate).getDate());
            System.out.println("Confirm appointment? \n1. Yes\n2. No, Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.patienLogged.addAppointmentsDoctor(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            }
            showPatientMenu();

        } while (response != 0);
    }

    private static void showPatientMyAppointments() {
        int response = 0;
        do {
            System.out.println("::My appointments::");
            if (UIMenu.patienLogged.getAppointmentsDoctor().size() == 0) {
                System.out.println("You have no appointments yet.");
                break;
            }

            for (int i = 0; i < UIMenu.patienLogged.getAppointmentsDoctor().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.patienLogged.getAppointmentsDoctor().get(i).getDoctor().getName()
                        + "\nDate: " + UIMenu.patienLogged.getAppointmentsDoctor().get(i).getDate()
                        + "\nTime: " + UIMenu.patienLogged.getAppointmentsDoctor().get(i).getTime());
            }

            System.out.println("0. Return to menu");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
        } while (response != 0);

    }
}
