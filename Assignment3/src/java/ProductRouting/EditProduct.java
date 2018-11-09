package ProductRouting;

import DataControl.ProductIO;
import ProductObjects.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
Pathing: products.jsp -> editProduct.jsp
*/

public class EditProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String code = request.getParameter("prodCode");

        String path = getServletContext().getRealPath("/WEB-INF/products.txt");
        ProductIO.init(path);
        List<Product> products = ProductIO.selectProducts();

        Product p = new Product();
        for (int i = 0; i < products.size(); i++) {
            if (code.equals(products.get(i).getCode())) {
                p = products.get(i);
            }
        }
        request.setAttribute("editingProduct", p);

        RequestDispatcher view = request.getRequestDispatcher("editProduct.jsp");
        view.forward(request, response);
    }
}
