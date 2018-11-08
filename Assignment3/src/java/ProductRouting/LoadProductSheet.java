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


public class LoadProductSheet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        String path = getServletContext().getRealPath("/WEB-INF/products.txt");
        ProductIO.init(path);
        List<Product> products = ProductIO.selectProducts();
        
        /*
        
        Add a file not found exception
        
        */
        
        if(products == null){
            System.out.println("The product sheet returned null");
        }
        
        
        
        request.setAttribute("productSheet", products);
        
        RequestDispatcher view = request.getRequestDispatcher("products.jsp");
        view.forward(request, response);
        
    }
}
