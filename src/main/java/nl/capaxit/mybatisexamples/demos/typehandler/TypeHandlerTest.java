package nl.capaxit.mybatisexamples.demos.typehandler;

import nl.capaxit.mybatisexamples.common.domain.Custom;
import nl.capaxit.mybatisexamples.common.mappers.CustomMapper;
import nl.capaxit.mybatisexamples.infrastructure.mybatis.DatabaseSetup;
import nl.capaxit.mybatisexamples.infrastructure.mybatis.SessionTemplate;

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

        final List<Custom> customs = SessionTemplate.execute(session -> session.getMapper(CustomMapper.class).retrieveAll());
        System.out.println("customs = " + customs);
    }
}
