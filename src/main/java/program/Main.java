package program;

import org.hibernate.Session;
import utilites.DbContext;

import java.util.Scanner;

public class Main {
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        Session context= DbContext.getSessionFactory().openSession();
        System.out.println("Успішне з'єднання");
        context.close();
    }
}
