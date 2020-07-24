package com.gonzalo.demo.controller;

import com.gonzalo.demo.model.entities.Venta;
import com.gonzalo.demo.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venta> getVentaById(@PathVariable("id") Long id){
        return new ResponseEntity<Venta>(ventaService.getVentaById(id), HttpStatus.ACCEPTED);
    }
}
