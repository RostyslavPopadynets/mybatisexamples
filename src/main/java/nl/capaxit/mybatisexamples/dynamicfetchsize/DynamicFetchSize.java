package nl.capaxit.mybatisexamples.dynamicfetchsize;

import nl.capaxit.mybatisexamples.mappers.PersonMapper;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSessionFactory;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSetup;
import nl.capaxit.mybatisexamples.util.Timeit;
import org.apache.ibatis.session.SqlSession;
import org.flywaydb.core.Flyway;

/**
 * Created by jamiecraane on 27/06/16.
 */
public class DynamicFetchSize {
    public static void main(String[] args) {
        new DynamicFetchSize().run();
    }

    private void run() {
        new DatabaseSetup().executeScript("db/migration/V1__initial.sql");
        new DatabaseSetup().executeScript("init-db.sql");

        final SqlSession session = DatabaseSessionFactory.getInstance().openSession();
        try {
            final PersonMapper personMapper = session.getMapper(PersonMapper.class);
//            settingg fetchsize dynamcally is not supported. It might be done using an interceptor and reflection.
            Timeit.code(() ->personMapper.retrieveAll(100));
        } finally {
            session.close();
        }
    }

    private void initDb() {
        final Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:h2:mem:test;MODE=PostgreSQL;AUTOCOMMIT=ON;MVCC=TRUE", "", "");
        flyway.migrate();
    }

}
