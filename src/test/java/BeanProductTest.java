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
  public void beanProduct_instantiateswithName_true(){
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    assertEquals("Spring Fling", testBeanProduct.getName());
  }

  @Test
  public void beanProduct_instantiateswithPrice_true(){
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    final float DELTA = 1;
    assertEquals(14, testBeanProduct.getPrice(), DELTA);
  }

  @Test
  public void beanProduct_instantiateswithOrigin_true(){
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    assertEquals("Mexico", testBeanProduct.getOrigin());
  }

  @Test
  public void beanProduct_instantiateswithRoast_true(){
    BeanProduct testBeanProduct = new BeanProduct("Spring Fling", 14, "Mexico", "City Roast");
    assertEquals("City Roast", testBeanProduct.getRoast());
  }


}
