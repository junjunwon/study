import java.util.List;

/**
 * reference : https://www.baeldung.com/java-interface-segregation
 */
public interface Payment {

    Object status();
    List<Object> getPayments();
}
