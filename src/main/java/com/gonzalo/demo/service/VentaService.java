package com.gonzalo.demo.service;

import com.gonzalo.demo.model.entities.Producto;
import com.gonzalo.demo.model.entities.Venta;

public interface VentaService {

    Venta getVentaById(Long id);

    Venta saveVenta(Venta venta) throws Exception;
}
