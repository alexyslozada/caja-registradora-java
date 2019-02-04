package team.ed.test;

import team.ed.objetos.Meat;
import team.ed.objetos.Potato;
import team.ed.objetos.Product;
import team.ed.objetos.Rice;
import team.ed.storage.DataBase;
import team.ed.views.View;

import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    private static DataBase dataBase = new DataBase();
    private static View vista = new View();

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        int oPrincipal;
        do {
            vista.showPrincipalHeader();
            vista.showPrincipalMenu();
            oPrincipal = teclado.nextInt();
            vista.clearConsole();
            switch (oPrincipal) {
                case 1:
                    vista.showBuyMenu();
                    vista.showProductOptions();
                    buy();
                    break;
                case 2:
                    vista.showSaleMenu();
                    vista.showProductOptions();
                    sale();
                    break;
                case 3:
                    vista.showStock(dataBase.getAll());
                    System.out.println("Digite una tecla para continuar...");
                    teclado.nextInt();
                    break;
                case 4:
                    vista.showStock(dataBase.getPurchases());
                    System.out.println("Digite una tecla para continuar...");
                    teclado.nextInt();
                    break;
                case 5:
                    vista.showStock(dataBase.getSales());
                    System.out.println("Digite una tecla para continuar...");
                    teclado.nextInt();
                    break;
                case 6:
                    System.out.println("Gracias por utilizar nuestra app");
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        } while (oPrincipal != 6);
    }

    private static void buy() {
        int buyOption;
        do {
            vista.showEnterOption();
            buyOption = teclado.nextInt();
            if (buyOption >= 1 && buyOption <=3) {
                buyProduct(buyOption);
            } else if (buyOption == 4) {
                System.out.println("\t\tSaliendo del módulo de compras...");
            } else {
                System.out.println("\t\tOpción no válida");
            }
        } while (buyOption != 4);
    }

    private static void sale() {
        int saleOption;
        do {
            vista.showEnterOption();
            saleOption = teclado.nextInt();
            if (saleOption >= 1 && saleOption <=3) {
                saleProduct(saleOption);
            } else if (saleOption == 4) {
                System.out.println("\t\tSaliendo del módulo de ventas...");
            } else {
                System.out.println("\t\tOpción no válida");
            }
        } while (saleOption != 4);
    }

    private static void buyProduct(int buyOption) {
        Product product = null;
        switch (buyOption) {
            case 1:
                product = new Potato();
                break;
            case 2:
                product = new Rice();
                break;
            case 3:
                product = new Meat();
                break;
            default:
                System.out.println("Opción no válida");
        }
        int amount = vista.getAmount(teclado);
        int price = vista.getPrice(teclado);
        product.setAmount(amount);
        product.setPrice(price);
        dataBase.addPurchase(product);
        dataBase.buyProduct(product);
    }

    private static void saleProduct(int saleOption) {
        Product product = null;
        if (saleOption < 1 || saleOption > 3) {
            System.out.println("el producto no existe");
            return;
        }

        product = dataBase.getByID(saleOption - 1);
        if (product == null) {
            System.out.println("el producto está nulo");
        }
        System.out.println(product);
        int amount = vista.getAmount(teclado);
        product.setPrice(product.getPrice()*1.25);
        System.out.println("\t\t\tValor a recibir: " + amount * product.getPrice());
        dataBase.addSale(product);
        dataBase.saleProduct(product, amount);
    }
}
