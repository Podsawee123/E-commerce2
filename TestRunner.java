import java.util.*;
import DataModels.*;
import DecoratorPattern.*;
import FactoryMethodPattern.*;
import ObserverPattern.*;
import StrategyPattern.*;

public class TestRunner {
    public static void main(String[] args){
        System.out.println("--- E-commerce System Simulation ---");

        // --- 1 Setup ---
        Product laptop = new Product("P001", "Laptop", 30000.0);
        Product mouse = new Product("P002", "Mouse", 800.0);
        Order myOrder = new Order("ORD-001", List.of(laptop, mouse),"customer@example.com");
    
        OrderCalculator calculator = new OrderCalculator();
        ShipmentFactory shipmentFactory = new ShipmentFactory();

        OrderProcessor orderProcessor = new OrderProcessor();
        InventoryService inventory = new InventoryService();
        EmailService emailer = new EmailService();
        orderProcessor.register(inventory);
        orderProcessor.register(emailer);

        System.out.println("\n--- 2. Testing Strategy Pattern (Discount) ---");
        double originalPrice = myOrder.getTotalPrice();
        System.out.println("Original Price: " + originalPrice);

        DiscountStrategy tenPercentOff = new PercentageDiscount(10);
        double priceAfterFixed = calculator.calculateFinalPrice(myOrder, tenPercentOff);
        System.out.println("Price with 10% discount: " + priceAfterFixed);

        System.out.println("\n--- 3. Testing Factory and Decorator Pattern (Shipment) ---");
        //สร้างการจัดส่งแบบมาตรฐาน
        Shipment standardShipment = shipmentFactory.createShipment("STANDARD");
        System.out.println("Base Shipment: " + standardShipment.getInfo() + ", cost: " + standardShipment.getCost());
        
        // ห่อ ด้วยบริการห่อสินค้า
        Shipment giftwarrped = new GiftWrapDecorator(standardShipment);
        System.out.println("Decoration: " + giftwarrped.getInfo() + ", cost: "+giftwarrped.getCost());

        // ห่อ ด้วยบริการประกันสินค้า
        Shipment fullyLoaded = new InsuranceDecorator(standardShipment, myOrder);
        System.out.println("Fully Decoration: "+ fullyLoaded.getInfo() + ", cost: " +fullyLoaded.getCost());

        System.out.println("\n--- 4. Printing Final Summary ---");
        double finalPrice = priceAfterFixed; //สมมุติว่าใช้ส่วนลด10%
        double totalCost = finalPrice+fullyLoaded.getCost();
        System.out.println("Final price after discount: "+finalPrice);
        System.out.println("Final shipment cost: "+fullyLoaded.getCost());
        System.out.println("TOTAL TO PAY: "+totalCost);

        orderProcessor.processOrder(myOrder);
    }
}

