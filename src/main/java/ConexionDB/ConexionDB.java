package ConexionDB;
import exceptions.VideojuegoException;
import utils.PropertiesReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionDB {
    /**
     * Devuelve un objeto Connection listo para ser usado.
     * Lanza SQLException para que el DAO decida cómo gestionar el
     * error.
     */
    public static Connection getConnection() throws SQLException, VideojuegoException {
        PropertiesReader p = PropertiesReader.getInstance();
        return DriverManager.getConnection(p.get("db.url"), p.get("db.user"), p.get("db.password"));
    }
}