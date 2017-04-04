import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class BeanProduct extends Product {
  public String origin;
  public String roast;
  public static final String DATABASE_TYPE = "bean";

  public BeanProduct(String name, float price, String origin, String roast){
    this.name = name;
    this.price = price;
    this.origin = origin;
    this.roast = roast;
    type = DATABASE_TYPE;
  }

  public String getOrigin(){
    return origin;
  }

  public String getRoast(){
    return roast;
  }

  public static List<BeanProduct> all() {
    String sql = "SELECT * FROM products WHERE type = 'bean';";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(BeanProduct.class);
    }
  }

  public static BeanProduct find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM products where id=:id";
      BeanProduct product = con.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(BeanProduct.class);
      return product;
    }
  }



}
