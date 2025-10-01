package jun.vn.controller;

import jun.vn.entity.Product_23110353;
import jun.vn.service.ProductService_23110353;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController_23110353 {

    @Autowired
    private ProductService_23110353 productService;

    //Mặc định chuyển hướng đến danh sách sản phẩm
    @GetMapping("")
    public String index() {
		return "redirect:/home/list";
	}
    // Hiển thị danh sách sản phẩm
    @GetMapping("/list")
    public String list(Model model) {
        List<Product_23110353> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/list"; 
    }
	// Hiển thị chi tiết sản phẩm
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        Product_23110353 product = productService.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "product/detail"; 
    }
}
