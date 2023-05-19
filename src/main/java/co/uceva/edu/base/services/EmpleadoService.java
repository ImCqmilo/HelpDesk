package co.uceva.edu.base.services;


import co.uceva.edu.base.models.Empleado;
import co.uceva.edu.base.repositories.EmpleadoRepository;

import java.util.List;

public class EmpleadoService implements IService<Empleado>{

    private  EmpleadoRepository empleadoRepository;
    public EmpleadoService() {
        empleadoRepository = new EmpleadoRepository();
    }

    public List<Empleado> listar(){
        List<Empleado> listadoEmpleado = empleadoRepository.listar();
        return listadoEmpleado;
    }

    @Override
    public Empleado consultar() {
        return null;
    }

    @Override
    public boolean guardar(Empleado empleado) { return empleadoRepository.crear(empleado); }

    @Override
    public boolean eliminar(int id) {
        return empleadoRepository.eliminar(id);
    }

    @Override
    public boolean actualizar(Empleado o) {
        return empleadoRepository.actualizar(o);
    }
}
