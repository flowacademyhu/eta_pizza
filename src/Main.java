public class Main {
    public static void main(String[] args) {
        //System.out.println(PizzaStatus.valueOf("ORdERED"));
        //PizzaStatus.values()
        //PizzaStatus.READY.ordinal()

        WebShop ws = new WebShop();
        ws.orderPizza("songoku", 45, PizzaStatus.ORDERED);
        ws.orderPizza("mogyoros", 32, PizzaStatus.ORDERED);
        ws.orderPizza("hawai", 28, PizzaStatus.ORDERED);


        ws.print();
    }
}
