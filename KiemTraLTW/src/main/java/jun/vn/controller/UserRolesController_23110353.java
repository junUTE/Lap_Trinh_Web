package jun.vn.controller;

import jun.vn.entity.UserRoles_23110353;
import jun.vn.service.UserRolesService_23110353;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class UserRolesController_23110353 {

    @Autowired
    private UserRolesService_23110353 roleService;

    // Danh sách roles
    @GetMapping("/list")
    public String list(Model model) {
        List<UserRoles_23110353> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "roles/list";
    }

    // Form thêm role
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("role", new UserRoles_23110353());
        return "roles/add";
    }

    // Submit thêm
    @PostMapping("/add")
    public String add(@ModelAttribute("role") UserRoles_23110353 role,
                      RedirectAttributes ra) {
        roleService.save(role);
        ra.addFlashAttribute("msg", "Thêm role thành công!");
        return "redirect:/roles/list";
    }

    // Form update role
    @GetMapping("/update")
    public String updateForm(@RequestParam("id") int id, Model model) {
        UserRoles_23110353 role = roleService.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy role!"));
        model.addAttribute("role", role);
        return "roles/update";
    }

    // Submit update
    @PostMapping("/update")
    public String update(@ModelAttribute("role") UserRoles_23110353 role,
                         RedirectAttributes ra) {
        roleService.save(role);
        ra.addFlashAttribute("msg", "Cập nhật role thành công!");
        return "redirect:/roles/list";
    }

    // Xóa role
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes ra) {
        roleService.deleteById(id);
        ra.addFlashAttribute("msg", "Xóa role thành công!");
        return "redirect:/roles/list";
    }
}
