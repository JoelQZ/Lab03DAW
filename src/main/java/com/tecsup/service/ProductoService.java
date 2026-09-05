package com.tecsup.service;

import com.tecsup.model.Producto;
import com.tecsup.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository pr;

    public List<Producto> listar(){
        return pr.findAll();
    }

    public Producto guardar(Producto p){
        return pr.save(p);
    }

    public Producto obtener(Long id){
        return pr.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        pr.deleteById(id);
    }
}
