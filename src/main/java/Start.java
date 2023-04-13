import entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Start {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Customer customer = new Customer("jopa", "popa", "Faz", "Rus", "Tah", "+7 927");
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
