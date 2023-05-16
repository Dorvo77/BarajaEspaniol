package service;

import entidades.Carta;
import enums.Palo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BarajaService {
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Carta> montones = new ArrayList<>();
    public void crearBaraja(ArrayList<Carta> b){

        for (Palo aux: Palo.values()) {     //utilizo enum para asignar el palo a cada carta

            String p = aux.getNombre();
            for (int i = 1; i < 13; i++) {
                if (i != 8 && i != 9) {
                    Carta card = new Carta();
                    card.setNumero(i);
                    card.setPalo(p);
                    b.add(card);
                }
            }
        }

    }

    public void mostrarBaraja(ArrayList<Carta> barajas) {
        int line = 1;
        for (Carta carta : barajas) {
            System.out.print(carta + " ");
            if (line == 10 || line == 20 || line == 30) {
                System.out.println();
            }
            line++;
        }
        if (!(barajas.size() > 0)) {
            System.out.println("Las cartas del monton está vacio. ");
        }
    }

    public void menu(ArrayList<Carta> barajas) {
        int op;
        do {
            System.out.println("\n\t MENU BARAJA");
            System.out.println("1. Mostrar Baraja");
            System.out.println("2. Meszclar cartas");
            System.out.println("3. Siguiente Carta");
            System.out.println("4. Cartas Disponibles"); // cantidad de cartas que se pueden repartir
            System.out.println("5. Dar cartas"); // ingresar el número de cartas a dar.
            System.out.println("6. Cartas en el Monton"); // mostrar cartas que han salido
            System.out.println("7. Salir");
            System.out.print("Ingrese Opcion: >_ ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> mostrarBaraja(barajas);
                case 2 -> Collections.shuffle(barajas);
                case 3 -> {
                    if (disponibles(barajas)) {
                        System.out.println("Siguiente carta -> " + barajas.get(0));
                    } else {
                        System.out.println("No hay mas cartas disponibles # Baraja en CERO.");
                    }
                }
                case 4 -> {
                    System.out.println("Quedan " + barajas.size() + " cartas disponibles");
                    System.out.println("Tamanio mayor 0?? >_" + disponibles(barajas));
                }
                case 5 -> {
                    System.out.print("Ingrese la cantidad de cartas a repartir: >_");
                    int cantidad = sc.nextInt();
                    darCartas(barajas, cantidad);
                }
                case 6 -> mostrarBaraja(montones);
                case 7 -> System.out.println("Saliendooo...");
                default -> System.out.println("Ingrese opcion valida");
            }
        }while(op!=7);

    }

    private void darCartas(ArrayList<Carta> barajas, int cantidad) {

        if(disponibles(barajas)) {
            ArrayList<Carta> cardDadas = new ArrayList<>();
            if(cantidad> barajas.size()){
                cantidad = barajas.size();
                System.out.println("Se reparten "+cantidad+" cartas.");
            }
            for (int i = 0; i < cantidad; i++) {
                Carta aux = barajas.get(0);
                montones.add(aux);
                cardDadas.add(aux);
                barajas.remove(0);
            }

            for (Carta carta : cardDadas) {
                System.out.print(carta);
            }
            cardDadas.clear();
        }else{
            System.out.println(" # Baraja en cero #");
        }

    }
    private boolean disponibles(ArrayList<Carta> barajas){
        return barajas.size()>0;
    }

}
