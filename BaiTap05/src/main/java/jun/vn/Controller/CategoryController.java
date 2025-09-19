package jun.vn.Controller;

import jun.vn.entities.CategoryEntity;
import jun.vn.services.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    // Danh sách + tìm kiếm + phân trang
    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword,
                       Model model) {
        Page<CategoryEntity> categories = service.search(keyword, PageRequest.of(page, 5));
        model.addAttribute("categories", categories);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "admin/categories/list"; // đúng theo đường dẫn bạn có
    }

    // Form thêm mới
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("category", new CategoryEntity());
        return "admin/categories/addOrEdit";
    }

    // Lưu (thêm/sửa)
    @PostMapping("/save")
    public String save(@ModelAttribute CategoryEntity category) {
        service.save(category);
        return "redirect:/admin/categories";
    }

    // Form sửa
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("category", service.get(id));
        return "admin/categories/addOrEdit";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admin/categories";
    }
}
