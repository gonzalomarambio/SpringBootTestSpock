package com.gonzalo.demo.service.imp;

import com.gonzalo.demo.model.entities.Venta;
import com.gonzalo.demo.repository.VentaRepository;
import com.gonzalo.demo.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImp implements VentaService{

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.getById(id).orElse(null);
    }
}