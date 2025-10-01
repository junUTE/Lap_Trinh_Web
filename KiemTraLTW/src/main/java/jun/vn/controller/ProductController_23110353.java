package jun.vn.controller;

import jun.vn.entity.Product_23110353;
import jun.vn.service.ProductService_23110353;
import jun.vn.service.CategoryService_23110353;
import jun.vn.service.IStorageService_23110353;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/seller/products")
public class ProductController_23110353 {

	@Autowired
	private ProductService_23110353 productService;

	@Autowired
	private CategoryService_23110353 categoryService;

	@Autowired
	private IStorageService_23110353 storageService;

	// ======= DEFAULT: /seller/products => redirect to /list =======
	@GetMapping("")
	public String index() {
		return "redirect:/seller/products/list";
	}

	// ======= LIST =======
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("products", productService.findAll());
		return "/seller/product/list";
	}

	// ======= ADD FORM =======
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("product", new Product_23110353());
		model.addAttribute("categories", categoryService.findAll());
		return "/seller/product/add"; // /WEB-INF/views/product/add.jsp
	}

	// ======= ADD SUBMIT =======
	// ===== ADD =====
	@PostMapping("/add")
	public String add(@ModelAttribute Product_23110353 product,
			@RequestParam(value = "imagesFile", required = false) MultipartFile file, RedirectAttributes ra) {
		try {
			// mặc định status = 1 khi thêm mới
			product.setStatus(1);

			// Sinh mã sản phẩm tự động
			product.setProductCode(System.currentTimeMillis());

			// Xử lý ảnh
			if (file != null && !file.isEmpty()) {
				String filename = storageService.store(file);
				product.setImages(filename);
			}

			// Set ngày tạo
			product.setCreateDate(new Date());

			productService.save(product);
			ra.addFlashAttribute("msg", "Thêm sản phẩm thành công!");
		} catch (Exception e) {
			ra.addFlashAttribute("error", "Lỗi thêm sản phẩm: " + e.getMessage());
		}
		return "redirect:/seller/products/list";
	}

	// ======= UPDATE FORM =======
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") int id, Model model) {
		Product_23110353 product = productService.findById(id)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm!"));
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.findAll()); // load lại dropdown category
		return "/seller/product/update"; // /WEB-INF/views/product/update.jsp
	}

	// ======= UPDATE SUBMIT =======
	@PostMapping("/update")
	public String update(@ModelAttribute Product_23110353 product,
			@RequestParam(value = "imagesFile", required = false) MultipartFile file, RedirectAttributes ra) {
		try {
			Product_23110353 old = productService.findById(product.getProductId())
					.orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm!"));

			// Giữ ảnh cũ nếu không upload ảnh mới
			if (file != null && !file.isEmpty()) {
				String filename = storageService.store(file);
				product.setImages(filename);
			} else {
				product.setImages(old.getImages());
			}

			// cho phép chỉnh sửa status (giá trị từ form)
			// => product.getStatus() sẽ lấy từ select/checkbox trong JSP

			productService.save(product);
			ra.addFlashAttribute("msg", "Cập nhật sản phẩm thành công!");
		} catch (Exception e) {
			ra.addFlashAttribute("error", "Lỗi cập nhật sản phẩm: " + e.getMessage());
		}
		return "redirect:/seller/products/list";
	}

	// ======= DELETE =======
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id, RedirectAttributes ra) {
		try {
			productService.deleteById(id);
			ra.addFlashAttribute("msg", "Xóa sản phẩm thành công!");
		} catch (Exception e) {
			ra.addFlashAttribute("error", "Lỗi xóa sản phẩm: " + e.getMessage());
		}
		return "redirect:/seller/products/list";
	}
}
