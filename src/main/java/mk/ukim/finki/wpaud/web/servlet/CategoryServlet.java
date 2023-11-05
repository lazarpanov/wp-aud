package mk.ukim.finki.wpaud.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wpaud.model.Category;
import mk.ukim.finki.wpaud.service.CategoryService;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static mk.ukim.finki.wpaud.bootstrap.DataHolder.categories;

@WebServlet(name = "category-servlet", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {

    private final CategoryService categoryService;

    public CategoryServlet(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String ipAddr = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");

        out.write("<html>");
        out.write("<head>");
        out.write("</head>");
        out.write("<body>");
        out.println("<h3>User info:</h3>");
        out.format("IP Address: %s <br>", ipAddr);
        out.format("Client Agent: %s", clientAgent);
        out.println("<h3>Category List</h3>");
        out.write("<ul>");
        categories.stream().forEach(category -> out.format("<li>%s %s</li>", category.getName(), category.getDesc()));
        out.write("</ul>");
        out.println("<h3> Add a category</h3>");
        out.println("<form method='POST' action='/servlet/category'>");
        out.println("<label for='name'>Name:</label>");
        out.println("<input id='name' type='text' name='name' />");
        out.println("<label for='description'>Description:</label>");
        out.println("<input id='description' type='text' name='description' />");
        out.println("<input type='submit' value='Submit'/>");
        out.println("</form>");
        out.write("</body>");
        out.write("</html>");
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("name");
        String categoryDesc = req.getParameter("description");
        categoryService.create(categoryName, categoryDesc);
        resp.sendRedirect("/servlet/category");
    }
}
