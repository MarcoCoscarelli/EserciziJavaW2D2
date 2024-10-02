package MyLibrary;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Esercizio1 {

    public void esegui() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di parole da inserire: ");
        int N = scanner.nextInt();
        scanner.nextLine();

        Set<String> paroleDistinte = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();

        for (int i = 0; i < N; i++) {
            System.out.print("Inserisci una parola: ");
            String parola = scanner.nextLine();

            if (!paroleDistinte.add(parola)) {
                paroleDuplicate.add(parola);
            }
        }

        // Stampa parole duplicate
        if (!paroleDuplicate.isEmpty()) {
            System.out.println("Parole duplicate: " + paroleDuplicate);
        } else {
            System.out.println("Non ci sono parole duplicate.");
        }

        // Stampa parole distinte
        System.out.println("Numero di parole distinte: " + paroleDistinte.size());
    }
}

