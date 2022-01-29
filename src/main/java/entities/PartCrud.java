package entities;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

import static entities.CategoryCrud.ReadCategory;
import static utilites.Helper.readInputInt;

public class PartCrud {
    static Scanner in = new Scanner(System.in);

    public static void CreatePart(Session context) {
        System.out.println("Назва запчастини: ");
        String partName = in.nextLine();
        Part part = new Part();
        part.setName(partName);
        System.out.println("Опис: ");
        String partDescription = in.nextLine();
        part.setDescription(partDescription);
        System.out.println("Ціна: ");
        double partPrice = Double.parseDouble(in.nextLine());
        part.setPrice(partPrice);
        System.out.println("Доступні категорії: ");
        ReadCategory(context);
        System.out.println("Введіть ID категорії: ");
        int categoryId = Integer.parseInt(in.nextLine());
        Category category = new Category();
        category.setId(categoryId);
        part.setCategory(category);
        context.save(part);
    }

    public static void ReadPart(Session context) {
        Query query = context.createQuery("FROM Part");
        List<Part> partList = query.list();
        System.out.println("Список запчастин: ");
        for (Part prt : partList) {
            int i = prt.getId();
            System.out.println(i + " - " + prt.getName() + " - " + prt.getDescription() + " - " + prt.getPrice());
        }
    }

    public static void UpdatePart(Session context) {
        context.beginTransaction();
        System.out.println("Введіть Id запчастини для редагування: ");
        int idPartUpd = readInputInt();
        try {
            Part partUpdate = (Part) context.find(Part.class, idPartUpd);
            System.out.println("Введіть нову назву запчастини: ");
            String newPartName = in.nextLine();
            partUpdate.setName(newPartName);
            context.save(partUpdate);
            context.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void DeletePart(Session context) {
        context.beginTransaction();
        System.out.println("Введіть Id запчастини для видалення: ");
        int idPartDel = readInputInt();
        try {
            Part partDelete = context.find(Part.class, idPartDel);
            context.delete(partDelete);
            System.out.println("Запчастину видалено!");
            context.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
