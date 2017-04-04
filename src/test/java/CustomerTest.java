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
}
