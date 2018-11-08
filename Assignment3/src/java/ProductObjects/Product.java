/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductObjects;

import java.io.Serializable;
import java.text.NumberFormat;

/*
Author: Kyle Roberts
Desc: Product object for setting and getting data
*/
public class Product implements Serializable{
    
    private Long productId;
    private String code;
    private String description;
    private double unitprice;
    
    public Product(){}
    
    public Long getId(){
        return productId;
    }
    
    public void setId(Long productId){
        this.productId = productId;
    }
    
    public void setCode(String code){
        this.code = code;
    }
    
    public String getCode(){
        return code;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setUnitprice(double unitprice){
        this.unitprice = unitprice;
    }
    
    public double getUnitprice(){
        return unitprice;
    }
    
    public String getPriceCurrencyFormat(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(unitprice);
    }
    
}
