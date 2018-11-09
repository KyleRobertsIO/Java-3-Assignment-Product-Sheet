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

/*
Pathing: addProduct.jsp -> products.jsp
*/

public class AddProductToFile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        
        String code = request.getParameter("code");
        String desc = request.getParameter("desc");
        String price = request.getParameter("price");
        
        String path = getServletContext().getRealPath("/WEB-INF/products.txt");
        
        String errorMessage = ""; // Will be sent blank in case of valid values
        if(ProductValidate.valCode(code, path) || ProductValidate.valPrice(price)){
            errorMessage = "*Product values enter conflict with requirements*";
            request.setAttribute("errorMessage", errorMessage);
            
            RequestDispatcher view = request.getRequestDispatcher("addProduct.jsp");
            view.forward(request, response);
        }else{
            request.setAttribute("errorMessage", errorMessage);
            
            Product newProduct = new Product();
            
            newProduct.setCode(code);
            newProduct.setDescription(desc);
            double doublePrice = Double.parseDouble(price);
            newProduct.setUnitprice(doublePrice);
            
            ProductIO.init(path);
            ProductIO.insertProduct(newProduct);
            
            List<Product> products = ProductIO.selectProducts();
            request.setAttribute("productSheet", products);
            
            RequestDispatcher view = request.getRequestDispatcher("products.jsp");
            view.forward(request, response);
        }

    }

}
