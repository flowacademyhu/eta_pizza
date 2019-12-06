import java.util.Comparator;

public class PizzaDeliveryTimeComaparator implements Comparator<Pizza> {
    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.getStatus().getDeliveryTime() - o2.getStatus().getDeliveryTime();
    }
}
