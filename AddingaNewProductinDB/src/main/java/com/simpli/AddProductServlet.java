package com.simpli;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce_db.Product;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Add Product</h2>");
        out.println("<form method=\"POST\">");
        out.println("Name: <input type=\"text\" name=\"name\"><br>");
        out.println("Price: <input type=\"number\" step=\"0.01\" name=\"price\"><br>");
        out.println("Description: <input type=\"text\" name=\"description\"><br>");
        out.println("<input type=\"submit\" value=\"Add\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        // Retrieve form data
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        // Validate form data
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            out.println("Please provide all required fields");
            return;
        }

        // Create a new EProduct object
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        

        // Use Hibernate to add the product to the database
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            out.println("Product added successfully");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            out.println("Failed to add product: " + e.getMessage());
        } finally {
            session.close();
        }

        out.println("</body></html>");
    }
}
