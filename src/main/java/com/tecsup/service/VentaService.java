package com.tecsup.service;

import com.tecsup.model.Cliente;
import com.tecsup.model.Venta;
import com.tecsup.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository vr;

    public List<Venta> listar(){
        return vr.findAll();
    }

    public Venta guardar(Venta v){
        return vr.save(v);
    }

    public Venta obtener(Long id){
        return vr.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        vr.deleteById(id);
    }
}
