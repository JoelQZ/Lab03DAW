package com.tecsup.service;

import com.tecsup.model.Categoria;
import com.tecsup.model.Cliente;
import com.tecsup.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository cr;

    public List<Cliente> listar(){
        return cr.findAll();
    }

    public Cliente guardar(Cliente cl){
        return cr.save(cl);
    }

    public Cliente obtener(Long id){
        return cr.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        cr.deleteById(id);
    }
}
