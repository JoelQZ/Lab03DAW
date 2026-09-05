package com.tecsup.service;

import com.tecsup.model.Cliente;
import com.tecsup.model.Detalle;
import com.tecsup.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleService {

    @Autowired
    private DetalleRepository dr;

    public List<Detalle> listar(){
        return dr.findAll();
    }

    public Detalle guardar(Detalle d){
        return dr.save(d);
    }

    public Detalle obtener(Long id){
        return dr.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        dr.deleteById(id);
    }
}
