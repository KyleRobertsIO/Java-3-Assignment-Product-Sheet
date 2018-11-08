<%@page import="java.util.List"%>
<%@page import="ProductObjects.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./CSS/reset.css">
        <link rel="stylesheet" type="text/css" href="./CSS/editProduct.css">
        <title>Edit Product</title>
    </head>
    <body>
        <div id="form-container" method="POST" action="ApplyEdits">
            <center>
                <h1>Editing Product</h1>
                <%
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if(errorMessage != null){
                        out.print("<h5 id='errorMsg'>"+ errorMessage +"</h5>");
                    }
                %>
                <form method="POST" action="ApplyEdits">
                    <%
                        try{
                            Product product = (Product) request.getAttribute("editingProduct");
                            out.print("<input type='text' value='"+ product.getCode() +"' placeholder='Product Code 4 Digit' name='code' required maxlength='4' readonly />");
                            out.print("<input type='text' value='"+ product.getDescription() +"' placeholder='Product name / title' name='desc' required maxlength='100' />");
                            out.print("<input type='text' value='"+ product.getUnitprice() +"' placeholder='Price' name='price' required />");
                        }catch(NullPointerException e){
                            out.print("<input type='text' placeholder='Product Code 4 Digit' name='code' required maxlength='4' readonly />");
                            out.print("<input type='text' placeholder='Product name / title' name='desc' required maxlength='100' />");
                            out.print("<input type='text' placeholder='Price' name='price' required />");
                        }
                    %>
                    <br><input type='submit' value='Submit' />
                </form>
            </center>
        </div>
    </body>
</html>
