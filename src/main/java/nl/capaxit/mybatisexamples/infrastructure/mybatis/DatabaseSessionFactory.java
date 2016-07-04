package nl.capaxit.mybatisexamples.infrastructure.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by joel on 12-5-14.
 */
public class DatabaseSessionFactory {
    private static final String CONFIG_RESOURCE = "db/database-config.xml";

    private static SqlSessionFactory sessionFactory;

    public synchronized static SqlSessionFactory getInstance() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }

        return sessionFactory;
    }

    private static SqlSessionFactory createSessionFactory() {
        InputStream inputStream;
        SqlSessionFactory out = null;
        try {
            inputStream = Resources.getResourceAsStream(CONFIG_RESOURCE);
            out = new SqlSessionFactoryBuilder().build(inputStream, "prod");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}
