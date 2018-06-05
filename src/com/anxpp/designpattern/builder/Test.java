package com.anxpp.designpattern.builder;

/**
 * 构造器模式其实就是把类的构建方法 从 setter中解放出来，构建几个具体的构造器类，每次创建对象的时候直接使用对应的构造器类，
 * 就可以把预制的参数设置到新构建的对象中去了，这样省去了使用setter方法去一个一个属性的构建。其实该模式用途不大。
 */
public class Test {
    //创建实例
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        //构造器实现类1
        PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();
        waiter.setPizzaBuilder(hawaiian_pizzabuilder);
        waiter.constructPizza();
        Pizza pizza = waiter.getPizza();
        System.out.println(pizza.toString());
        //构造器实现类2
        PizzaBuilder spicy_pizzabuilder = new SpicyPizzaBuilder();
        waiter.setPizzaBuilder(spicy_pizzabuilder);
        waiter.constructPizza();
        pizza = waiter.getPizza();
        System.out.println(pizza.toString());
    }
}

//Pizza基类
class Pizza {
    //面团
    private String dough = "";
    //酱
    private String sauce = "";
    //配料
    private String topping = "";

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}


//pizza生成器抽象类
abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public abstract void buildDough();

    public abstract void buildSauce();

    public abstract void buildTopping();
}

//具体的pizza生成器类
class HawaiianPizzaBuilder extends PizzaBuilder {
    public void buildDough() {
        pizza.setDough("cross");
    }

    public void buildSauce() {
        pizza.setSauce("mild");
    }

    public void buildTopping() {
        pizza.setTopping("ham+pineapple");
    }
}


class SpicyPizzaBuilder extends PizzaBuilder {
    public void buildDough() {
        pizza.setDough("pan baked");
    }

    public void buildSauce() {
        pizza.setSauce("hot");
    }

    public void buildTopping() {
        pizza.setTopping("pepperoni+salami");
    }
}

//创建pizza
class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}
