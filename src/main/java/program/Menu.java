package program;

import static utilites.Helper.readInputInt;

public class Menu {
    public static void MainMenu() {
        System.out.println("-----Меню-----");
        System.out.println("1 - Робота з категоріями");
        System.out.println("2 - Робота з запчастинами");
        System.out.println("9 - Вихід з меню");

    }

    public static void CategoryMenu() {
        System.out.println("--CRUD категорій--");
        System.out.println("1 - Створити нову");
        System.out.println("2 - Вивести список");
        System.out.println("3 - Редагувати існуючу");
        System.out.println("4 - Видалити категорію");
        System.out.println("9 - Повернутись в попереднє меню");

    }

    public static void PartMenu() {
        System.out.println("--CRUD запчастин--");
        System.out.println("1 - Створити нову");
        System.out.println("2 - Вивести список");
        System.out.println("3 - Редагувати існуючу");
        System.out.println("4 - Видалити запчастину");
        System.out.println("9 - Повернутись в попереднє меню");

    }


}
