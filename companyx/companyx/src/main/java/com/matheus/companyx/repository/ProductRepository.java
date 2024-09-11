package com.matheus.companyx.repository;

import com.matheus.companyx.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Custom search methods
    List<Product> findByStartDateBetween(Date startDate, Date endDate);
    List<Product> findByProductIdAndPriceBetween(Long productId, double minPrice, double maxPrice);
    List<Product> findByProductId(Long productId);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

}
