import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

public class PurchaseTest {
  @Rule
  public DatabaseRule databse = new DatabaseRule();

  @Test
  public void purchase_instantiatesCorrectly_true(){
    Purchase testPurchase = new Purchase(1, 2);
    assertEquals(true, testPurchase instanceof Purchase);
  }

  @Test
  public void getCustomerId_purchaseInstantiatesWithCustomerId_true(){
    Purchase testPurchase = new Purchase(1, 2);
    assertEquals(1, testPurchase.getCustomerId());
  }

  @Test
  public void getProductId_purchaseInstantiatesWithPruductId_true(){
    Purchase testPurchase = new Purchase(1, 2);
    assertEquals(2, testPurchase.getProductId());
  }

  @Test
  public void getId_SaveGeneratesId_true(){
    Purchase testPurchase = new Purchase(1, 2);
    testPurchase.save();
    assertTrue(0<testPurchase.getId());
  }
}
