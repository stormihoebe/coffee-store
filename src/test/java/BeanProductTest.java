import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class BeanProductTest {

  @Rule
  public DatabaseRule databse = new DatabaseRule();


  @Test
  public void beanProduct_instantiatesAsBeanProductClass_true(){
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    assertTrue(testBeanProduct instanceof BeanProduct);
  }

  @Test
  public void getName_instantiateswithName_true(){
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    assertEquals("Spring Fling", testBeanProduct.getName());
  }

  @Test
  public void getPrice_instantiateswithPrice_true(){
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    final float DELTA = 1;
    assertEquals(14, testBeanProduct.getPrice(), DELTA);
  }

  @Test
  public void getOrigin_instantiateswithOrigin_true(){
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    assertEquals("Mexico", testBeanProduct.getOrigin());
  }

  @Test
  public void getRoast_instantiateswithRoast_true(){
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    assertEquals("City Roast", testBeanProduct.getRoast());
  }

  @Test
  public void getId_beanProductInstantiatesWithId_int() {
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    testBeanProduct.save();
    assertTrue(0 < testBeanProduct.getId());
  }

  @Test
  public void save_successfullyAddBeanProductToDatabase_list() {
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    testBeanProduct.save();
    assertTrue(BeanProduct.all().get(0).equals(testBeanProduct));
  }

  @Test
  public void all_returnsAllInstancesOfBeanProduct_true() {
    BeanProduct firstBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    firstBeanProduct.save();
    BeanProduct secondBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    secondBeanProduct.save();
    assertEquals(true, BeanProduct.all().get(0).equals(firstBeanProduct));
    assertEquals(true, BeanProduct.all().get(1).equals(secondBeanProduct));
  }


}
