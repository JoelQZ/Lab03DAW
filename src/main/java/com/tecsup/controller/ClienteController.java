package com.tecsup.controller;

import com.tecsup.model.Cliente;
import com.tecsup.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService cls;

    @GetMapping
    public List<Cliente> lista(){
        return cls.listar();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Cliente cliente){
        return ResponseEntity.status(201).body(cls.guardar(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtener(@PathVariable Long id){
        Cliente cl = cls.obtener(id);
        if(cl == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cl);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente cl){
        Cliente existente = cls.obtener(id);
        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        existente.setTelefono(cl.getTelefono());
        existente.setEmail(cl.getEmail());
        return ResponseEntity.ok(cls.guardar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Cliente cl = cls.obtener(id);
        if(cl == null){
            return ResponseEntity.notFound().build();
        }
        cls.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
