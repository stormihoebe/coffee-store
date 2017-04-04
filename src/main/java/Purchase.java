import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class Purchase {
  private int id;
  private int customer_id;
  private int product_id;
  private Timestamp time;

  public Purchase(int customer_id, int product_id){
    this.customer_id = customer_id;
    this.product_id = product_id;

  }

  public int getId(){
    return id;
  }

  public int getCustomerId(){
    return customer_id;
  }

  public int getProductId(){
    return product_id;
  }

  public Timestamp getTime(){
    return time;
  }

  @Override
   public boolean equals(Object otherPurchase){
     if (!(otherPurchase instanceof Purchase)) {
       return false;
     } else {
     Purchase newPurchase = (Purchase) otherPurchase;
     return (this.getProductId() == newPurchase.getProductId() && this.getCustomerId() == newPurchase.getCustomerId());
    }
   }

   public void save() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO purchases (customer_id, product_id, time) VALUES (:customer_id, :product_id, now())";
        this.id = (int) con.createQuery(sql, true)
          .addParameter("customer_id", this.customer_id)
          .addParameter("product_id", this.product_id)
          .executeUpdate()
          .getKey();
      }
    }

  public static List<Purchase> all() {
    String sql = "SELECT * FROM communities";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Purchase.class);
    }
  }




}
