package jun.vn.Controller;

import jun.vn.entities.CategoryEntity;
import jun.vn.model.Response;
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
@RequestMapping(path = "/api/category")
public class CategoryAPIController {
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	IStorageService storageService;

	@GetMapping
	public ResponseEntity<?> getAllCategory() {
		return new ResponseEntity<Response>(new Response(true, "Thành công", categoryService.findAll()), HttpStatus.OK);
	}

	@PostMapping(path = "/getCategory")
	public ResponseEntity<?> getCategory(@Validated @RequestParam("id") Long id) {
		Optional<CategoryEntity> category = categoryService.findById(id);
		if (category.isPresent()) {
			return new ResponseEntity<Response>(new Response(true, "Thành công", category.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response(false, "Thất bại", null), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "/addCategory")
	public ResponseEntity<?> addCategory(@Validated @RequestParam("categoryName") String categoryName,
			@Validated @RequestParam("icon") MultipartFile icon) {
		Optional<CategoryEntity> optCategory = categoryService.findByCategoryName(categoryName);
		if (optCategory.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category đã tồn tại trong hệ thống");
		} else {
			CategoryEntity category = new CategoryEntity();
			if (!icon.isEmpty()) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				String fileName = storageService.getSorageFilename(icon, uuString);
				storageService.store(icon, fileName);
				category.setIcon("/uploads/icons/" + fileName);
			}
			category.setCategoryName(categoryName);
			categoryService.save(category);
			return new ResponseEntity<Response>(new Response(true, "Thêm Thành công", category), HttpStatus.OK);
		}
	}

	@PutMapping(path = "/updateCategory")
	public ResponseEntity<?> updateCategory(@Validated @RequestParam("categoryId") Long categoryId,
			@Validated @RequestParam("categoryName") String categoryName,
			@Validated @RequestParam("icon") MultipartFile icon) {
		Optional<CategoryEntity> optCategory = categoryService.findById(categoryId);
		if (optCategory.isEmpty()) {
			return new ResponseEntity<Response>(new Response(false, "Không tìm thấy Category", null),
					HttpStatus.BAD_REQUEST);
		} else if (optCategory.isPresent()) {
			if (!icon.isEmpty()) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				String fileName = storageService.getSorageFilename(icon, uuString);
				storageService.store(icon, fileName);
				optCategory.get().setIcon("/uploads/icons/" + fileName);
			}
			optCategory.get().setCategoryName(categoryName);
			categoryService.save(optCategory.get());
			return new ResponseEntity<Response>(new Response(true, "Cập nhật Thành công", optCategory.get()),
					HttpStatus.OK);
		}
		return null;
	}

	@DeleteMapping(path = "/deleteCategory")
	public ResponseEntity<?> deleteCategory(@Validated @RequestParam("categoryId") Long categoryId) {
		Optional<CategoryEntity> optCategory = categoryService.findById(categoryId);
		if (optCategory.isEmpty()) {
			return new ResponseEntity<Response>(new Response(false, "Không tìm thấy Category", null),
					HttpStatus.BAD_REQUEST);
		} else if (optCategory.isPresent()) {
			categoryService.delete(optCategory.get());
			return new ResponseEntity<Response>(new Response(true, "Xóa Thành công", optCategory.get()), HttpStatus.OK);
		}
		return null;
	}
}