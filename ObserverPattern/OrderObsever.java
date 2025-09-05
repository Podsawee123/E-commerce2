package ObserverPattern;
import DataModels.*;

/**
 * Interface (Obsever) สำหรับอยู่สังเกตการณ์
 */
public interface OrderObsever {
    void update(Order order);
}