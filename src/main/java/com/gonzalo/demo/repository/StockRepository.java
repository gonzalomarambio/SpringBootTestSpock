package com.gonzalo.demo.repository;

import com.gonzalo.demo.model.entities.Producto;
import com.gonzalo.demo.model.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> getByProducto(Producto producto);

    Stock save(Stock stock);
}