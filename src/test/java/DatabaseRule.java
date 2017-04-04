import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
    protected void before() {
      DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/coffee_store_test", null, null);
    }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteCustomerQuery = "DELETE FROM customers *;";
      con.createQuery(deleteCustomerQuery).executeUpdate();
      String deleteProductQuery = "DELETE FROM products *;";
      con.createQuery(deleteProductQuery).executeUpdate();
      String deletePurchasesQuery = "DELETE FROM purchases *;";
      con.createQuery(deletePurchasesQuery).executeUpdate();


    }
  }
}
