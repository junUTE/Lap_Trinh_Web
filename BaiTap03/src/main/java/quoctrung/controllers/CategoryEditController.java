package quoctrung.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import quoctrung.constants.constantCategory;
import quoctrung.models.Category;
import quoctrung.services.CategoryService;
import quoctrung.services.UserServiceImpl.CategoryServiceImpl;


@WebServlet(urlPatterns = "/admin/category/edit")
@MultipartConfig
public class CategoryEditController extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	private CategoryService cateService = (CategoryService) new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            Category category = cateService.get(id);   // lấy category từ DB
            req.setAttribute("category", category);    // set vào request
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/editCategory.jsp");
        dispatcher.forward(req, resp);
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");

	    int id = Integer.parseInt(req.getParameter("id"));
	    String name = req.getParameter("name");

	    Category category = new Category();
	    category.setCateid(id);
	    category.setCatename(name);

	    // upload file icon mới nếu có
	    Part filePart = req.getPart("icon");
	    if (filePart != null && filePart.getSize() > 0) {
	        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	        String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
	        String newFileName = System.currentTimeMillis() + "." + ext;

	        File uploadFile = new File(constantCategory.DIR + "/category/" + newFileName);
	        uploadFile.getParentFile().mkdirs();
	        filePart.write(uploadFile.getAbsolutePath());

	        category.setIcon("category/" + newFileName);
	    } else {
	        // giữ icon cũ nếu không upload mới
	        Category old = cateService.get(id);
	        if (old != null) {
	            category.setIcon(old.getIcon());
	        }
	    }

	    // gọi service với Category hợp lệ
	    cateService.edit(category);

	    resp.sendRedirect(req.getContextPath() + "admin/category/list");
	}
}
