package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.repositories.UsuarioRepository;

import java.util.List;

public class UsuarioService implements IServiceUsuario<Usuario>{
    private UsuarioRepository usuarioRepository;
    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }

    public List<Usuario> listar(){
        List<Usuario> listadoUsuario = usuarioRepository.listar();
        return listadoUsuario;
    }
    @Override
    public Usuario consultar() {
        return null;
    }
    @Override
    public boolean guardar(Usuario usuario) {
        return usuarioRepository.crear(usuario);
    }

    @Override
    public boolean validar(Usuario usuario) { return usuarioRepository.validar(usuario); }
    public boolean eliminar(Integer id) { return usuarioRepository.eliminar(id); }
    @Override
    public boolean actualizar(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

    @Override
    public boolean comprobar(Usuario usuario) {
        return usuarioRepository.comprobar(usuario);
    }
}
