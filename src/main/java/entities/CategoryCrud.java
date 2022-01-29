package entities;

import org.hibernate.Session;
import org.hibernate.query.Query;
import utilites.DbContext;

import static utilites.Helper.readInputInt;


import java.util.List;
import java.util.Scanner;

public class CategoryCrud {
    static Scanner in = new Scanner(System.in);
    Session context = DbContext.getSessionFactory().openSession();

    public static void CreateCategory(Session context) {
        System.out.println("Назва категорії: ");
        String categoryName = in.nextLine();
        Category category = new Category();
        category.setName(categoryName);
        context.save(category);
    }

    public static void ReadCategory(Session context) {
        Query query = context.createQuery("FROM Category");
        List<Category> categoryList = query.list();
        System.out.println("Список категорій: ");
        for (Category cat : categoryList) {
            int i = cat.getId();
            System.out.print(i + " - ");
            System.out.println(cat.getName());
        }
    }

    public static void UpdateCategory(Session context) {
        context.beginTransaction();
        System.out.println("Введіть Id категорії для редагування: ");
        int idCatUpd = readInputInt();
        try {
            Category catUpdate = (Category) context.find(Category.class, idCatUpd);
            System.out.println("Введіть нову назву категорії: ");
            String newCatName = in.nextLine();
            catUpdate.setName(newCatName);
            context.save(catUpdate);
            context.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void DeleteCategory(Session context) {
        context.beginTransaction();
        System.out.println("Введіть Id категорії для видалення: ");
        int idCatDel = readInputInt();
        try {
            //Category catDelete = (Category) context.load(Category.class, idCatDel);
            Category caDe=context.find(Category.class,idCatDel);

            //System.out.println(catDelete.getName());
            //context.delete(catDelete);
            context.delete(caDe);
            System.out.println("Категорію видалено!");
            //context.save(catDelete);
            context.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static Category FindRecordById(Integer id, Session context) {
        Category findId = null;
        try {
            findId = (Category) context.load(Category.class, id);
        } catch (Exception ex) {
            if (null != context.getTransaction()) {
                context.getTransaction().rollback();
            }
            ex.printStackTrace();
        }
        return findId;
    }
}
