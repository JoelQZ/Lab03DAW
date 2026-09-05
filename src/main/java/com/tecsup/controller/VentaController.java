package com.tecsup.controller;

import com.tecsup.model.Venta;
import com.tecsup.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService vs;

    @GetMapping
    public List<Venta> lista(){
        return vs.listar();
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Venta venta){
        return ResponseEntity.status(201).body(vs.guardar(venta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtener(@PathVariable Long id){
        Venta v = vs.obtener(id);
        if(v == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(v);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizar(@PathVariable Long id, @RequestBody Venta v){
        Venta existente = vs.obtener(id);
        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        existente.setFecha(v.getFecha());
        return ResponseEntity.ok(vs.guardar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Venta v = vs.obtener(id);
        if(v == null){
            return ResponseEntity.notFound().build();
        }
        vs.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
