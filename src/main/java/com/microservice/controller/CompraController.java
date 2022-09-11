package com.microservice.controller;

import com.microservice.dto.CompraDTO;
import com.microservice.model.Compra;
import com.microservice.service.CompraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {


    private CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }


    @PostMapping
    public Compra realizarCompra(@RequestBody CompraDTO compra) {

        return compraService.realizaCompra(compra);
    }


}
