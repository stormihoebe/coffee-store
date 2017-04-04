import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class MerchProduct extends Product {
  public String brand;
  public String details;
  public static final String DATABASE_TYPE = "merch";

  public MerchProduct(String name, float price, String brand, String details){
    this.name = name;
    this.price = price;
    this.brand = brand;
    this.details = details;
    type = DATABASE_TYPE;
  }

  public String getBrand(){
    return brand;
  }

  public String getDetails(){
    return details;
  }

  public static List<MerchProduct> all() {
    String sql = "SELECT * FROM products WHERE type = 'merch';";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(MerchProduct.class);
    }
  }

  public static MerchProduct find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM products where id=:id";
      MerchProduct product = con.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(MerchProduct.class);
      return product;
    }
  }



}
