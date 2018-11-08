
package ProductObjects;

import DataControl.ProductIO;
import java.util.List;
import java.util.regex.Pattern;

public class ProductValidate {
    
    /*
    Author: Kyle Roberts
    Desc: Used for processing variables of the product to validate the requirments 
    */
    
    public static boolean valCode(String newCode, String path){
        
        boolean check = false; // The true/false check for the code being valid       
        String lowerNewCode = newCode.toLowerCase();         
        /*
            Alphanumeric check
        */
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        boolean hasSpecialChar = p.matcher(lowerNewCode).find();
        if(hasSpecialChar == true){
            System.out.println("Found a non alphanumeric character "
                    + "in the product code\n\n");
            check = true;
        }
        /*
            Product code exists or not
        */
        ProductIO.init(path);
        List<Product> products = ProductIO.selectProducts();
        for(int i = 0; i < products.size(); i++){
            String code = products.get(i).getCode();
            if(code == lowerNewCode){
                System.out.println("Existing code being entered\n\n");
                check = true;
                break;
            }
        }
        return check;
    }
    
    public static boolean valPrice(String newPrice){
        
        boolean check = false; // The true/false check for the code being valid
        
        try{
            double isNum = Double.parseDouble(newPrice);
            if(isNum == Math.floor(isNum)) {
                System.out.println("Input is Integer");
            }else {
                System.out.println("Input is Double");
            }
        } catch(Exception e) {
            if(newPrice.toCharArray().length == 1) {
                System.out.println("Input is Character");
                check = true;
            }else {
                System.out.println("Input is String");
                check = true;
            }
        } 
        return check;
    }
    
}
