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
}
