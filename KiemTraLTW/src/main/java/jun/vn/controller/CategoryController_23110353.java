package jun.vn.controller;

import jun.vn.entity.Category_23110353;
import jun.vn.service.CategoryService_23110353;
import jun.vn.service.IStorageService_23110353;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/seller/categories")
public class CategoryController_23110353 {

	@Autowired
	private CategoryService_23110353 categoryService;

	@Autowired
	private IStorageService_23110353 storageService;

	// ====== Mặc định: /seller/categories => redirect sang /list ======
	@GetMapping("")
	public String index() {
		return "redirect:/seller/categories/list";
	}

	// ====== Danh sách ======
	@GetMapping("/list")
	public String list(Model model) {
		List<Category_23110353> list = categoryService.findAll();
		model.addAttribute("categories", list);
		return "/seller/category/list"; // /WEB-INF/views/seller/category/list.jsp
	}

	// ====== Form thêm ======
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("category", new Category_23110353());
		return "/seller/category/add"; // add.jsp
	}

	// ====== Submit thêm ======
	@PostMapping("/add")
	public String add(@ModelAttribute Category_23110353 category, @RequestParam("file") MultipartFile file,
			RedirectAttributes ra) {
		try {
			// Nếu người dùng không chọn trạng thái thì mặc định = 1
			if (category.getStatus() == null) {
				category.setStatus(1);
			}

			// Xử lý file ảnh
			if (file != null && !file.isEmpty()) {
				String filename = storageService.store(file);
				category.setImages(filename);
			}

			categoryService.save(category);
			ra.addFlashAttribute("msg", "Thêm danh mục thành công!");
		} catch (Exception e) {
			ra.addFlashAttribute("error", "Lỗi thêm danh mục: " + e.getMessage());
		}
		return "redirect:/seller/categories/list";
	}

	// ====== Form cập nhật ======
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") int id, Model model) {
		Category_23110353 cat = categoryService.findById(id)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy Category!"));
		model.addAttribute("category", cat);
		return "/seller/category/update";
	}

	// ====== Submit cập nhật ======
	@PostMapping("/update")
	public String update(@ModelAttribute("category") Category_23110353 category,
			@RequestParam("file") MultipartFile file, RedirectAttributes ra) {
		try {
			// Xử lý ảnh
			if (file != null && !file.isEmpty()) {
				String filename = storageService.store(file);
				category.setImages(filename);
			} else {
				Category_23110353 old = categoryService.findById(category.getCategoryId())
						.orElseThrow(() -> new RuntimeException("Không tìm thấy Category!"));
				category.setImages(old.getImages());

				// Nếu status bị null do form không gửi thì lấy lại giá trị cũ
				if (category.getStatus() == null) {
					category.setStatus(old.getStatus());
				}
			}

			categoryService.save(category);
			ra.addFlashAttribute("msg", "Cập nhật thành công!");
		} catch (Exception e) {
			ra.addFlashAttribute("error", "Lỗi cập nhật: " + e.getMessage());
		}
		return "redirect:/seller/categories/list";
	}

	// ====== Xóa ======
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id, RedirectAttributes ra) {
		try {
			categoryService.deleteById(id);
			ra.addFlashAttribute("msg", "✅ Xóa thành công!");
		} catch (Exception e) {
			ra.addFlashAttribute("error", "❌ Lỗi xóa: " + e.getMessage());
		}
		return "redirect:/seller/categories/list";
	}
}