package zw.co.afrosoft.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.productservice.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
