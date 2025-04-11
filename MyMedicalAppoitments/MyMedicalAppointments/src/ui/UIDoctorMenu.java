package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Doctor;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu() {
        int response = 0;
        do {
            System.out.println("Hola Doctor\nWelcome");
            System.out.println(UIMenu.doctorLogged.getName());
            System.out.println("1. Add available appointment");
            System.out.println("2. My scheduled appointments");
            System.out.println("0. Logout");

            Scanner scanner = new Scanner(System.in);
            response = scanner.nextInt();
            switch (response) {
                case 1:
                    // Add available appointment
                    System.out.println("Add available appointment");
                    break;
                case 2:
                    // My scheduled appointments
                    System.out.println("My scheduled appointments");
                    break;
                case 0:
                    // Logout
                    System.out.println("Logout");
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (response != 0);
    }

    private static void showAddAvailableAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("===========================");
            System.out.println("::Add available appointment::");
            System.out.println("Select a month:");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.Months[i]);
            }

            System.out.println("0. Return");

            Scanner scanner = new Scanner(System.in);
            response = scanner.nextInt();

            if (response > 0 && response < 4) {
                int monthSelected = response;
                System.out.println("You selected " + UIMenu.Months[monthSelected - 1]);

                System.out.println("Insert the date available appointment: [dd/mm/yyyy]");
                String date = scanner.nextLine();

                System.out.println("Your date is: " + date + "\n1. Correct\n2. Change Date");

                int responseDate = Integer.parseInt(scanner.nextLine());

                if (responseDate == 1) {
                    continue;
                }

                int responseTime = 0;
                String time = "";

                do {
                    System.out.println("Insert the available time for date: " + date + "[hh:mm]");
                    time = scanner.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct\n2. Change Time");
                    responseTime = Integer.parseInt(scanner.nextLine());

                } while (responseTime == 1);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);

            } else if (response == 0) {
                System.out.println("Returning to the previous menu...");
            }
        } while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor) {
        if (doctor.getAvailableAppointments().isEmpty() && !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
