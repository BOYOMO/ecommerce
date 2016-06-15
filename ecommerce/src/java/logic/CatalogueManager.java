package logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import model.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.AbstractFacade;
import model.ProductFacade;
@ManagedBean
@ApplicationScoped

public class CatalogueManager implements java.io.Serializable{
    private ArrayList<Product> mylist;
    private double price;
    private String name;
    private int  number;
    @EJB
private ProductFacade productfacade;

    public ProductFacade getProductfacade() {
        return productfacade;
    }

    public void setProductfacade(ProductFacade productfacade) {
        this.productfacade = productfacade;
    }

    public CatalogueManager() {
        this.mylist = new ArrayList<Product>();

    }

  
    
     /* Methodes */
    @PostConstruct
    public void initCatalog() {
        
        
        Product P1 = new Product();
        Product P2 = new Product();
        P1.setId(0);
        P1.setNom("pomme");
        P1.setPrix(20.6);
        P2.setId(1);
        P2.setNom("mangue");
        P2.setPrix(10.6);
        this.mylist.add(P1);
          this.mylist.add(P2);
         mylist.addAll( productfacade.findAll());
        
          
    }
    
    /** Getters
     * @return  */
    public ArrayList<Product> getMylist() {
        return mylist;
    }
      public double getPricee() {
        return price;
    }

    public void setPricee(double price) {
        this.price = price;
    }

    public String getNamee() {
        return name;
    }

    public void setNamee(String name) {
        this.name = name;
    }

    public int getNumbere() {
        return number;
    }

    public void setNumbere(int number) {
        this.number = number;
    }
    /** Setters
     * @param value */
    public void SetMylist(ArrayList<Product> value) {
        mylist = value;
    }
     public String createProduct() {
      Product  t=new Product();
      t.setId(getNumbere());
      t.setNom(getNamee());
      t.setPrix(getPricee());
     this.mylist.add(t);
  
           productfacade.create(t);
      return "fincreation";
    }
     
     
}