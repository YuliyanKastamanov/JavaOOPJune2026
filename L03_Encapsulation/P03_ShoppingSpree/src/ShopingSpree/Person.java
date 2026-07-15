package ShopingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {


    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }


    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void buyProduct(Product product){
        if(this.money >= product.getCost()){
            //ако имаме достатъчно пари, за да си купим продукта ->
            //добавяме продукта в нашия списък с продукти
            this.products.add(product);
            //от парите, с които разполага нашия Пърсън вадим цената на продукта
            this.money -= product.getCost();
            //this.setMoney(this.money - product.getCost());
        }else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }
}
