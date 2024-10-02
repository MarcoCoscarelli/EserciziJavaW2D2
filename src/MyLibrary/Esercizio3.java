package MyLibrary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Esercizio3 {

    // Menu rubrica
    public void menuRubrica() {
        Scanner scanner = new Scanner(System.in);
        Rubrica rubrica = new Rubrica();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu Rubrica:");
            System.out.println("1. Inserisci un nuovo contatto");
            System.out.println("2. Cancella un contatto");
            System.out.println("3. Cerca una persona per numero di telefono");
            System.out.println("4. Cerca il numero di telefono di una persona");
            System.out.println("5. Stampa tutti i contatti");
            System.out.println("6. Torna al menu principale");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserisci il numero di telefono: ");
                    String telefono = scanner.nextLine();
                    rubrica.inserisciContatto(nome, telefono);
                    break;
                case 2:
                    System.out.print("Inserisci il nome del contatto da cancellare: ");
                    String nomeCancellare = scanner.nextLine();
                    rubrica.cancellaContatto(nomeCancellare);
                    break;
                case 3:
                    System.out.print("Inserisci il numero di telefono: ");
                    String numeroRicerca = scanner.nextLine();
                    String nomeTrovato = rubrica.cercaNomePerNumero(numeroRicerca);
                    if (nomeTrovato != null) {
                        System.out.println("Il numero appartiene a: " + nomeTrovato);
                    } else {
                        System.out.println("Numero non trovato.");
                    }
                    break;
                case 4:
                    System.out.print("Inserisci il nome della persona: ");
                    String nomeRicerca = scanner.nextLine();
                    String numeroTrovato = rubrica.cercaNumeroPerNome(nomeRicerca);
                    if (numeroTrovato != null) {
                        System.out.println(nomeRicerca + " - " + numeroTrovato);
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                    break;
                case 5:
                    rubrica.stampaContatti();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    // Classe Rubrica
    public static class Rubrica {
        private Map<String, String> contatti = new HashMap<>();

        // Metodo per inserire
        public void inserisciContatto(String nome, String telefono) {
            contatti.put(nome, telefono);
            System.out.println("Contatto aggiunto: " + nome + " - " + telefono);
        }

        // Metodo per cancellare
        public void cancellaContatto(String nome) {
            // Rimuove gli spazi bianchi e converte il nome in minuscolo per evitare problemi di case sensitivity
            nome = nome.trim().toLowerCase();

            // Trova il contatto corrispondente alla versione normalizzata del nome
            for (String key : contatti.keySet()) {
                if (key.trim().toLowerCase().equals(nome)) {
                    contatti.remove(key); // Rimuove il contatto originale
                    System.out.println("Contatto rimosso: " + key);
                    return;
                }
            }
            System.out.println("Il contatto " + nome + " non esiste.");
        }

        // Metodo per cercare con il numero di telefono
        public String cercaNomePerNumero(String telefono) {
            for (Map.Entry<String, String> entry : contatti.entrySet()) {
                if (entry.getValue().equals(telefono)) {
                    return entry.getKey();
                }
            }
            return null;
        }

        // Metodo per cercare con il nome
        public String cercaNumeroPerNome(String nome) {
            return contatti.get(nome);
        }

        // Metodo per stampare tutti i contatti
        public void stampaContatti() {
            if (contatti.isEmpty()) {
                System.out.println("La rubrica è vuota.");
            } else {
                System.out.println("Elenco contatti:");
                for (Map.Entry<String, String> entry : contatti.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }
        }
    }
}
