package jun.vn.controller;

import jun.vn.entity.User_23110353;
import jun.vn.service.UsersService_23110353;
import jun.vn.service.IStorageService_23110353;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/auth")
public class AuthController_23110353 {

	@Autowired
	private UsersService_23110353 usersService;

	@Autowired
	private IStorageService_23110353 storageService;

	// ================== GET Login ==================
	@GetMapping("/login")
	public String showLoginForm() {
		return "auth/login"; // login.jsp
	}

	// ================== POST Login ==================
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes ra) {
		try {
			User_23110353 u = usersService.login(username, password).get();

			ra.addFlashAttribute("msg", "Đăng nhập thành công!");

			// kiểm tra roleName
			String roleName = u.getRole().getRoleName();
			if ("ROLE_SELLER".equalsIgnoreCase(roleName)) {
				return "redirect:/dashboard";
			} else {
				return "redirect:/home";
			}

		} catch (RuntimeException e) {
			ra.addFlashAttribute("error", e.getMessage());
			return "redirect:/auth/login";
		}
	}

	// ================== GET Register ==================
	@GetMapping("/register")
	public String showRegisterForm() {
		return "auth/register"; // register.jsp
	}

	// ================== POST Register ==================
	@PostMapping("/register")
	public String register(@RequestParam String username, @RequestParam String email, @RequestParam String fullname,
			@RequestParam String password, @RequestParam(required = false) String phone, @RequestParam String roleName,
			@RequestParam("imageFile") MultipartFile imageFile, RedirectAttributes ra) {
		try {
			User_23110353 user = new User_23110353();
			user.setUsername(username);
			user.setEmail(email);
			user.setFullname(fullname);
			user.setPassword(password);
			user.setPhone(phone);

			// Upload ảnh
			if (imageFile != null && !imageFile.isEmpty()) {
				String filename = storageService.store(imageFile);
				user.setImages(filename);
			}

			usersService.register(user, roleName);

			ra.addFlashAttribute("msg", "Đăng ký thành công!");
			return "redirect:/auth/login";

		} catch (Exception e) {
			e.printStackTrace();
			ra.addFlashAttribute("error", "Lỗi đăng ký: " + e.getMessage());
			return "redirect:/auth/register";
		}
	}
}
