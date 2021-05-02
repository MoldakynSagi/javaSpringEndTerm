package kz.spring.endterm.controller;

import kz.spring.endterm.entity.Product;
import kz.spring.endterm.service.iservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    // GET - 3
    @GetMapping("")
    public ResponseEntity<?> findProductByNameOrAuthor(@RequestParam("name") String name, @RequestParam("author") String author) {
        return ResponseEntity.ok(iProductService.findProductByNameOrAuthor(name, author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable() Long id) {
        return ResponseEntity.ok(iProductService.getProductById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(iProductService.getAll());
    }

    // POST
    @PostMapping("/action/create")
    public ResponseEntity<?> createNewProduct(@RequestBody Product product) {
        return ResponseEntity.ok(iProductService.createNew(product));
    }

    // PUT
    @PutMapping("/action/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(iProductService.update(product));
    }

    // DELETE
    @DeleteMapping("/action/delete/{id}")
    public void deleteMusicById(@PathVariable("id") Long id) {
        iProductService.deleteProductById(id);
    }

    // PATCH
    @PatchMapping("/action/update/{id}")
    public ResponseEntity<?> updateProductPrice(@PathVariable("id") Long id, @RequestParam("price") Integer price) {
        return ResponseEntity.ok(iProductService.updateProductPrice(id, price));
    }
}
