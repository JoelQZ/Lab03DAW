package com.tecsup.controller;

import com.tecsup.model.Detalle;
import com.tecsup.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetalleController {
    @Autowired
    private DetalleService ds;

    @GetMapping
    public List<Detalle> lista(){
        return ds.listar();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Detalle detalle){
        return ResponseEntity.status(201).body(ds.guardar(detalle));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle> obtener(@PathVariable Long id){
        Detalle d = ds.obtener(id);
        if(d == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(d);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Detalle> actualizar(@PathVariable Long id, @RequestBody Detalle d){
        Detalle existente = ds.obtener(id);
        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        existente.setCantidad(d.getCantidad());
        existente.setPrecio(d.getPrecio());
        existente.setSubtotal(d.getSubtotal());
        return ResponseEntity.ok(ds.guardar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Detalle d = ds.obtener(id);
        if(d == null){
            return ResponseEntity.notFound().build();
        }
        ds.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
