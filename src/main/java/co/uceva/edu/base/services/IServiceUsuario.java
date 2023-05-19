package co.uceva.edu.base.services;

import java.util.List;

public interface IServiceUsuario <T>{
    List<T> listar();
    T consultar();

    boolean guardar(T o);
    boolean validar(T t);
}
