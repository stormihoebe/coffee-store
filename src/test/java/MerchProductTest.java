import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class MerchProductTest {
  @Rule
  public DatabaseRule databse = new DatabaseRule();


  @Test
  public void merchProduct_instantiatesAsMerchProductClass_true(){
    MerchProduct testMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    assertTrue(testMerchProduct instanceof MerchProduct);
  }

  @Test
  public void getName_instantiateswithName_true(){
    MerchProduct testMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    assertEquals("French Press BC", testMerchProduct.getName());
  }

  @Test
  public void getPrice_instantiateswithPrice_true(){
    MerchProduct testMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    final float DELTA = 1;
    assertEquals(34, testMerchProduct.getPrice(), DELTA);
  }

  @Test
  public void getBrand_instantiateswithBrand_true(){
    MerchProduct testMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    assertEquals("Bodum Chambord", testMerchProduct.getBrand());
  }

  @Test
  public void getDetails_instantiateswithDetails_true(){
    MerchProduct testMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    assertEquals("Glass & Metal French Press, Fine Craftsmanship", testMerchProduct.getDetails());
  }

  @Test
  public void getId_merchProductInstantiatesWithId_int() {
    MerchProduct testMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    testMerchProduct.save();
    assertTrue(0 < testMerchProduct.getId());
  }

  @Test
  public void save_successfullyAddMerchProductToDatabase_list() {
    MerchProduct testMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    testMerchProduct.save();
    assertTrue(MerchProduct.all().get(0).equals(testMerchProduct));
  }

  @Test
  public void all_returnsAllInstancesOfMerchProduct_true() {
    MerchProduct firstMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    firstMerchProduct.save();
    MerchProduct secondMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    secondMerchProduct.save();
    assertEquals(true, MerchProduct.all().get(0).equals(firstMerchProduct));
    assertEquals(true, MerchProduct.all().get(1).equals(secondMerchProduct));
  }

  @Test
  public void find_returnsMerchProductWithSameId_secondMerchProduct() {
    MerchProduct firstMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    firstMerchProduct.save();
    MerchProduct secondMerchProduct = new MerchProduct("French Press BC", 34, "Bodum Chambord", "Glass & Metal French Press, Fine Craftsmanship");
    secondMerchProduct.save();
    assertEquals(MerchProduct.find(secondMerchProduct.getId()), secondMerchProduct);
  }


}
