package jun.vn.Controller.admin;

import jun.vn.entities.Product;
import jun.vn.entities.CategoryEntity;
import jun.vn.services.ICategoryService;
import jun.vn.services.IProductService;
import jun.vn.services.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IStorageService storageService;

    // --- View endpoints for AJAX pages ---
    @GetMapping({"/ajax/list", "/"})
    public String listAjax() {
        return "admin/products/list";
    }

    @GetMapping("/ajax/add")
    public String addAjax() {
        return "admin/products/add";
    }

    @GetMapping("/ajax/update")
    public String updateAjax() {
        return "admin/products/update";
    }

    // --- REST API endpoints for AJAX ---
    @GetMapping("/api")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Optional<Product> opt = productService.findById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/api", consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity<Product> createProduct(
            @RequestParam("productName") String productName,
            @RequestParam("quantity") int quantity,
            @RequestParam("unitPrice") double unitPrice,
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam("description") String description,
            @RequestParam("discount") double discount,
            @RequestParam("status") short status,
            @RequestParam("categoryId") Long categoryId) {
        try {
            Product p = new Product();
            p.setProductName(productName);
            p.setQuantity(quantity);
            p.setUnitPrice(unitPrice);
            p.setDescription(description);
            p.setDiscount(discount);
            p.setStatus(status);
            p.setCreateDate(new Date());
            if (image != null && !image.isEmpty()) {
                String originalFilename = image.getOriginalFilename();
                String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
                String storeFilename = UUID.randomUUID().toString() + ext;
                storageService.store(image, storeFilename);
                p.setImages(storeFilename);
            }
            Optional<CategoryEntity> catOpt = categoryService.findById(categoryId);
            if (catOpt.isEmpty()) return ResponseEntity.badRequest().build();
            p.setCategory(catOpt.get());
            Product saved = productService.save(p);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/api/{id}", consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") Long id,
            @RequestParam("productName") String productName,
            @RequestParam("quantity") int quantity,
            @RequestParam("unitPrice") double unitPrice,
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam("description") String description,
            @RequestParam("discount") double discount,
            @RequestParam("status") short status,
            @RequestParam("categoryId") Long categoryId) {
        Optional<Product> opt = productService.findById(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        Product p = opt.get();
        p.setProductName(productName);
        p.setQuantity(quantity);
        p.setUnitPrice(unitPrice);
        p.setDescription(description);
        p.setDiscount(discount);
        p.setStatus(status);
        if (image != null && !image.isEmpty()) {
            String originalFilename = image.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
            String storeFilename = UUID.randomUUID().toString() + ext;
            storageService.store(image, storeFilename);
            p.setImages(storeFilename);
        }
        Optional<CategoryEntity> catOpt = categoryService.findById(categoryId);
        if (catOpt.isEmpty()) return ResponseEntity.badRequest().build();
        p.setCategory(catOpt.get());
        Product saved = productService.save(p);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        Optional<Product> opt = productService.findById(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        productService.delete(opt.get());
        return ResponseEntity.ok().build();
    }
}