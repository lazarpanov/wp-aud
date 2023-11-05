package mk.ukim.finki.wpaud.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "category-servlet", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {
    class Category {
        private String name;
        private String desc;

        public Category(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private List<Category> categoryList = null;

    @Override
    public void init() throws ServletException {
        super.init();
        this.categoryList = new ArrayList<>();
        this.categoryList.add(new Category("Software", "Software desc"));
        this.categoryList.add(new Category("Books", "Books desc"));
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
        categoryList.stream().forEach(category -> out.format("<li>%s %s</li>", category.getName(), category.getDesc()));
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
        addCategory(categoryName, categoryDesc);
        resp.sendRedirect("/servlet/category");
    }

    public void addCategory(String name, String desc) {
        categoryList.add(new Category(name,desc));
    }
}
