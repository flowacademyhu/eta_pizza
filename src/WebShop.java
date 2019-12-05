import java.util.ArrayList;
import java.util.List;

public class WebShop {
    List<Pizza> pizzas;

    public WebShop() {
        pizzas = new ArrayList<>();
    }

    public void orderPizza(String name, int size, PizzaStatus status) {
        this.pizzas.add(new Pizza(name, size, status));
    }

    public void orderPizza(String name, int size, String status) {
        this.pizzas.add(new Pizza(name, size, PizzaStatus.valueOf(status)));
    }

    public void work() {
        changeFirstPizzaStatus(PizzaStatus.READY, PizzaStatus.DELIVERED);
        changeFirstPizzaStatus(PizzaStatus.ORDERED, PizzaStatus.READY);
    }

    private void changeFirstPizzaStatus(PizzaStatus source, PizzaStatus target) {
        for (Pizza p : pizzas) {
            if(p.getStatus() == source) {
                p.setStatus(target);
                break;
            }
        }
    }

    public void print() {
        this.pizzas.stream().forEach((x)-> System.out.println(x));
    }

    public void printPizzas() {
        for(Pizza p : pizzas) {
            System.out.println(p);
        }
    }
}
