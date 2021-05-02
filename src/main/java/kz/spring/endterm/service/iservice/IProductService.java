package kz.spring.endterm.service.iservice;

import kz.spring.endterm.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    List<Product> findProductByNameOrAuthor(String name, String author);
    Product getProductById(Long id);
    Product createNew(Product product);
    Product update(Product product);
    Product updateProductPrice(Long productId, Integer price);
    void deleteProductById(Long id);
}
