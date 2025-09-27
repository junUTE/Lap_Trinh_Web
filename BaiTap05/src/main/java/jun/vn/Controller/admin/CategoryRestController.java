package jun.vn.Controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jun.vn.entities.CategoryEntity;
import jun.vn.services.ICategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam String categoryName,
                                    @RequestParam(required = false) MultipartFile icon) {
        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(categoryName);

        // TODO: lưu file icon nếu có
        if (icon != null && !icon.isEmpty()) {
            category.setIcon(icon.getOriginalFilename());
        }

        categoryService.save(category);
        return ResponseEntity.ok(category);
    }
}

