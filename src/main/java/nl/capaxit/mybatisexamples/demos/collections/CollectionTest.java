package nl.capaxit.mybatisexamples.demos.collections;

import nl.capaxit.mybatisexamples.common.domain.Person;
import nl.capaxit.mybatisexamples.common.mappers.PersonMapper;
import nl.capaxit.mybatisexamples.infrastructure.mybatis.DatabaseSessionFactory;
import nl.capaxit.mybatisexamples.infrastructure.mybatis.DatabaseSetup;
import nl.capaxit.mybatisexamples.infrastructure.mybatis.SessionTemplate;
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

        final List<Person> persons = SessionTemplate.execute(session -> session.getMapper(PersonMapper.class).retrieveAllIncludingAddresses());
        System.out.println("persons = " + persons);
    }
}
