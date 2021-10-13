package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static synchronized void buildSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.setProperty("hibernate.current_session_context_class", "thread");
            configuration.addAnnotatedClass(models.User.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
    }

    //Crea la nueva sesión. Pero tiene la peculiaridad de que dicha sesión se almacena cuando la línea ThreadLocalSessionContext.bind(session).
    //Guarda la sesión en la memoria privada del Thread donde se está ejecutando el código.
    public static void openSessionAndBindToThread() {
        Session session = sessionFactory.openSession();
        ThreadLocalSessionContext.bind(session);
    }

    // Nos retorna un objeto SessionFactory que hemos guardado en la variable estática.
    public static SessionFactory getSessionFactory() {
        if (sessionFactory==null) buildSessionFactory();
        return sessionFactory;
    }

    //Cierra la sesión que se creó mediante openSessionAndBindToThread(). Recupera la sesión y la borra de la memoria privada del Thread donde se está ejecutando el código.
    public static void closeSessionAndUnbindFromThread() {
        //Recupera la sesión y la borra de la memoria privada del Thread donde se está ejecutando el código.
        Session session = ThreadLocalSessionContext.unbind(sessionFactory);
        if (session!=null) session.close();
    }
    
    //Cierra el objeto SessionFactory. La única peculiaridad es que comprobamos que el objeto no sea null
    //(por si no se llamó nunca buildSessionFactory() y que no esté ya cerrado (por si ya se ha llamado a closeSessionFactory().
    public static void closeSessionFactory() {
        if ((sessionFactory!=null) && (sessionFactory.isClosed()==false)) sessionFactory.close();
    }

}
