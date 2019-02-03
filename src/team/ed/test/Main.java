package team.ed.test;

import team.ed.objetos.Meat;
import team.ed.objetos.Potato;
import team.ed.objetos.Product;
import team.ed.objetos.Rice;
import team.ed.storage.DataBase;

import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    private static DataBase dataBase = new DataBase();

    public static void main(String[] args) {
        Product potato = new Potato();
        potato.setAmount(50);
        potato.setPrice(1);

        Product rice = new Rice();
        rice.setAmount(100);
        rice.setPrice(3);

        Product meat = new Meat();
        meat.setAmount(25);
        meat.setPrice(5);

        dataBase.buyProduct(potato);
        dataBase.buyProduct(rice);
        dataBase.buyProduct(meat);

        showStock(dataBase.getAll());

        potato.setAmount(2);
        rice.setAmount(1);
        meat.setAmount(3);

        dataBase.saleProduct(potato);
        dataBase.saleProduct(rice);
        dataBase.saleProduct(meat);


        showStock(dataBase.getAll());
        Product[] products = dataBase.getAll();
        products[0].setAmount(0);
        showStock(dataBase.getAll());

        showPrincipalHeader();
        showPrincipalMenu();
        int oPrincipal = teclado.nextInt();
        clearConsole();
        switch (oPrincipal) {
            case 1:
                showBuyMenu();
                showProductOptions();
                break;
            case 2:
                showSaleMenu();
                showProductOptions();
                break;
            case 3:
                showStock(dataBase.getAll());
                break;
            default:
                System.out.println("Opción no valida");
        }
    }

    private static void showPrincipalHeader() {
        System.out.print(Color.YELLOW);
        System.out.println("\t\t**************************************");
        System.out.println("\t\t* BIENVENIDOS A LA CAJA REGISTRADORA *");
        System.out.println("\t\t**************************************");
        System.out.print(Color.RESET);
    }

    private static void showEnterOption() {
        System.out.print("\t\t* Digite una opción: ");
    }

    private static void showPrincipalMenu() {
        System.out.print(Color.BLUE_BOLD);
        System.out.println("\t\t\t 1. Comprar");
        System.out.println("\t\t\t 2. Vender");
        System.out.println("\t\t\t 3. Listar");
        System.out.print(Color.RESET);
        showEnterOption();
    }

    private static void showBuyMenu() {
        System.out.print(Color.YELLOW);
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*            MENU DE COMPRAS         *");
        System.out.println("\t\t**************************************");
        System.out.print(Color.RESET);
    }

    private static void showSaleMenu() {
        System.out.print(Color.YELLOW);
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*            MENU DE VENTAS          *");
        System.out.println("\t\t**************************************");
        System.out.print(Color.RESET);
    }

    private static void showStock(Product[] products) {
        System.out.print(Color.YELLOW);
        System.out.println("\t\t*****************************************************");
        System.out.println("\t\t*               I N V E N T A R I O                 *");
        System.out.println("\t\t*****************************************************");
        System.out.print(Color.RESET);

        System.out.print(Color.BLUE_BOLD);
        System.out.println("\t\t-----------------------------------------------------");
        System.out.println("\t\t* PRODUCTO\t| Cantidad\t| Vr Unitario\t| Vr Total\t*");
        System.out.println("\t\t-----------------------------------------------------");
        for (Product v : products) {
            System.out.println("\t\t* "+v.getName()+"\t| "+v.getAmount()+"\t\t| "+v.getPrice()+"\t\t\t| "+v.getAmount()*v.getPrice()+"\t\t*");
        }
        System.out.print(Color.RESET);
    }

    private static void showProductOptions() {
        System.out.print(Color.BLUE_BOLD);
        System.out.println("\t\t\t1. Papas");
        System.out.println("\t\t\t2. Arroz");
        System.out.println("\t\t\t3. Carne");
        System.out.print(Color.RESET);
        showEnterOption();
    }

    private static void clearConsole() {
        try {
            switch (System.getProperty("os.name").toLowerCase()) {
                case "linux":
                case "darwin":
                    System.out.println("linux");
                    System.out.print("\033[H\033[2J");
                    break;
                case "windows":
                    Runtime.getRuntime().exec("cls");
                    break;
                default:
                    System.out.println();
            }
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
    }
}
