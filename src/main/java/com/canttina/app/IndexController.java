package com.canttina.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/produtos")
    public String produtos() {
        return "produtos";
    }

    @GetMapping("/compras")
    public String compras() {
        return "compras";
    }

    @GetMapping("/comandas")
    public String comandas() {
        return "comandas";
    }
}
