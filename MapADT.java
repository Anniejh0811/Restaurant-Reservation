// --== CS400 File Header Information ==--
// Name: Annie Won
// Email: jwon23@wisc.edu
// Notes to Grader: None
import java.util.NoSuchElementException;

/**
* Interface class that has the following method
*/
public interface MapADT<KeyType, ValueType> {
    public boolean put(KeyType key, ValueType value);
    public ValueType get(KeyType key) throws NoSuchElementException;
    public int size();
    public boolean containsKey(KeyType key);
    public ValueType remove(KeyType key);
    public void clear();
}
