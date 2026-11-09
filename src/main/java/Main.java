import exceptions.VideojuegoException;
import model.Videojuego;
import utils.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            menu();
            int opcion = MiEntradaSalida.solicitarEnteroEnRango("Elige una opción", 1, 6);
            switch (opcion) {
                case 1:
                    String titulo = MiEntradaSalida.solicitarCadena("Introduce el título: ");
                    String genero = MiEntradaSalida.solicitarCadena("Introduce el genero: ");
                    String plataforma = MiEntradaSalida.solicitarCadena("Introduce la plataforma: ");
                    int anio = MiEntradaSalida.solicitarEntero("Introduce el año: ");
                    int valoracion = MiEntradaSalida.solicitarEnteroEnRango("Introduce el valoracion: ", 1, 10);
                    Videojuego videojuego = new Videojuego(titulo, genero, plataforma, anio, valoracion);
                    try {
                        Videojuego.insertar(videojuego);
                    } catch (VideojuegoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    String tituloBuscar = MiEntradaSalida.solicitarCadena("Introduce el título: ");
                    Videojuego.buscarVideojuegoPorTitulo(tituloBuscar);
                    break;
                case 3:
                    int id = MiEntradaSalida.solicitarEntero("Introduce el id: ");
                    Videojuego.borrar(id);
                    break;
                case 4:
                    System.out.println("Opción no implementada.");
                    break;
                case 5:
                    System.out.println("Opción no implementada.");
                    break;
                case 6:
                    salir = true;
            }
        }
    }

    public static void menu() {
        System.out.println("Menú");
        System.out.println("1. Insertar un videojuego");
        System.out.println("2. Buscar videojuego por título");
        System.out.println("3. Borrar  videojuego");
        System.out.println("4. Mostrar videojuegos mejor valorados");
        System.out.println("5. Mostrar todos los videojuegos");
        System.out.println("6. Salir");
    }
}