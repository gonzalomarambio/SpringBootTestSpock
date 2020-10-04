package com.gonzalo.demo.service.imp;

import com.gonzalo.demo.model.entities.ProductoDetalle;
import com.gonzalo.demo.model.entities.Venta;
import com.gonzalo.demo.repository.StockRepository;
import com.gonzalo.demo.repository.VentaRepository;
import com.gonzalo.demo.service.ProductoService;
import com.gonzalo.demo.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImp implements VentaService{

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoService productoService;

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepository.getById(id).orElse(null);
    }

    @Override
    public Venta saveVenta(Venta venta) throws Exception {
        for(ProductoDetalle detalle : venta.getProductoDetalles()){
            productoService.actualizaStock(detalle.getProducto(), detalle.getCantidad());
        }
        return ventaRepository.save(venta);
    }
}