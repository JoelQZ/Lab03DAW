package com.tecsup.controller;

import com.tecsup.model.Producto;
import com.tecsup.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService ps;

    @GetMapping
    public List<Producto> lista(){
        return ps.listar();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Producto producto){
        return ResponseEntity.status(201).body(ps.guardar(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable Long id){
        Producto p = ps.obtener(id);
        if(p == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto p){
        Producto existente = ps.obtener(id);
        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        existente.setNombre(p.getNombre());
        existente.setPrecio(p.getPrecio());
        existente.setStock(p.getStock());
        return ResponseEntity.ok(ps.guardar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Producto p = ps.obtener(id);
        if(p == null){
            return ResponseEntity.notFound().build();
        }
        ps.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
