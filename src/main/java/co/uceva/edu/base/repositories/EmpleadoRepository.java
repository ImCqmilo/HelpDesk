package co.uceva.edu.base.repositories;


import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository implements IRepository<Empleado> {

    public EmpleadoRepository() {
    }

    @Override
    public List<Empleado>  listar() {
        List<Empleado> listadoEmpleado = new ArrayList<>();
        Connection conect = ConexionBaseDatos.getConnection();

        try(
                Statement stmt = conect.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
        ) {
            while(rs.next()){
                //System.out.print("Recorriendo empleado");

                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setCiudad(rs.getString("ciudad"));
                empleado.setDepartamento(rs.getString("departamento"));
                empleado.setSalario(rs.getLong("salario"));
                listadoEmpleado.add(empleado);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listadoEmpleado;
    }

    @Override
    public Empleado consultar() {
        return null;
    }

    @Override
    public boolean crear(Empleado empleado) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "insert into empleados (id, nombre, departamento, salario, ciudad) values (?,?,?,?,?)";

        try(
            PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setInt(1,empleado.getId());
            stmt.setString(2,empleado.getNombre());
            stmt.setString(3, empleado.getDepartamento());
            stmt.setLong(4,empleado.getSalario());
            stmt.setString(5,empleado.getCiudad());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "delete from empleados where id = ?";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean actualizar(Empleado empleado) {

        Connection conect = ConexionBaseDatos.getConnection();
        String sql =  "update empleados set nombre = ?,  ciudad = ?,departamento = ?,   salario = ? where id = ?;";

        try(
                PreparedStatement stmt = conect.prepareStatement(sql);
        ) {
            stmt.setString(1,empleado.getNombre());
            stmt.setString(2,empleado.getCiudad());
            stmt.setString(3, empleado.getDepartamento());
            stmt.setLong(4,empleado.getSalario());
            stmt.setInt(5,empleado.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
