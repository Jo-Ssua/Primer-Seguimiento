package co.APO2.ui;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.APO2.model.InfrastructureDepartment;

public class Main {

    private InfrastructureDepartment id;
    private Scanner reader;
   
    public static void main(String[] args) throws Exception {

        new Main();



    }

    public Main() throws Exception {

        reader = new Scanner(System.in);
        id = new InfrastructureDepartment();
        //mainMenu();


    }

    private void mainMenu() {

        System.out.println("Bienvenido al gestor de vallas publicitarias del departamento de infraestructura \n ");
        int option = 0;
        do {
            System.out.println("Seleccione una opción: ");
            System.out.println("1) Agregar valla publicitaria");
            System.out.println("2) Mostrar vallas publicitarias");
            System.out.println("3) Exportar reporte de peligrosidad");
            System.out.println("5) Salir");

            option = reader.nextInt();

            switch (option){

                case 1:
                    addBillboard();
                    break;
                case 2:
                    showBillboards();
                    break;
                case 3:
                    exportDangerousBillboards();
                    break;
                case 5:
                    System.out.println("Bye");
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 5);



    }

    private void exportDangerousBillboards() {
    }

    private void showBillboards() {
    }

    private void addBillboard() {
    }







}