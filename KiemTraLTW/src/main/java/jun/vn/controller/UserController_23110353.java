package jun.vn.controller;

import jun.vn.entity.UserRoles_23110353;
import jun.vn.entity.User_23110353;
import jun.vn.service.UsersService_23110353;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/seller/users")
public class UserController_23110353 {

	@Autowired
	private UsersService_23110353 usersService;

	// Danh sách user
	@GetMapping
	public String list(Model model) {
		model.addAttribute("users", usersService.findAll());
		model.addAttribute("roles", usersService.findAllRoles()); // load role nếu cần filter
		return "user/list"; // /WEB-INF/views/user/list.jsp
	}

	// Xem chi tiết user
	@GetMapping("/{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		User_23110353 user = usersService.findById(id).orElse(null);
		model.addAttribute("user", user);
		return "user/detail"; // /WEB-INF/views/user/detail.jsp
	}

	// Hiển thị form thêm mới
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("user", new User_23110353());
		model.addAttribute("roles", usersService.findAllRoles());
		return "user/add"; // /WEB-INF/views/user/add.jsp
	}

	// Xử lý thêm mới
	@PostMapping("/add")
	public String add(@RequestParam("roleId") int roleId, @RequestParam("file") MultipartFile file,
			@ModelAttribute("user") User_23110353 user) {
		try {
			// Upload ảnh nếu có
			if (!file.isEmpty()) {
				String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
				String uploadDir = "src/main/webapp/upload/";
				File saveFile = new File(uploadDir, fileName);
				file.transferTo(saveFile);
				user.setImages(fileName);
			}

			// Gán role
			UserRoles_23110353 role = usersService.findRoleById(roleId);
			user.setRole(role);

			usersService.save(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/seller/users";
	}

	// Hiển thị form chỉnh sửa
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") int id, Model model) {
		User_23110353 user = usersService.findById(id).orElse(null);
		model.addAttribute("user", user);
		model.addAttribute("roles", usersService.findAllRoles());
		return "user/update"; // /WEB-INF/views/user/edit.jsp
	}

	// Xử lý cập nhật
	@PostMapping("/edit")
	public String edit(@RequestParam("roleId") int roleId, @RequestParam("file") MultipartFile file,
			@ModelAttribute("user") User_23110353 user) {
		try {
			if (!file.isEmpty()) {
				String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
				String uploadDir = "src/main/webapp/upload/";
				File saveFile = new File(uploadDir, fileName);
				file.transferTo(saveFile);
				user.setImages(fileName);
			} else {
				User_23110353 oldUser = usersService.findById(user.getUserId()).orElse(null);
				if (oldUser != null) {
					user.setImages(oldUser.getImages());
				}
			}

			UserRoles_23110353 role = usersService.findRoleById(roleId);
			user.setRole(role);

			usersService.save(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/seller/users";
	}

	// Xóa user
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		usersService.deleteById(id);
		return "redirect:/seller/users";
	}
}
