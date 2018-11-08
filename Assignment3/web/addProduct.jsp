<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./CSS/reset.css">
        <link rel="stylesheet" type="text/css" href="./CSS/addProduct.css">
        <title>Add Product</title>
    </head>
    <body>
        <div id="form-container">
            <center>
                <h1>Adding Product</h1>
                <%
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if(errorMessage != null){
                        out.print("<h5 id='errorMsg'>"+ errorMessage +"</h5>");
                    }
                %>
                <form method="POST" action="AddProductToFile">
                        <input type="text" placeholder="Product Code 4 Digit" name="code" required maxlength="4">

                        <input type="text" placeholder="Product name / title" name="desc" required maxlength="100">

                        <input type="text" placeholder="Price" name="price" required>
                    <br>
                    <input type="submit" value="Submit">
                </form>
            <center>
        </div>
    </body>
</html>
