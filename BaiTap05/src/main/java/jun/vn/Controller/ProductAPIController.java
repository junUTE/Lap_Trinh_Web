package jun.vn.Controller;

import jun.vn.entities.Product;
import jun.vn.entities.CategoryEntity;
import jun.vn.model.Response;
import jun.vn.services.IProductService;
import jun.vn.services.ICategoryService;
import jun.vn.services.IStorageService;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/product")
public class ProductAPIController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IStorageService storageService;

    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(new Response(true, "Thành công", productService.findAll()), HttpStatus.OK);
    }

    @PostMapping(path = "/getProduct")
    public ResponseEntity<?> getProduct(@Validated @RequestParam("id") Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(new Response(true, "Thành công", product.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Response(false, "Thất bại", null), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/addProduct")
    public ResponseEntity<?> addProduct(
            @Validated @RequestParam("productName") String productName,
            @Validated @RequestParam("quantity") int quantity,
            @Validated @RequestParam("unitPrice") double unitPrice,
            @Validated @RequestParam("description") String description,
            @Validated @RequestParam("discount") double discount,
            @Validated @RequestParam("status") short status,
            @Validated @RequestParam("categoryId") Long categoryId,
            @Validated @RequestParam("image") MultipartFile image) {
        Optional<CategoryEntity> categoryOpt = categoryService.findById(categoryId);
        if (categoryOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category không tồn tại");
        }
        Product product = new Product();
        if (!image.isEmpty()) {
            UUID uuid = UUID.randomUUID();
            String uuString = uuid.toString();
            String fileName = storageService.getSorageFilename(image, uuString);
            storageService.store(image, fileName);
            product.setImages("/uploads/products/" + fileName);
        }
        product.setProductName(productName);
        product.setQuantity(quantity);
        product.setUnitPrice(unitPrice);
        product.setDescription(description);
        product.setDiscount(discount);
        product.setStatus(status);
        product.setCategory(categoryOpt.get());
        productService.save(product);
        return new ResponseEntity<>(new Response(true, "Thêm Thành công", product), HttpStatus.OK);
    }

    @PutMapping(path = "/updateProduct")
    public ResponseEntity<?> updateProduct(
            @Validated @RequestParam("productId") Long productId,
            @Validated @RequestParam("productName") String productName,
            @Validated @RequestParam("quantity") int quantity,
            @Validated @RequestParam("unitPrice") double unitPrice,
            @Validated @RequestParam("description") String description,
            @Validated @RequestParam("discount") double discount,
            @Validated @RequestParam("status") short status,
            @Validated @RequestParam("categoryId") Long categoryId,
            @Validated @RequestParam("image") MultipartFile image) {
        Optional<Product> productOpt = productService.findById(productId);
        Optional<CategoryEntity> categoryOpt = categoryService.findById(categoryId);
        if (productOpt.isEmpty() || categoryOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product hoặc Category không tồn tại");
        }
        Product product = productOpt.get();
        if (!image.isEmpty()) {
            UUID uuid = UUID.randomUUID();
            String uuString = uuid.toString();
            String fileName = storageService.getSorageFilename(image, uuString);
            storageService.store(image, fileName);
            product.setImages("/uploads/products/" + fileName);
        }
        product.setProductName(productName);
        product.setQuantity(quantity);
        product.setUnitPrice(unitPrice);
        product.setDescription(description);
        product.setDiscount(discount);
        product.setStatus(status);
        product.setCategory(categoryOpt.get());
        productService.save(product);
        return new ResponseEntity<>(new Response(true, "Cập nhật Thành công", product), HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteProduct")
    public ResponseEntity<?> deleteProduct(@Validated @RequestParam("productId") Long productId) {
        Optional<Product> productOpt = productService.findById(productId);
        if (productOpt.isEmpty()) {
            return new ResponseEntity<>(new Response(false, "Không tìm thấy Product", null), HttpStatus.BAD_REQUEST);
        }
        productService.delete(productOpt.get());
        return new ResponseEntity<>(new Response(true, "Xóa Thành công", productOpt.get()), HttpStatus.OK);
    }
}