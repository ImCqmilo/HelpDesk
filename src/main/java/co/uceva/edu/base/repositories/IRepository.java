package co.uceva.edu.base.repositories;

import java.util.List;

public interface IRepository<T> {
    List<T> listar();
    T consultar();
    boolean crear(T t);

    boolean eliminar(int id);

    boolean actualizar(T t);

}

