import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;

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

  @Test
  public void save_recordsTimeOfPurchaseInDatabase() {
    Purchase testPurchase = new Purchase(1, 2);
    testPurchase.save();
    Timestamp savedTime = Purchase.find(testPurchase.getId()).getPurchaseTime();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(rightNow.getDay(), savedTime.getDay());
  }

  @Test
  public void all_returnsAllInstancesOfPurchase_true() {
    Purchase firstPurchase = new Purchase(4, 1);
    firstPurchase.save();
    Purchase secondPurchase = new Purchase(2, 3);
    secondPurchase.save();
    assertEquals(true, Purchase.all().get(0).equals(firstPurchase));
    assertEquals(true, Purchase.all().get(1).equals(secondPurchase));
  }

}
