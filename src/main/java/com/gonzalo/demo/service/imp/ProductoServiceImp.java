package com.gonzalo.demo.service.imp;

import com.gonzalo.demo.model.entities.Producto;
import com.gonzalo.demo.model.entities.Stock;
import com.gonzalo.demo.repository.StockRepository;
import com.gonzalo.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock actualizaStock(Producto producto, Integer cantidad) throws Exception {
        Stock stock = stockRepository.getByProducto(producto)
                .orElseThrow(() -> new Exception("No existe producto en stock"));
        stock.setCantidad(stock.getCantidad() - cantidad);
        stockRepository.save(stock);

        return stock;
    }

}
