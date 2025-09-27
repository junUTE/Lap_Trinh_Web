package jun.vn.Controller.admin;

import jun.vn.entities.CategoryEntity;
import jun.vn.services.ICategoryService;
import jun.vn.services.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IStorageService storageService;

    @GetMapping({"", "/"})
    public String listCategories(Model model,
                                 @RequestParam(value = "message", required = false) String message) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("message", message);
        return "admin/categories/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("category", new CategoryEntity());
        return "admin/categories/addOrEdit";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<CategoryEntity> category = categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "admin/categories/addOrEdit";
        } else {
            return "redirect:/admin/categories?message=Category not found";
        }
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute CategoryEntity category,
                              @RequestParam(value = "iconFile", required = false) MultipartFile iconFile) {
        try {
            if (iconFile != null && !iconFile.isEmpty()) {
                // Generate a unique filename for the icon
                String iconPath = "/upload/" + storageService.getSorageFilename(iconFile, category.getCategoryId() != null ? category.getCategoryId().toString() : String.valueOf(System.currentTimeMillis()));
                storageService.store(iconFile, iconPath);
                category.setIcon(iconPath);
            } else if (category.getCategoryId() != null) {
                // Editing: keep the old icon if no new file is uploaded
                CategoryEntity old = categoryService.findById(category.getCategoryId()).orElse(null);
                if (old != null) {
                    category.setIcon(old.getIcon());
                }
            }
            categoryService.save(category);
            return "redirect:/admin/categories?message=Category saved successfully";
        } catch (Exception e) {
            return "redirect:/admin/categories?message=Error saving category: " + e.getMessage();
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
        return "redirect:/admin/categories?message=Category deleted successfully";
    }
}