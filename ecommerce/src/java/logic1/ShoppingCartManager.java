/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic1;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import model.Product;
import model1.ShoppingCartItem;

/**
 *
 * @author stephane
 */
@ManagedBean
@SessionScoped
public class ShoppingCartManager {
    private ArrayList<ShoppingCartItem> list;
    private Product prodToAdd;
    
    public ShoppingCartManager() {
          this.list = new ArrayList<ShoppingCartItem>();

    }

    public Product getProdToAdd() {
        return prodToAdd;
    }

    public void setProdToAdd(Product prodToAdd) {
        this.prodToAdd = prodToAdd;
    }


    

    public ArrayList<ShoppingCartItem> getList() {
        return list;
    }

    public void setList(ArrayList<ShoppingCartItem> list) {
        this.list = list;
    }
    
     @PostConstruct 
     
    public void initCart(){
    ShoppingCartItem s= new ShoppingCartItem();
    Product p= new Product();
    p.setId(0);
    p.setPrix(10);
    p.setNom("banane");
    s.setQuantite(2);
    s.setProduit(p);
    s.setId(3);
    this.list.add(s);
}
    public String addtoCart(){
        ShoppingCartItem s= new ShoppingCartItem();
        s.setProduit(prodToAdd);
        this.list.add(s);
        return "case1";
    }
    
}
