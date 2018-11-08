package ProductRouting;

import DataControl.ProductIO;
import ProductObjects.Product;
import ProductObjects.ProductValidate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplyEdits extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        String code = request.getParameter("code");
        String desc = request.getParameter("desc");
        String price = request.getParameter("price");
        
        
        String path = getServletContext().getRealPath("/WEB-INF/products.txt");
        
        String errorMessage = "";
        if(ProductValidate.valPrice(price)){
            errorMessage = "*Product values enter conflict with requirements*";
            request.setAttribute("errorMessage", errorMessage);
            
            
            
            RequestDispatcher view = request.getRequestDispatcher("editProduct.jsp");
            view.forward(request, response);
        }else{
            request.setAttribute("errorMessage", errorMessage);
            
            Product editedProduct = new Product();
            
            // Set edited products variables
            editedProduct.setCode(code);
            editedProduct.setDescription(desc);
            double doublePrice = Double.parseDouble(price);
            editedProduct.setUnitprice(doublePrice);
            
            // Product sheet update
            ProductIO.init(path);
            ProductIO.updateProduct(editedProduct);
            
            List<Product> products = ProductIO.selectProducts();
            request.setAttribute("productSheet", products);
            RequestDispatcher view = request.getRequestDispatcher("products.jsp");
            view.forward(request, response);
        }
    }
}
