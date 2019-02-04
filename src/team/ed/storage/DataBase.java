package team.ed.storage;

import team.ed.objetos.Meat;
import team.ed.objetos.Potato;
import team.ed.objetos.Product;
import team.ed.objetos.Rice;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private Product[] products;
    private List<Product> sales;
    private List<Product> purchases;

    public DataBase() {
        products = new Product[3];
        Product potato = new Potato("Sabanera");
        Product rice = new Rice("Calidad");
        Product meat = new Meat("Lomo fino");

        products[0] = potato;
        products[1] = rice;
        products[2] = meat;

        sales = new ArrayList<>();
        purchases = new ArrayList<>();
    }

    private boolean isValidID(int id) {
        return id >= 0 && id <= 2;
    }

    // Obtiene el producto por el ID
    public Product getByID(int id) {
        if (!isValidID(id)) {
            System.out.println("Ese item no existe");
            return null;
        }

        Product r = null;
        try {
            r = products[id].clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return r;
    }

    // Devuelve todos los productos
    public Product[] getAll() {
        Product[] list = new Product[3];
        try {
            list[0] = products[0].clone();
            list[1] = products[1].clone();
            list[2] = products[2].clone();
        } catch (CloneNotSupportedException ignored) {}

        return list;
    }

    public void buyProduct(Product p) {
        Product oldProduct;
        switch (p.getClass().getSimpleName()) {
            case "Potato":
                oldProduct = products[0];
                break;
            case "Rice":
                oldProduct = products[1];
                break;
            case "Meat":
                oldProduct = products[2];
                break;
            default:
                System.out.println("El producto no es válido");
                return;
        }

        oldProduct.setAmount(oldProduct.getAmount() + p.getAmount());
        oldProduct.setPrice(p.getPrice());
    }

    public void saleProduct(Product p, int amount) {
        Product oldProduct;
        switch (p.getClass().getSimpleName()) {
            case "Potato":
                oldProduct = products[0];
                break;
            case "Rice":
                oldProduct = products[1];
                break;
            case "Meat":
                oldProduct = products[2];
                break;
            default:
                System.out.println("El producto no es válido");
                return;
        }

        oldProduct.setAmount(oldProduct.getAmount() - amount);
    }

    // Agrega ventas
    public void addSale(Product p) {
        sales.add(p);
    }

    // Devuelve todos los productos vendidos
    public Product[] getSales() {
        Product[] list = new Product[sales.size()];
        for (int i = 0; i < sales.size(); i++) {
            try {
                list[i] = products[i].clone();
            } catch (CloneNotSupportedException ignored) {}
        }

        return list;
    }

    // Agrega compras
    public void addPurchase(Product p) {
        purchases.add(p);
    }

    // Devuelve todos los productos comprados
    public Product[] getPurchases() {
        Product[] list = new Product[purchases.size()];
        for (int i = 0; i < purchases.size(); i++) {
            try {
                list[i] = products[i].clone();
            } catch (CloneNotSupportedException ignored) {}
        }

        return list;
    }
}
