package nl.capaxit.mybatisexamples.inheritance;

import nl.capaxit.mybatisexamples.domain.Product;
import nl.capaxit.mybatisexamples.mappers.ProductMapper;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSessionFactory;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSetup;
import org.apache.ibatis.session.SqlSession;

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

        final SqlSession session = DatabaseSessionFactory.getInstance().openSession();
        try {
            final ProductMapper mapper = session.getMapper(ProductMapper.class);
            final List<Product> products = mapper.retrieveAll();
            System.out.println("products = " + products);
        } finally {
            session.close();
        }
    }
}
