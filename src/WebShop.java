import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void sortWithComparator() {
        PizzaDeliveryTimeComaparator pdtc = new PizzaDeliveryTimeComaparator();
        Collections.sort(this.pizzas, pdtc);
    }


    public void sortWithAnonymous() {
        Collections.sort(this.pizzas, new Comparator<Pizza>() {
            @Override
            public int compare(Pizza o1, Pizza o2) {
                return o2.getStatus().getDeliveryTime() - o1.getStatus().getDeliveryTime();
            }
        });
    }

    public void sort() {
        Collections.sort(this.pizzas, (p1, p2) -> p2.getStatus().getDeliveryTime() - p1.getStatus().getDeliveryTime());
    }

    public void sortBySizeWithAnonymous() {
        Collections.sort(this.pizzas, new Comparator<Pizza>() {
            @Override
            public int compare(Pizza o1, Pizza o2) {
                return o2.getSize() - o1.getSize();
            }
        });
    }

    public void sortBySize() {
        Collections.sort(this.pizzas, (p1, p2) -> p2.getSize() - p1.getSize());
    }

    public boolean hasAnyOrderedPizza() {
        return this.pizzas.stream().anyMatch(p -> p.getStatus() == PizzaStatus.ORDERED);
    }

    public List<Pizza> getOrderedPizza() {
        Stream<Pizza> list = this.pizzas.stream().filter(cica->cica.getStatus() == PizzaStatus.ORDERED);
        return list.collect(Collectors.toList()) ;
    }

    public List<Pizza> getOrderedHawaiPizza() {
        return this.pizzas.stream()
                        .filter(pizza->pizza.getStatus() == PizzaStatus.ORDERED)
                        .filter(orderdPizza -> orderdPizza.getName().equals("hawai"))
                        .collect(Collectors.toList()) ;
    }

    public List<Pizza> getPizzaByStatusAndName(PizzaStatus status, String name) {
        return this.pizzas.stream()
                .filter(pizza->pizza.getStatus() == status)
                .filter(orderdPizza -> orderdPizza.getName().equals(name))
                .collect(Collectors.toList()) ;
    }

    public void getSizes() {
        this.pizzas.stream()
                .map(pizza -> pizza.getSize())
                .distinct()
                .forEach(s -> System.out.println(s));
    }

    public void printPizzas() {
        for(Pizza p : pizzas) {
            System.out.println(p);
        }
    }
}
