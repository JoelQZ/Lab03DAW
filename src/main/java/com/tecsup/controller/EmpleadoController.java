package com.tecsup.controller;

import com.tecsup.model.Empleado;
import com.tecsup.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService es;

    @GetMapping
    public List<Empleado> lista(){
        return es.listar();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Empleado empleado){
        return ResponseEntity.status(201).body(es.guardar(empleado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtener(@PathVariable Long id){
        Empleado e = es.obtener(id);
        if(e == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(e);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Long id, @RequestBody Empleado e){
        Empleado existente = es.obtener(id);
        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        existente.setCargo(e.getCargo());
        existente.setTelefono(e.getTelefono());
        return ResponseEntity.ok(es.guardar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Empleado e = es.obtener(id);
        if(e == null){
            return ResponseEntity.notFound().build();
        }
        es.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
