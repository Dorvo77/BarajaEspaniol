package service;

import entidades.Baraja;
import entidades.Carta;
import enums.Palo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BarajaService {
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
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
        int line=1;
        for (Carta carta: barajas) {
            System.out.print(carta+" ");
            if(line==10 || line==20 || line == 30){
                System.out.println("");
            }
            line++;
        }
    }
}
