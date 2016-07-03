package nl.capaxit.mybatisexamples.typehandler;

import nl.capaxit.mybatisexamples.domain.Custom;
import nl.capaxit.mybatisexamples.mappers.CustomMapper;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSessionFactory;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSetup;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jamiecraane on 03/07/16.
 */
public class TypeHandlerTest {
    public static void main(String[] args) {
        new TypeHandlerTest().run();
    }

    private void run() {
        new DatabaseSetup().executeScript("db/migration/V1__initial.sql");
        new DatabaseSetup().executeScript("init-db.sql");

        final SqlSession session = DatabaseSessionFactory.getInstance().openSession();
        try {
            final CustomMapper mapper = session.getMapper(CustomMapper.class);
            final List<Custom> customs = mapper.retrieveAll();
            System.out.println("customs = " + customs);
        } finally {
            session.close();
        }
    }
}
