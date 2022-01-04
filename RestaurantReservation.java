// --== CS400 File Header Information ==--
// Name: Annie Won
// Email: jwon23@wisc.edu
// Notes to Grader: None

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class implements RestaurantReservation hashtable Map implementation to put and remove from the hashtable and find
 * the value using the key. When Collision occurs, it uses chaining.
 * 
 */
public class RestaurantReservation<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  class Info {
    private KeyType key;
    private ValueType value;

    public Info(KeyType key, ValueType value) {
      this.key = key;
      this.value = value;
    }
  }

  int size = 0;
  private LinkedList<Info>[] array;
  int capacity;
  static final int DEFUALT_CAPACITY = 10;

  /**
   * Constructor of RestaurantReservation class
   *
   * @param capacity
   */
  public RestaurantReservation(int capacity) {
    this.capacity = capacity;
    this.array = new LinkedList[capacity];
    for (int i = 0; i < capacity; i++) {
      array[i] = new LinkedList<>();
    }
  }

  /**
   * Constructor of RestaurantReservation class
   *
   */
  public RestaurantReservation() {
    this(DEFUALT_CAPACITY);
  }

  /**
   * Double the size of the hashtable when the capacity is over 80% and rehash the items
   *
   */
  private void rehash() {

    // Double the size of the hash table
    LinkedList<Info>[] old = array;
    this.array = new LinkedList[capacity * 2];
    for (int i = 0; i < capacity * 2; i++) {
      array[i] = new LinkedList<>();
    }

    capacity *= 2;
    size = 0;

    // Rehash the items
    for (int i = 0; i < old.length; i++) {
      LinkedList<Info> list = old[i];
      for (int j = 0; j < list.size(); j++) {
        Info item = list.get(j);
        put(item.key, item.value);
      }
    }
  }

  /**
   * Put Info in the hashtable giving key and value
   *
   * @return true if key and value are successfully added to the hashtable false if key is null and if it already contains the key
   * @param key key to add 
   * @param value value to add 
   */
  public boolean put(KeyType key, ValueType value) {
    if (key == null || containsKey(key)) {
      return false;
    }

    int hash = Math.abs(key.hashCode()) % capacity;
    for (int i = 0; i < array.length; i++) {
      if (i == hash) {
        array[i].add(new Info(key, value));
        size++;
      }
    }
    if (size >= capacity * 0.8) {
      rehash();
    }
    return true;
  }

  /**
   * Get the Value of the hashtable using Key
   *
   * @return value of the hashtable for specific key
   * @param key key to find out 
   */
  public ValueType get(KeyType key) throws NoSuchElementException {
    int hash = Math.abs(key.hashCode()) % capacity;

    for (int i = 0; i < capacity; i++) {
      if (array[hash].get(i).key.equals(key)) {
        return array[hash].get(i).value;
      }
    }
    throw new NoSuchElementException();
  }

  /**
   * Get the size of currently stored Info in the hashtable
   *
   * @return the size of currently stored Info in the hashtable
   */
  public int size() {
    return size;
  }

  /**
   * Check whether hashtable has specific key
   *
   * @param key key that wants to find out
   * @return true if hashtable has the key otherwise false
   */
  public boolean containsKey(KeyType key) {
    int hash = Math.abs(key.hashCode()) % capacity;

    for (int i = 0; i < array[hash].size(); i++) {
      if ((array[hash].get(i).key).equals(key)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Removes the Info in the hashtable
   *
   * @param key key that wants to remove
   * @return removeItem if it removes it successfully, otherwise null
   */
  public ValueType remove(KeyType key) {

    int hash = Math.abs(key.hashCode()) % capacity;

    for (int i = 0; i < array[hash].size(); i++) {
      if (array[hash].get(i).key.equals(key)) {
        ValueType removeItem = array[hash].get(i).value;
        array[hash].remove(i);
        size--;
        return removeItem;
      }
    }
    return null;
  }

  /**
   * Clear the hashtable
   *
   */
  public void clear() {
    size = 0;
    for (int i = 0; i < array.length; i++) {
      array[i].clear();
    }
  }

  /**
   * Get the String representation of the hashtable
   *
   * @return String representation of the hashtable
   */
  public String toString() {
    String str = "";
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].size(); j++) {
        str += array[i].get(j).key + " " + array[i].get(j).value.toString() + "\n";
      }
    }
    return str;
  }

  /**
   * Print only the key vlaues in the hashtable
   *
   * @return String representation of only the key values in the hashtable
   */
  public String printKey() {
    String str = "";
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].size(); j++) {
        str += array[i].get(j).key + " ";
      }
    }
    return str;
  }
}

