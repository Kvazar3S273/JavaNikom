package utilites;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.naming.Name;

public class DbContext {
    private static SessionFactory sessionFactory;
    private DbContext() {}
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                //new Configuration().configure("hibernate.cfg.xml");

                configuration.addAnnotatedClass(Name.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Помилка!" + e);
            }
        }
        return sessionFactory;
    }
}
