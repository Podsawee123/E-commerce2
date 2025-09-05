package StrategyPattern;
import DataModels.*;

/** 
 * Interface สำหรับกลยุทย์ส่วนลด
*/

public interface DiscountStrategy  {
    double applyDiscount(Order order);
}
