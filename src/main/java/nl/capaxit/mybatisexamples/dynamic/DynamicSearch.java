package nl.capaxit.mybatisexamples.dynamic;

import nl.capaxit.mybatisexamples.mappers.PersonMapper;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSessionFactory;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSetup;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by jamiecraane on 01/07/16.
 */
public class DynamicSearch {
    public static void main(String[] args) {
        new DynamicSearch().run();
    }

    private void run() {
        new DatabaseSetup().executeScript("db/migration/V1__initial.sql");
        new DatabaseSetup().executeScript("init-db.sql");

        final SqlSession session = DatabaseSessionFactory.getInstance().openSession();
        try {
            final PersonMapper personMapper = session.getMapper(PersonMapper.class);
            System.out.println("all = " + personMapper.find(new SearchSpec.Builder().build()).size());
            System.out.println("by firstName = " + personMapper.find(new SearchSpec.Builder().firstName("Jan").build()).size());
            System.out.println("by lastName = " + personMapper.find(new SearchSpec.Builder().lastName("Janssen").build()).size());
            System.out.println("by first- and lastname = " + personMapper.find(new SearchSpec.Builder().firstName("Jan").lastName("Janssen").build()).size());
        } finally {
            session.close();
        }
    }
}
