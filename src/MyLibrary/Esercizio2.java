package MyLibrary;

import java.util.*;

public class Esercizio2 {

    // Genera numeri casuali
    public List<Integer> generaListaInteriCasuali(int N) {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            lista.add(random.nextInt(101));  // Numeri casuali tra 0 e 100
        }
        Collections.sort(lista);  // Ordina la lista
        return lista;
    }

    // Lista numeri casuali invertiti
    public List<Integer> creaListaConInverso(List<Integer> lista) {
        List<Integer> nuovaLista = new ArrayList<>(lista);
        List<Integer> inverso = new ArrayList<>(lista);
        Collections.reverse(inverso);
        nuovaLista.addAll(inverso);  // Aggiunge la lista inversa
        return nuovaLista;
    }

    // Funzione che stampa valori in posizioni pari o dispari a seconda del valore del booleano
    public void stampaValoriPosizioni(List<Integer> lista, boolean stampaPari) {
        System.out.println(stampaPari ? "Valori in posizioni pari:" : "Valori in posizioni dispari:");
        for (int i = 0; i < lista.size(); i++) {
            if (stampaPari && i % 2 == 0) {
                System.out.println(lista.get(i));
            } else if (!stampaPari && i % 2 != 0) {
                System.out.println(lista.get(i));
            }
        }
    }


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lista = null;
        boolean running = true;

        while (running) {
            System.out.println("Esercizio 2:");
            System.out.println("1. Genera lista di interi casuali");
            System.out.println("2. Crea lista con inverso");
            System.out.println("3. Stampa valori in posizioni pari/dispari");
            System.out.println("4. Torna al menu principale");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il numero di elementi: ");
                    int N = scanner.nextInt();
                    lista = generaListaInteriCasuali(N);
                    System.out.println("Lista generata: " + lista);
                    break;
                case 2:
                    if (lista != null) {
                        List<Integer> nuovaLista = creaListaConInverso(lista);
                        System.out.println("Lista con inverso: " + nuovaLista);
                    } else {
                        System.out.println("Genera prima una lista di interi casuali.");
                    }
                    break;
                case 3:
                    if (lista != null) {
                        System.out.print("Vuoi stampare le posizioni pari (true/false)? ");
                        boolean stampaPari = scanner.nextBoolean();
                        stampaValoriPosizioni(lista, stampaPari);
                    } else {
                        System.out.println("Genera prima una lista di interi casuali.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}
