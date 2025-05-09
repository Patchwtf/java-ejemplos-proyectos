package org.example;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int opcionMenu = -1;
        ArrayList<String> botones = new ArrayList<>();
        botones.add("1. Ver Gatitos");
        botones.add("2. Salir");

        do{

            String opcion = JOptionPane.showInputDialog(null, "Gatitos Java", "Menu Principal", JOptionPane.INFORMATION_MESSAGE,
                    null, botones.toArray(), botones.get(0)).toString();

            int menuOpcion = botones.indexOf(opcion);

            switch (menuOpcion){
                case 0:
                    break;
                default:
                    break;
            }

        }while (opcionMenu != 1);
    }
}