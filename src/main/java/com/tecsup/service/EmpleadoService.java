package com.tecsup.service;

import com.tecsup.model.Cliente;
import com.tecsup.model.Empleado;
import com.tecsup.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository er;

    public List<Empleado> listar(){
        return er.findAll();
    }

    public Empleado guardar(Empleado e){
        return er.save(e);
    }

    public Empleado obtener(Long id){
        return er.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        er.deleteById(id);
    }
}
