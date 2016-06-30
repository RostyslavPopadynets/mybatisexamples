package nl.capaxit.mybatisexamples.collections;

import nl.capaxit.mybatisexamples.domain.Person;
import nl.capaxit.mybatisexamples.mappers.PersonMapper;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSessionFactory;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSetup;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jamiecraane on 30/06/16.
 */
public class CollectionTest {
    public static void main(String[] args) {
        new CollectionTest().run();
    }

    private void run() {
        new DatabaseSetup().executeScript("db/migration/V1__initial.sql");
        new DatabaseSetup().executeScript("init-db.sql");

        final SqlSession session = DatabaseSessionFactory.getInstance().openSession();
        try {
            final PersonMapper personMapper = session.getMapper(PersonMapper.class);
            final List<Person> persons = personMapper.retrieveAllIncludingAddresses();
            System.out.println("persons.get(0) = " + persons.get(0));
        } finally {
            session.close();
        }
    }
}
