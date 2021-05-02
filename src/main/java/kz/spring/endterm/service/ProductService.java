package kz.spring.endterm.service;

import kz.spring.endterm.entity.Product;
import kz.spring.endterm.repository.ProductRepository;
import kz.spring.endterm.service.iservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findProductByNameOrAuthor(String name, String author) {
        return productRepository.getProductsByNameContainsOrAuthorContains(name, author);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Product createNew(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product updateProductPrice(Long bookId, Integer price) {
        Product product = productRepository.getOne(bookId);
        product.setPrice(price);
        return productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
