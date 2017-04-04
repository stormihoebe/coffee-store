import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Timestamp;

public class CustomerTest {

  @Rule
  public DatabaseRule databse = new DatabaseRule();

  @Test
  public void customer_instantiatesCorrectly_true(){
    Customer testCustomer = new Customer("Happy Jim", "JoyJim@gmail.com");
    assertEquals(true, testCustomer instanceof Customer);
  }

  @Test
  public void getName_customerInstantiatesWithName_Jim(){
    Customer testCustomer = new Customer("Happy Jim", "JoyJim@gmail.com");
    assertEquals("Happy Jim", testCustomer.getName());
  }
  @Test
  public void getEmail_customerInstantiatesWithEmail_joyJim(){
    Customer testCustomer = new Customer("Happy Jim", "JoyJim@gmail.com");
    assertEquals("JoyJim@gmail.com", testCustomer.getEmail());
  }

  @Test
  public void equals_returnsTrueIfNameAndEmailAreSame_true() {
    Customer testCustomer = new Customer("Happy Jim", "JoyJim@gmail.com");
    Customer anotherCustomer = new Customer("Happy Jim", "JoyJim@gmail.com");
    assertTrue(testCustomer.equals(anotherCustomer));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Customer() {
    Customer testCustomer = new Customer("Happy Jim", "JoyJim@gmail.com");
    testCustomer.save();
    assertEquals(true, Customer.all().get(0).equals(testCustomer));
  }

  @Test
  public void save_assignsIdToObject() {
    Customer testCustomer = new Customer("Happy Jim", "JoyJim@gmail.com");
    testCustomer.save();
    Customer savedCustomer = Customer.all().get(0);
    assertEquals(testCustomer.getId(), savedCustomer.getId());
}

  @Test
  public void purchase_createsANewPuchase_true() {
    Customer testCustomer = new Customer("Happy Jim", "JoyJim@gmail.com");
    testCustomer.save();
    testCustomer.purchase(2);
    assertTrue(Purchase.all().size() > 0 );
  }

  @Test
  public void getPurchases_listsAllPurchasesByCustomer_true() {
    Customer testCustomer = new Customer("Happy Jim", "JoyJim@gmail.com");
    testCustomer.save();
    testCustomer.purchase(2);
    testCustomer.purchase(1);
    assertEquals(testCustomer.getPurchases().size(), 2);
  }

}
