package jun.vn.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.Part;

import jun.vn.entity.Category;
import jun.vn.entity.Video;
import jun.vn.services.IVideoService;
import jun.vn.services.ICategoryService;
import jun.vn.services.impl.VideoService;
import jun.vn.services.impl.CategoryService;
import jun.vn.utils.Constant;

@WebServlet(urlPatterns = {"/admin/videos", "/admin/video/add", "/admin/video/edit", "/admin/video/delete"})
@MultipartConfig
public class VideoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final IVideoService videoService = new VideoService();
    private final ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("/admin/videos")) {
            List<Video> list = videoService.findAll();
            req.setAttribute("videos", list);
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);

        } else if (uri.contains("/admin/video/add")) {
            req.setAttribute("categories", categoryService.findAll());
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);

        } else if (uri.contains("/admin/video/edit")) {
            String id = req.getParameter("id");
            Video v = videoService.findById(id);
            req.setAttribute("video", v);
            req.setAttribute("categories", categoryService.findAll());
            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);

        } else if (uri.contains("/admin/video/delete")) {
            String id = req.getParameter("id");
            videoService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (uri.contains("/admin/video/add")) {
            insert(req, resp);
        } else if (uri.contains("/admin/video/edit")) {
            update(req, resp);
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Video v = new Video();
            v.setVideoId(req.getParameter("id"));
            v.setTitle(req.getParameter("title"));
            v.setDecription(req.getParameter("decription"));
            v.setViews(req.getParameter("views"));
            v.setActive(req.getParameter("active") != null);

            // category
            int cateId = Integer.parseInt(req.getParameter("categoryId"));
            Category cate = categoryService.getId(cateId);
            v.setCategory(cate);

            // poster upload
            Part posterPart = req.getPart("poster");
            if (posterPart != null && posterPart.getSize() > 0) {
                String original = Paths.get(posterPart.getSubmittedFileName()).getFileName().toString();
                String ext = original.contains(".") ? original.substring(original.lastIndexOf('.') + 1) : "jpg";
                String newName = System.currentTimeMillis() + "." + ext;

                File saveFile = new File(Constant.DIR + "/video/" + newName);
                saveFile.getParentFile().mkdirs();
                posterPart.write(saveFile.getAbsolutePath());

                v.setPoster("video/" + newName);
            } else {
                v.setPoster("default.jpg");
            }

            videoService.insert(v);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("categories", categoryService.findAll());
            req.setAttribute("error", "Thêm thất bại!");
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            Video v = videoService.findById(id);
            if (v == null) {
                resp.sendRedirect(req.getContextPath() + "/admin/videos");
                return;
            }

            v.setTitle(req.getParameter("title"));
            v.setDecription(req.getParameter("decription"));
            v.setViews(req.getParameter("views"));
            v.setActive(req.getParameter("active") != null);

            int cateId = Integer.parseInt(req.getParameter("categoryId"));
            Category cate = categoryService.getId(cateId);
            v.setCategory(cate);

            Part posterPart = req.getPart("poster");
            if (posterPart != null && posterPart.getSize() > 0) {
                String original = Paths.get(posterPart.getSubmittedFileName()).getFileName().toString();
                String ext = original.contains(".") ? original.substring(original.lastIndexOf('.') + 1) : "jpg";
                String newName = System.currentTimeMillis() + "." + ext;

                File saveFile = new File(Constant.DIR + "/video/" + newName);
                saveFile.getParentFile().mkdirs();
                posterPart.write(saveFile.getAbsolutePath());

                v.setPoster("video/" + newName);
            }

            videoService.update(v);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        } catch (Exception e) {
            e.printStackTrace();
            String id = req.getParameter("id");
            req.setAttribute("video", videoService.findById(id));
            req.setAttribute("categories", categoryService.findAll());
            req.setAttribute("error", "Cập nhật thất bại!");
            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
        }
    }
}
