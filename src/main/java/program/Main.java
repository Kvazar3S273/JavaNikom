package program;

import entities.Category;
import entities.Part;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utilites.DbContext;

import java.util.List;
import java.util.Scanner;

import static entities.CategoryCrud.*;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Session context = DbContext.getSessionFactory().openSession();
        //System.out.println("Успішне з'єднання");


        //CreateCategory(context);
        //ReadCategory(context);
        //UpdateCategory(context);
        DeleteCategory(context);

//        System.out.println("Назва запчастини: ");
//        String partName = in.nextLine();
//        Part part = new Part();
//        part.setName(partName);
//        System.out.println("Опис: ");
//        String partDescription = in.nextLine();
//        part.setDescription(partDescription);
//        System.out.println("Ціна: ");
//        double partPrice = Double.parseDouble(in.nextLine());
//        part.setPrice(partPrice);
//        System.out.println("ID категорії: ");
//        int categoryId=Integer.parseInt(in.nextLine());
//        Category category=new Category();
//        category.setId(categoryId);
//        part.setCategory(category);
//        context.save(part);

        context.close();
    }
}
