package ObserverPattern;
import DataModels.*;

/**
 * Concrete Observer: ระบบจัดการคลังสินค้า
 */

public class InventoryService implements OrderObsever {

    @Override
    public void update(Order order) {
        System.out.println("[Inventory Service] Stock has been updated for order " 
        + order.orderId());
    }
    
}