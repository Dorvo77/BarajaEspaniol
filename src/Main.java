import entidades.Carta;
import service.BarajaService;

import java.util.ArrayList;
import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        ArrayList<Carta> barajas = new ArrayList<>();
        BarajaService bs = new BarajaService();
        bs.crearBaraja(barajas);
        bs.menu(barajas);

    }
}