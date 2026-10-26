import ConexionDB.ConexionDB;
import exceptions.VideojuegoException;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ConexionDB.getConnection();
            System.out.println("Bienvenido a Videojuego");
        } catch (SQLException | VideojuegoException e) {
            throw new RuntimeException(e);
        }
    }
}
