package jun.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jun.vn.service.SellerService_23110353;

@Controller
@RequestMapping("/seller")  
public class SellerController_23110353 {

    @Autowired
    private SellerService_23110353 sellerService;

    // Danh sách seller
    @GetMapping
    public String list(Model model) {
        model.addAttribute("sellers", sellerService.findAll());
        return "seller/list"; // -> /WEB-INF/views/seller/list.jsp
    }

    // Chi tiết seller
    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("seller", sellerService.findById(id).orElse(null));
        return "seller/detail"; // -> /WEB-INF/views/seller/detail.jsp
    }

    // Xóa seller
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        sellerService.deleteById(id);
        return "redirect:/seller";
    }
}
