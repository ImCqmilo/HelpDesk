package co.uceva.edu.base.repositories;

import java.util.List;

public interface IRepositoryUsuario<T> {
    List<T> listar();
    T consultar();
    boolean crear(T t);
    boolean validar(T t);
    boolean eliminar(Integer id);

    boolean actualizar(T t);

    boolean comprobar(T t);
}
