package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.services.UsuarioService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
@Named
@ViewScoped
public class UsuarioBean implements Serializable {
    private UsuarioService usuarioService;

    private Usuario usuario;

    public UsuarioBean() {
        System.out.println("Iniciando Usuario Bean");
        usuario = new Usuario();
        usuarioService = new UsuarioService();
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    public String guardar(){

        System.out.println("Nombre Empleado "+usuario.getNombre());
        if(usuarioService.guardar(usuario)){

            return "listar-empleado.xhtml";
        }
        return "crear-usuario.xhtml";

    }

    public String validar(){
        System.out.println("Id "+usuario.getId());
        if(usuarioService.validar(usuario)){
            return "listar-empleado.xhtml";
        }
        return "crear-usuario.xhtml";
    }

}
