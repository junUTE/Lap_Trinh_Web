package jun.vn.Controller.admin;

import jun.vn.entities.Product;
import jun.vn.entities.CategoryEntity;
import jun.vn.services.IProductService;
import jun.vn.services.ICategoryService;
import jun.vn.services.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IStorageService storageService;

    @GetMapping({"", "/"})
    public String listProducts(Model model, @RequestParam(value = "message", required = false) String message) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("message", message);
        return "admin/products/list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/products/addOrEdit";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            model.addAttribute("categories", categoryService.findAll());
            return "admin/products/addOrEdit";
        } else {
            return "redirect:/admin/products?message=Product not found";
        }
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product,
                             @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
                             @RequestParam(value = "categoryId") Long categoryId) {
        try {
            Optional<CategoryEntity> categoryOpt = categoryService.findById(categoryId);
            if (categoryOpt.isEmpty()) {
                return "redirect:/admin/products?message=Category not found";
            }
            if (imageFile != null && !imageFile.isEmpty()) {
                String imagePath = "/upload/" + storageService.getSorageFilename(imageFile, product.getProductId() != null ? product.getProductId().toString() : String.valueOf(System.currentTimeMillis()));
                storageService.store(imageFile, imagePath);
                product.setImages(imagePath);
            } else if (product.getProductId() != null) {
                Product old = productService.findById(product.getProductId()).orElse(null);
                if (old != null) {
                    product.setImages(old.getImages());
                }
            }
            product.setCategory(categoryOpt.get());
            productService.save(product);
            return "redirect:/admin/products?message=Product saved successfully";
        } catch (Exception e) {
            return "redirect:/admin/products?message=Error saving product: " + e.getMessage();
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/admin/products?message=Product deleted successfully";
    }
}
