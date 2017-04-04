import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Timestamp;

public class Customer {
    private String name;
    private String email;
    private int id;

  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
  }

    public String getName() {
      return name;
    }

    public String getEmail() {
      return email;
    }

    public int getId() {
      return id;
    }

  @Override
    public boolean equals(Object otherCustomer){
      if (!(otherCustomer instanceof Customer)) {
        return false;
      } else {
        Customer newCustomer = (Customer) otherCustomer;
        return this.getName().equals(newCustomer.getName()) &&
               this.getEmail().equals(newCustomer.getEmail());
      }
    }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO customers (name, email) VALUES (:name, :email)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("email", this.email)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Customer> all() {
    String sql = "SELECT id, name, email FROM customers";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Customer.class);
    }
  }
}
