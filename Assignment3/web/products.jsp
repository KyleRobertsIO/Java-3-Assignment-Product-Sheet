<%@page import="java.util.List"%>
<%@page import="ProductObjects.Product"%>
<%@page import="ProductObjects.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./CSS/reset.css">
        <link rel="stylesheet" type="text/css" href="./CSS/products.css">
        <title>Product Maintenance</title>
    </head>
    <body>
        <div id="table-container">
            
            <a href="addProduct.jsp"><button id="addButton">Add Product</button></a>
            
            <table>
                <tr>
                    <th>Code</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th></th>
                    <th></th>
                </tr>
                <%
                    List<Product> products = (List<Product>) request.getAttribute("productSheet");
                    for(int i = 0; i < products.size(); i++){
                        out.print("<tr>");
                        
                        out.print("<td>");
                        out.print(products.get(i).getCode());
                        out.print("</td>");
                        
                        out.print("<td>");
                        out.print(products.get(i).getDescription());
                        out.print("</td>");
                        
                        out.print("<td>");
                        out.print(products.get(i).getPriceCurrencyFormat());
                        out.print("</td>");
                        
                        out.print("<td>");
                        out.print("<form method='POST' action='EditProduct'>");
                        out.print("<input type='hidden' value='"+ products.get(i).getCode() +"' name='prodCode'>");
                        out.print("<center><button id='submitButton' type='submit'><img src='./assets/pencil-alt.svg'></button></center>");
                        out.print("</form>");
                        out.print("</td>");
                        
                        out.print("<td>");
                        out.print("<form method='POST' action='DeleteProduct'>");
                        out.print("<input type='hidden' value='"+ products.get(i).getCode() +"' name='prodCode'>");
                        out.print("<center><button id='submitButton' type='submit'><img src='./assets/trash-alt.svg'></button></center>");
                        out.print("</form>");
                        out.print("</td>");
                        
                        out.print("</tr>");
                    }
                %>
            </table>
        </div>
    </body>
</html>
