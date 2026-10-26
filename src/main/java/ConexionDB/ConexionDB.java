package ConexionDB;


import exceptions.VideojuegoException;
import reader.PropertiesReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexionDB {

    // Constantes de configuración (Podrían -y deberían- venir de un fichero .properties)
    private static final String URL= "jdbc:mysql://192.168.1.131:3306/tienda1Dam?serverTimezone=UTC";

    /**
     * Devuelve un objeto Connection listo para ser usado.
     * Lanza SQLException para que el DAO decida cómo gestionar el
     error.
     */
    public static Connection getConnection() throws SQLException, VideojuegoException {
        PropertiesReader p = PropertiesReader.getInstance();
        return DriverManager.getConnection(URL, p.get("db.user"),p.get("db.password"));
    }
}