package team.ed.views;

import team.ed.objetos.Product;
import team.ed.test.Color;

import java.util.List;
import java.util.Scanner;

public class View {

    public void showPrincipalHeader() {
        System.out.print(Color.YELLOW);
        System.out.println("\t\t**************************************");
        System.out.println("\t\t* BIENVENIDOS A LA CAJA REGISTRADORA *");
        System.out.println("\t\t**************************************");
        System.out.print(Color.RESET);
    }

    public void showEnterOption() {
        System.out.print("\t\t* Digite una opción: ");
    }

    public void showPrincipalMenu() {
        System.out.print(Color.BLUE_BOLD);
        System.out.println("\t\t\t 1. Comprar");
        System.out.println("\t\t\t 2. Vender");
        System.out.println("\t\t\t 3. Inventario");
        System.out.println("\t\t\t 4. Compras");
        System.out.println("\t\t\t 5. Ventas");
        System.out.println("\t\t\t 6. Salir");
        System.out.print(Color.RESET);
        showEnterOption();
    }

    public void showBuyMenu() {
        System.out.print(Color.YELLOW);
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*            MENU DE COMPRAS         *");
        System.out.println("\t\t**************************************");
        System.out.print(Color.RESET);
    }

    public void showSaleMenu() {
        System.out.print(Color.YELLOW);
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*            MENU DE VENTAS          *");
        System.out.println("\t\t**************************************");
        System.out.print(Color.RESET);
    }

    public void showStock(Product[] products) {
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

    public void showSales(List<Product> products) {
        System.out.print(Color.YELLOW);
        System.out.println("\t\t*****************************************************");
        System.out.println("\t\t*                  V E N T A S                      *");
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

    public void showPurchases(List<Product> products) {
        System.out.print(Color.YELLOW);
        System.out.println("\t\t*****************************************************");
        System.out.println("\t\t*                C O M P R A S                      *");
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


    public void showProductOptions() {
        System.out.print(Color.BLUE_BOLD);
        System.out.println("\t\t\t1. Papas");
        System.out.println("\t\t\t2. Arroz");
        System.out.println("\t\t\t3. Carne");
        System.out.println("\t\t\t4. Volver");
        System.out.print(Color.RESET);
    }

    public void clearConsole() {
        try {
            switch (System.getProperty("os.name").toLowerCase()) {
                case "linux":
                case "darwin":
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

    public int getAmount(Scanner teclado) {
        System.out.print("\t\t\tDigite la cantidad: ");
        return teclado.nextInt();
    }

    public int getPrice(Scanner teclado) {
        System.out.print("\t\t\tDigite el precio por unidad: ");
        return teclado.nextInt();
    }
}
