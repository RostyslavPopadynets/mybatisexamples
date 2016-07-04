package nl.capaxit.mybatisexamples.demos.inheritance;

import nl.capaxit.mybatisexamples.common.domain.Product;
import nl.capaxit.mybatisexamples.common.mappers.ProductMapper;
import nl.capaxit.mybatisexamples.infrastructure.mybatis.DatabaseSetup;
import nl.capaxit.mybatisexamples.infrastructure.mybatis.SessionTemplate;

import java.util.List;

/**
 * Created by jamiecraane on 01/07/16.
 */
public class InheritanceTest {
    public static void main(String[] args) {
        new InheritanceTest().run();
    }

    private void run() {
        new DatabaseSetup().executeScript("db/migration/V1__initial.sql");
        new DatabaseSetup().executeScript("init-db.sql");

        final List<Product> products = SessionTemplate.execute(session -> session.getMapper(ProductMapper.class).retrieveAll());
        System.out.println("products = " + products);
    }
}
