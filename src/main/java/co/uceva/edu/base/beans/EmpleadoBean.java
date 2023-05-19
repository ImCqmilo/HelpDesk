package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.services.EmpleadoService;
import org.primefaces.PrimeFaces;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EmpleadoBean implements Serializable {

    private EmpleadoService empleadoService;

    private Empleado empleado;

    public EmpleadoBean() {
        System.out.println("Iniciando Empleado Bean");
        empleado = new Empleado();
        empleadoService = new EmpleadoService();
    }
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        System.out.println("Almacenando empleado de forma temporal "+empleado.getNombre());
        this.empleado = empleado;
    }

    public List<Empleado> listar(){
        return empleadoService.listar();
    }

    public String guardar(){

        System.out.println("Nombre Empleado "+empleado.getNombre());
        if(empleadoService.guardar(empleado)){
            return "listar-empleado.xhtml";
        }
        return "crear-empleado.xhtml";
        /*
        * TODO: Colocar una alerta para indicar si se logrò crear el empleado o no
        * */
    }

    public String irCrear() {
        this.empleado = new Empleado();
        return "crear-empleado.xhtml";
    }

    public void eliminar(){
        System.out.println("Eliminar "+empleado.getNombre());
        if(empleadoService.eliminar(empleado.getId())){
            System.out.println("Eliminación correcta");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado Eliminado"));
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló eliminando Empleado"));
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dtempleados");
    }

    public void actualizar(){
        System.out.println("Nombre Empleado a Actualizar: "+this.empleado.getNombre());
        if(empleadoService.actualizar(this.empleado)){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado Actualizado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falló Actualizando Empleado"));
        }
            PrimeFaces.current().ajax().update("form:messages", "form:dtempleados");
    }
}
