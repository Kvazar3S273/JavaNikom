package program;

import entities.Category;
import entities.Part;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utilites.DbContext;

import java.util.List;
import java.util.Scanner;

import static entities.CategoryCrud.*;
import static entities.PartCrud.*;
import static program.Menu.*;
import static utilites.Helper.readInputInt;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Session context = DbContext.getSessionFactory().openSession();
        //System.out.println("Успішне з'єднання");

        int mmChoice = 0;
        do {
            MainMenu();
            mmChoice = readInputInt();
            switch (mmChoice) {
                case 1:
                    int cmChoice = 0;
                    do {
                        CategoryMenu();
                        cmChoice = readInputInt();
                        switch (cmChoice){
                            case 1:
                                CreateCategory(context);
                                System.out.println();
                                break;
                            case 2:
                                ReadCategory(context);
                                System.out.println();
                                break;
                            case 3:
                                UpdateCategory(context);
                                System.out.println();
                                break;
                            case 4:
                                DeleteCategory(context);
                                System.out.println();
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("Таке в меню не пропонувало!");
                        }
                    } while (cmChoice != 9);

                    System.out.println();
                    break;
                case 2:

                    int pmChoice = 0;
                    do {
                        PartMenu();
                        pmChoice = readInputInt();
                        switch (pmChoice){
                            case 1:
                                CreatePart(context);
                                System.out.println();
                                break;
                            case 2:
                                ReadPart(context);
                                System.out.println();
                                break;
                            case 3:
                                UpdatePart(context);
                                System.out.println();
                                break;
                            case 4:
                                DeletePart(context);
                                System.out.println();
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("Таке в меню не пропонувало!");
                        }
                    } while (pmChoice != 9);
                    System.out.println();
                    break;
                case 9:
                    break;

                default:
                    System.out.println("Таке в меню не пропонувало!");
            }
        } while (mmChoice != 9);



        context.close();
    }
}
