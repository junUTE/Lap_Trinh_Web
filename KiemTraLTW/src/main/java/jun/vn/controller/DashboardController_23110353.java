package jun.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController_23110353 {

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "seller/dashboard"; // trả về dashboard.jsp
    }
}
