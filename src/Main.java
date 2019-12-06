import com.sun.javaws.IconUtil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println(PizzaStatus.valueOf("ORdERED"));
        //PizzaStatus.values()
        //PizzaStatus.READY.ordinal()

        WebShop ws = new WebShop();
        ws.orderPizza("hawai", 28, PizzaStatus.READY);
        ws.orderPizza("songoku", 45, PizzaStatus.ORDERED);
        ws.orderPizza("mogyoros", 32, PizzaStatus.ORDERED);
        ws.orderPizza("hawai", 28, PizzaStatus.DELIVERED);
        ws.orderPizza("hawai", 28, PizzaStatus.ORDERED);
        ws.orderPizza("hawai", 28, PizzaStatus.READY);

        ws.getSizes();
//        ws.print();
//        System.out.println("---------------------------------------------");
//        ws.sortWithComparator();
//        ws.print();
//        ws.work();
//        ws.sort();
//        ws.print();
    }
}
