import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public abstract class Product {
  public int id;
  public String name;
  public float price;
  public String type;

  public String getName() {
    return name;
  }

  public int getId(){
    return id;
  }

  public float getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object otherProduct){
    if(!(otherProduct instanceof Product)){
      return false;
    } else {
      Product newProduct = (Product) otherProduct;
      return this.getName().equals(newProduct.getName()) &&
             this.getPrice() == newProduct.getPrice();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO products (name, price, type) VALUES (:name, :price, :type)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("price", this.price)
      .addParameter("type", this.type)
      .executeUpdate()
      .getKey();
    }
  }


}
