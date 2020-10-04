package com.gonzalo.demo.service;

import com.gonzalo.demo.model.entities.Producto;
import com.gonzalo.demo.model.entities.Stock;

public interface ProductoService {

    Stock actualizaStock(Producto producto, Integer cantidad) throws Exception;
}
