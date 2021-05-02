package kz.spring.endterm.repository;

import kz.spring.endterm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductById(Long id);
    List<Product> getProductsByNameContainsOrAuthorContains(String name, String author);
}
