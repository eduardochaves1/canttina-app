package com.canttina.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> getAllCompras() {
        return compraService.getAllCompras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable String id) {
        Compra compra = compraService.getCompraById(id)
                .orElseThrow(() -> new RuntimeException("Compra not found"));
        return ResponseEntity.ok().body(compra);
    }

    @PostMapping
    public Compra createCompra(@RequestParam String comandaId, @RequestParam String produtoId, @RequestParam Integer quantidade) {
        return compraService.realizarCompra(comandaId, produtoId, quantidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable String id, @RequestBody Compra compraDetails) {
        Compra updatedCompra = compraService.updateCompra(id, compraDetails);
        return ResponseEntity.ok().body(updatedCompra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable String id) {
        compraService.deleteCompra(id);
        return ResponseEntity.noContent().build();
    }
}
