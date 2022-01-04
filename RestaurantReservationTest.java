// --== CS400 File Header Information ==--
// Name: Annie Won
// Email: jwon23@wisc.edu
// Notes to Grader: None

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This Junit class implements tests RestaurantReservation class.
 * 
 */
class RestaurantReservationTest {
  RestaurantReservation<String, Person> r;
  Person p1;
  Person p2;
  Person p3;
  
  @BeforeEach
  public void createInstane() {
    r = new RestaurantReservation<String, Person>(6);
    p1 = new Person("Annie", true, 3, "5");
    p2 = new Person("Tom", true, 3, "5");
    p3 = new Person("David", false, 4, "7");
  }
  
  /**
   * This tests put method if person is correctly put in the hashtable
   * 
   */
  @Test
  public void putTest() {
    r.put("Annie", p1);
    r.put("Tom", p2);
    r.put("David", p3);
    assertEquals(r.printKey(), "David Tom Annie ");
  }
  
  /**
   * This tests remove method if person is correctly removed in the hashtable
   * 
   */
  @Test
  public void removeTest() {
    r.put("Annie", p1);
    r.put("Tom", p2);
    r.put("David", p3);
    r.remove("David");
    assertEquals(r.printKey(), "Tom Annie ");
  }
  
  /**
   * This tests get method if it correctly get the value in the hashtable
   * 
   */
  @Test
  public void getTest() {
    r.put("Annie", p1);
    r.put("Tom", p2);
    r.put("David", p3);
    assertEquals(r.get("Annie").getName(), "Annie");
    assertEquals(r.get("Annie").getChairNeeded(), true);
    assertEquals(r.get("Annie").getPeopleNumber(), 3);
    assertEquals(r.get("Annie").getTime(), "5");
  }
  
  /**
   * This tests containKey method if it correctly gives the right boolean value if hashtable contains the key
   * 
   */
  @Test
  public void containKeyTest() {
    r.put("Annie", p1);
    r.put("Tom", p2);
    r.put("David", p3);
    assertEquals(r.containsKey("Annie"), true);
  }
  
  /**
   * This tests size method if it correctly returns the size
   */
  @Test
  public void getSizeTest() {
    r.put("Annie", p1);
    r.put("Tom", p2);
    r.put("David", p3);
    assertEquals(r.size(), 3);
  }

}
