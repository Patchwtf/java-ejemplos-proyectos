package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Doctor;
import model.Patient;

public class UIMenu {

    public static final String[] Months = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};

    public static Doctor doctorLogged;
    public static Patient patienLogged;

    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    response = 0;
                    System.out.println("Doctor");
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);

                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    private static void authUser(int userType) {
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martinez", "alejandro@mail.com", null));
        doctors.add(new Doctor("Rocio Hernandez", "rocio@mail.com", null));
        doctors.add(new Doctor("Juan Perez", "juan@mail.com", null));

        ArrayList<Patient> pacientes = new ArrayList<>();
        pacientes.add(new Patient("Juan Barrera", "barrera@gmail"));
        pacientes.add(new Patient("Daniel Salgado", "daniel@gmail"));
        pacientes.add(new Patient("Roberto Martinez", "roberto@gmail"));

        boolean emailCorrect = false;

        do {
            System.out.println("Insert your email: [x@mail.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if (userType == 1) {
                for (Doctor d : doctors) {
                    if (d.getEmail().equals(email)) {
                        emailCorrect = true;
                        doctorLogged = d;

                    }
                }
            } else if (userType == 2) {
                for (Patient d : pacientes) {
                    if (d.getEmail().equals(email)) {
                        emailCorrect = true;
                        patienLogged = d;

                    }
                }
            }

        } while (!emailCorrect);
    }

    static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 4; i++) {
                        System.out.println(i + ". " + Months[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }
}
