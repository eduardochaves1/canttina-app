package com.canttina.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comandas")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    @GetMapping
    public List<Comanda> getAllComandas() {
        return comandaService.getAllComandas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comanda> getComandaById(@PathVariable String id) {
        Comanda comanda = comandaService.getComandaById(id)
                .orElseThrow(() -> new RuntimeException("Comanda not found"));
        return ResponseEntity.ok().body(comanda);
    }

    @PostMapping
    public Comanda createComanda(@RequestBody Comanda comanda) {
        return comandaService.createComanda(comanda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comanda> updateComanda(@PathVariable String id, @RequestBody Comanda comandaDetails) {
        Comanda updatedComanda = comandaService.updateComanda(id, comandaDetails);
        return ResponseEntity.ok().body(updatedComanda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComanda(@PathVariable String id) {
        comandaService.deleteComanda(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/increase/{id}")
    public ResponseEntity<Comanda> increaseSaldoComanda(@PathVariable String id, @RequestParam int amount) {
        Comanda updatedComanda = comandaService.increaseSaldoComanda(id, amount);
        return ResponseEntity.ok().body(updatedComanda);
    }

    @PutMapping("/decrease/{id}")
    public ResponseEntity<Comanda> decreaseSaldoComanda(@PathVariable String id, @RequestParam int amount) {
        Comanda updatedComanda = comandaService.decreaseSaldoComanda(id, amount);
        return ResponseEntity.ok().body(updatedComanda);
    }
}
