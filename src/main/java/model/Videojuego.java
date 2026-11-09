package model;

import ConexionDB.ConexionDB;
import exceptions.VideojuegoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Representa un videojuego del catálogo y permite gestionar sus datos en la base de datos.
 */
public class Videojuego {
    private static int nextId = 1;
    private int id;
    private String titulo;
    private String genero;
    private String plataforma;
    private int anno;
    private int valoracion;

    public Videojuego(String titulo, String genero, String plataforma, int anno, int valoracion) {
        this.id = nextId++;
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.anno = anno;
        this.valoracion = valoracion;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }


    /**
     * Elimina de la base de datos el videojuego identificado por su ID.
     *
     * @param idVideojuegos el id del videojuego que se va a borrar
     * @throws VideojuegoException si no se encuentra el videojuego cuando busca el id
     */
    public static void borrar(int idVideojuegos) throws VideojuegoException {
        String sql = "DELETE FROM videojuegos WHERE id = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idVideojuegos);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new VideojuegoException("Error al borrar cliente"+ e.getMessage());
        }
    }

    /**
     * Busca videojuegos cuyo título, plataforma o género contenga el texto indicado.
     *
     * @param texto texto que se buscará en esos campos
     * @throws VideojuegoException si ocurre un error al consultar la base de datos
     */
    public static void buscarVideojuego(String texto) throws VideojuegoException {
        String sql = """
            SELECT * FROM videojuegos
            WHERE titulo LIKE ? OR plataforma LIKE ? OR genero LIKE ?
            """;

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String coincidencia = "%" + texto + "%";
            ps.setString(1, coincidencia);
            ps.setString(2, coincidencia);
            ps.setString(3, coincidencia);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("titulo"));
                }
            }
        } catch (SQLException e) {
            throw new VideojuegoException("Error al buscar videojuegos", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Videojuego:\n");
        sb.append("ID: ").append(getId() + "\n");
        sb.append("Titulo: ").append(getTitulo() + "\n");
        sb.append("Genero: ").append(getGenero() + "\n");
        sb.append("Plataforma:").append(getPlataforma() + "\n");
        sb.append("Año: ").append(getAnno() + "\n");
        sb.append("Valoracion: ").append(getValoracion());
        return sb.toString();
    }

    /**
     * Inserta en la base de datos los datos del videojuego recibido.
     *
     * @param videojuego el videojuego que se va a insertar
     *
     */
    public static void insertar(Videojuego videojuego) throws VideojuegoException {
        String sql = "INSERT INTO videojuegos_db.videojuegos " +
                "(titulo, genero, plataforma, anio, valoracion) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, videojuego.getTitulo());
            ps.setString(2, videojuego.getGenero());
            ps.setString(3, videojuego.getPlataforma());
            ps.setInt(4, videojuego.getAnno());
            ps.setInt(5, videojuego.getValoracion());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new VideojuegoException("No se pudo insertar el videojuego: " + e.getMessage());
        }
    }
}
