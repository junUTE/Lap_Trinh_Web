package jun.vn.Controller.admin;

import jun.vn.entities.CategoryEntity;
import jun.vn.services.ICategoryService;
import jun.vn.services.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IStorageService storageService;

    // --- View endpoints for AJAX pages ---
    @GetMapping("/ajax/list")
    public String listAjax() {
        return "admin/categories/list";
    }
    @GetMapping("/ajax/add")
    public String addAjax() {
        return "admin/categories/add";
    }
    @GetMapping("/ajax/update")
    public String updateAjax() {
        return "admin/categories/update";
    }

    // --- REST API endpoints for AJAX ---
    @GetMapping("/api")
    @ResponseBody
    public List<CategoryEntity> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<CategoryEntity> getCategory(@PathVariable("id") Long id) {
        Optional<CategoryEntity> opt = categoryService.findById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/api", consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity<CategoryEntity> createCategory(
            @RequestParam("categoryName") String categoryName,
            @RequestParam(value = "icon", required = false) MultipartFile icon) {
        try {
            CategoryEntity c = new CategoryEntity();
            c.setCategoryName(categoryName);
            if (icon != null && !icon.isEmpty()) {
                String originalFilename = icon.getOriginalFilename();
                String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
                String storeFilename = UUID.randomUUID().toString() + ext;
                storageService.store(icon, storeFilename);
                c.setIcon(storeFilename);
            }
            CategoryEntity saved = categoryService.save(c);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/api/{id}", consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity<CategoryEntity> updateCategory(
            @PathVariable("id") Long id,
            @RequestParam("categoryName") String categoryName,
            @RequestParam(value = "icon", required = false) MultipartFile icon) {
        Optional<CategoryEntity> opt = categoryService.findById(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        CategoryEntity c = opt.get();
        c.setCategoryName(categoryName);
        if (icon != null && !icon.isEmpty()) {
            String originalFilename = icon.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
            String storeFilename = UUID.randomUUID().toString() + ext;
            storageService.store(icon, storeFilename);
            c.setIcon(storeFilename);
        }
        CategoryEntity saved = categoryService.save(c);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        Optional<CategoryEntity> opt = categoryService.findById(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        categoryService.delete(opt.get());
        return ResponseEntity.ok().build();
    }
}
