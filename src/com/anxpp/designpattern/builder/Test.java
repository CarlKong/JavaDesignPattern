package com.anxpp.designpattern.builder;

/**
 * ������ģʽ��ʵ���ǰ���Ĺ������� �� setter�н�ų�����������������Ĺ������࣬ÿ�δ��������ʱ��ֱ��ʹ�ö�Ӧ�Ĺ������࣬
 * �Ϳ��԰�Ԥ�ƵĲ������õ��¹����Ķ�����ȥ�ˣ�����ʡȥ��ʹ��setter����ȥһ��һ�����ԵĹ�������ʵ��ģʽ��;����
 */
public class Test {
    //����ʵ��
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        //������ʵ����1
        PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();
        waiter.setPizzaBuilder(hawaiian_pizzabuilder);
        waiter.constructPizza();
        Pizza pizza = waiter.getPizza();
        System.out.println(pizza.toString());
        //������ʵ����2
        PizzaBuilder spicy_pizzabuilder = new SpicyPizzaBuilder();
        waiter.setPizzaBuilder(spicy_pizzabuilder);
        waiter.constructPizza();
        pizza = waiter.getPizza();
        System.out.println(pizza.toString());
    }
}

//Pizza����
class Pizza {
    //����
    private String dough = "";
    //��
    private String sauce = "";
    //����
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


//pizza������������
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

//�����pizza��������
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

//����pizza
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
