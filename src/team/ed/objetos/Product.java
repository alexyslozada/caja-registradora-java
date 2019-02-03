package team.ed.objetos;

public abstract class Product implements Cloneable {
    private String name;
    private int amount;
    private double price;

    Product() {}

    Product(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            System.out.println("No se puede registrar una cantidad menor a cero");
            return;
        }

        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("No se pude registrar un precio menor a cero");
            return;
        }

        this.price = price;
    }

    @Override
    public String toString() {
        return "Producto: " + this.name + " - " + this.amount + " - $" + this.price;
    }

    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }
}
