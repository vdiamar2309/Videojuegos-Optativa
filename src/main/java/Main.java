import ConexionDB.ConexionDB;
import exceptions.VideojuegoException;
import model.Videojuego;

public class Main {
    public static void main(String[] args) {
    }

    public static void menu(){
        System.out.println("Menú");
        System.out.println("1. Insertar un videojuego");
        System.out.println("2. Buscar videojuego por título");
        System.out.println("3. Borrar  videojuego");
        System.out.println("4. Mostrar videojuegos mejor valorados");
        System.out.println("5. Mostrar todos los videojuegos");
    }
}
