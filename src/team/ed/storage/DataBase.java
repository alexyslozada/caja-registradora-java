package team.ed.storage;

import team.ed.objetos.Meat;
import team.ed.objetos.Potato;
import team.ed.objetos.Product;
import team.ed.objetos.Rice;

import java.util.Arrays;

public class DataBase {

    private Product[] products;

    public DataBase() {
        products = new Product[3];
        Product potato = new Potato("Sabanera");
        Product rice = new Rice("Calidad");
        Product meat = new Meat("Lomo fino");

        products[0] = potato;
        products[1] = rice;
        products[2] = meat;
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

        return products[id];
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

    public void saleProduct(Product p) {
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

        oldProduct.setAmount(oldProduct.getAmount() - p.getAmount());
    }
}
