package co.uceva.edu.base.beans;

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

            return "listar-usuario.xhtml";
        }
        return "crear-usuario.xhtml";

    }

    public String validar(){
        if(usuarioService.validar(usuario)){
            return "listar-usuario.xhtml";
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El Usuario Ingresado No Existe"));
            return "index.xhtml";
        }
    }
    public String irCrear() {
        this.usuario = new Usuario();
        return "crear-usuario.xhtml";
    }

    public void eliminar(){
        System.out.println("Eliminar "+ usuario.getNombre());
        if(usuarioService.eliminar(usuario.getId())){
            System.out.println("Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Eliminado"));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Usuario"));
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dtemusuarios");
    }

    public void actualizar(){

        System.out.println("Nombre Agente a actualizar "+usuario.getNombre());
        if (usuarioService.actualizar(this.usuario)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Actualizado"));

        }
        else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló actualizando usuario"));
        }

        PrimeFaces.current().executeScript("PF('manageUsuariosDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dtemusuarios");
    }

    public void comprobar(){
        System.out.println("Comprobado");
    }

    public String logOut() {
        this.usuario = new Usuario();
        return "index.xhtml";
    }
}
