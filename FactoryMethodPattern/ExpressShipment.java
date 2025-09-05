package FactoryMethodPattern;

/**
 * Concrete Productการจัดส่งแบบด่วน
 */
public class ExpressShipment implements Shipment{
    @Override
    public String getInfo() {
        return "Standard Delivery";
    }

    @Override
    public double getCost() {
        return 150.0;
    }
}
