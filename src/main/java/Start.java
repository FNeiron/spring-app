import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Administrator.class)
                .addAnnotatedClass(Dish.class)
                .addAnnotatedClass(Instance.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
        //SessionFactory factory = HibernateUtil.getSessionFactory();
        try {
            //Customer customer = new Customer("po1pa1111", "popa", "Faz", "Rus", "Tah", "+7 927");
            Dish dish = new Dish("bludo", 100, "d", "d");
            Dish dish1 = new Dish("bludo2", 1000, "d", "d");

            Customer cust = (Customer) select(factory, "Customer", "login = 'po1pa'").get(0);
            Instance instance = new Instance(dish, 10);
            Instance instance1 = new Instance(dish1, 10);

            List<Instance> instanceList = new ArrayList<Instance>();
            instanceList.add(instance);
            instanceList.add(instance1);

            Order order = new Order(cust, "aaa", LocalDate.of(2023,1,1), instanceList);

//            for (Instance inst:
//                 instanceList) {
//                inst.setOrder_id(order.getOrder_id());
//            }
            Session session = factory.getCurrentSession();

            session.beginTransaction();
            session.merge(cust);
            //session.save(dish);
            //session.save(dish1);
            session.save(order);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }

    public static List select(SessionFactory factory, String table, String stat) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List lst = session.createQuery("from " + table + " WHERE " + stat).getResultList();
        session.getTransaction().commit();
        return lst;
    }

    public static void update(SessionFactory factory, String table, String upd ,String stat) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("update " + table + " set " + upd +" WHERE " + stat).executeUpdate();
        session.getTransaction().commit();
    }

    public static void delete(SessionFactory factory, String table, String stat) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete from " + table + " WHERE " + stat).executeUpdate();
        session.getTransaction().commit();
    }
    public static void deleteCustomer(SessionFactory factory, int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(session.get(Customer.class, id));
        session.getTransaction().commit();
    }

    public static void deleteCustomer(SessionFactory factory, String stat) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete Customer WHERE " + stat).executeUpdate();
        session.getTransaction().commit();
    }
}
