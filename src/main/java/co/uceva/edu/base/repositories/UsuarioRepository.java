package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements IRepositoryUsuario<Usuario>{
    public UsuarioRepository() {
    }
    @Override
    public List<Usuario> listar() {
        List<Usuario> listadoUsuario = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try(
                Statement stmt = conect.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
        ) {
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setContraseña(rs.getString("contraseña"));
                listadoUsuario.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listadoUsuario;
    }

    @Override
    public Usuario consultar() {
        return null;
    }

    @Override
    public boolean crear(Usuario usuario) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "insert into usuarios (id, nombre, contraseña) values (?,?,?)";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setInt(1,usuario.getId());
            stmt.setString(2,usuario.getNombre());
            stmt.setString(3, usuario.getContraseña());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean validar(Usuario usuario) {
        boolean ValidacionUsuario = false;
        Connection conect = ConexionBaseDatos.getConnection();

        try(
                Statement stmt = conect.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
        ) {
            while(rs.next()){
                if((rs.getString("nombre").equals(usuario.getNombre())) && (rs.getString("contraseña").equals(usuario.getContraseña()) )){
                    ValidacionUsuario = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ValidacionUsuario;
    }
    public boolean eliminar(Integer id) {
        Connection conect = ConexionBaseDatos.getConnection();
        String sql = "delete from usuarios where id = ?";

        try (
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        Connection conect = ConexionBaseDatos.getConnection();
        String sql = "update usuarios set id = ?,nombre= ?, contraseña= ?";
        System.out.println("Se inicia la actualizacion");
        try (
                PreparedStatement stmt = conect.prepareStatement(sql);

        ) {

            stmt.setInt (1, usuario.getId());
            stmt.setString(2, usuario.getNombre());
            stmt.setString (3, usuario.getContraseña());
            stmt.executeUpdate();
            System.out.println("Se actualizo el Usuario");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("No se pudo actualiza el Usuario");
        return false;
    }

    @Override
    public boolean comprobar(Usuario usuario) {
        return false;
    }

}
