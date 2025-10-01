package jun.vn.controller;

import jun.vn.entity.Cart_23110353;

import jun.vn.entity.Product_23110353;
import jun.vn.service.CartService_23110353;
import jun.vn.service.ProductService_23110353;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController_23110353 {

    @Autowired private CartService_23110353 cartService;
    @Autowired private ProductService_23110353 productService;

    // Xem giỏ hàng
    @GetMapping
    public String viewCart(@RequestParam("userId") int userId, Model model) {
        Cart_23110353 cart = cartService.getCartByUser(userId);
        model.addAttribute("cart", cart);
        return "cart/view";
    }

    // Thêm sản phẩm vào giỏ
    @PostMapping("/add")
    public String addToCart(@RequestParam("userId") int userId,
                            @RequestParam("productId") int productId,
                            @RequestParam(defaultValue = "1") int qty,
                            RedirectAttributes ra) {
        Product_23110353 product = productService.findById(productId)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));
        cartService.addToCart(userId, product, qty);
        ra.addFlashAttribute("msg", "Đã thêm vào giỏ hàng!");
        return "redirect:/cart?userId=" + userId;
    }

    // Xóa sản phẩm khỏi giỏ
    @GetMapping("/remove")
    public String removeItem(@RequestParam("userId") int userId,
                             @RequestParam("itemId") String itemId,
                             RedirectAttributes ra) {
        cartService.removeItem(userId, itemId);
        ra.addFlashAttribute("msg", "Đã xóa sản phẩm khỏi giỏ!");
        return "redirect:/cart?userId=" + userId;
    }
}
