package model;

import exceptions.VideojuegoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Videojuego {
    private static int  nextId = 1;
    private int id;
    private String titulo;
    private String genero;
    private String plataforma;
    private LocalDate anno;
    private double valoracion;

    public Videojuego(String titulo, String genero, String plataforma, LocalDate anno, double valoracion) {
        this.id = nextId ++;
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

    public LocalDate getAnno() {
        return anno;
    }

    public void setAnno(LocalDate anno) {
        this.anno = anno;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }



    public void borrar(int idVideojuegos) throws VideojuegoException {
        String sql = "DELETE FROM videojuegos WHERE id = ?";
        try (Connection con = ConexionDB.ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idVideojuegos);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new VideojuegoException("Error al borrar cliente", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
                sb.append("Videojuego:\n" );
                sb.append("ID: ").append(getId() + "\n");
                sb.append("Titulo: ").append(getTitulo()+ "\n");
                sb.append("Genero: ").append(getGenero()+ "\n");
                sb.append("Plataforma:").append(getPlataforma()+ "\n");
                sb.append("Año: ").append(getAnno() + "\n");
                sb.append("Valoracion: ").append(getValoracion());
                return sb.toString();
    }
}
