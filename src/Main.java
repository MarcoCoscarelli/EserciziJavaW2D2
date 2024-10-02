import MyLibrary.Esercizio1;
import MyLibrary.Esercizio2;
import MyLibrary.Esercizio3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Esercizio 1");
            System.out.println("2. Esercizio 2");
            System.out.println("3. Esercizio 3");
            System.out.println("4. Esci");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    Esercizio1 esercizio1 = new Esercizio1();
                    esercizio1.esegui();
                    break;
                case 2:
                    Esercizio2 esercizio2 = new Esercizio2();
                    esercizio2.menu();
                    break;
                case 3:
                    Esercizio3 esercizio3 = new Esercizio3();
                    esercizio3.menuRubrica();
                    break;
                case 4:
                    running = false;
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }
}
