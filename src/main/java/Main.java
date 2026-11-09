import exceptions.VideojuegoException;
import model.Videojuego;

public class Main {
    public static void main(String[] args) {
        Videojuego v = new Videojuego("Wolvernine","Mierdaaa","PS5",2026,1);
        try {
            v.buscarVideojuegoPorTitulo("The Witcher 3: Wild Hunt");
        } catch (VideojuegoException e) {
            System.out.println(e.getMessage());
        }
    }
}
