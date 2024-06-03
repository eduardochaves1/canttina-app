package com.canttina.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable String id) {
        Produto produto = produtoService.getProdutoById(id)
                .orElseThrow(() -> new RuntimeException("Produto not found"));
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable String id, @RequestBody Produto produtoDetails) {
        Produto updatedProduto = produtoService.updateProduto(id, produtoDetails);
        return ResponseEntity.ok().body(updatedProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable String id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}
