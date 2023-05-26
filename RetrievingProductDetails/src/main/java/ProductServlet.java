import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simpli.DBConnection;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the product ID from the request
        String productId = request.getParameter("productId");

        try {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");

            InputStream in = getServletContext().getResourceAsStream("config.properties");
            Properties props = new Properties();
            props.load(in);

            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"),
                    props.getProperty("password"));
            Statement stmt = conn.getConnection().createStatement();
            stmt.executeUpdate("use mydatabase");
            out.println("Selected database: mydatabase<br>");

            String query = "SELECT * FROM products WHERE id = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, productId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Product found, display the details
                String productName = rs.getString("name");
                BigDecimal productPrice = rs.getBigDecimal("price");

                out.println("<h2>Product Details</h2>");
                out.println("<p>ID: " + productId + "</p>");
                out.println("<p>Name: " + productName + "</p>");
                out.println("<p>Price: $" + productPrice + "</p>");
            } else {
                // Product not found, display an error message
                out.println("<p>Product not found!</p>");
            }

            pstmt.close();
            stmt.close();
            conn.closeConnection();

            out.println("</body></html>");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
