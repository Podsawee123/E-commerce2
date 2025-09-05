package ObserverPattern;
import java.util.ArrayList;
import java.util.List;
import DataModels.*;

/**
 * Subject (Publisher) ที่คอยแจ้งข่าวสาร
 */

public class OrderProcessor {
    private final List<OrderObsever> obsevers = new ArrayList<>();

    public void register(OrderObsever obsever){
        obsevers.add(obsever);
    }
    public void unregister(OrderObsever obsever){
        obsevers.remove(obsever);
    }
    private void notifyObservers(Order order){
        for(OrderObsever obsever : obsevers){
            obsever.update(order);
        }
    }
    public void processOrder(Order order){
        System.out.println("\nProcessing order " + order.orderId() + "...");
        // ... ตรรกะการประมวลผลคำสั่งซื้ออื่นๆ ...
        System.out.println("Order processed successfully. ");

        // แจ้งเตือนผู้ติดตามทั้งหมด
        notifyObservers(order);
    }
}