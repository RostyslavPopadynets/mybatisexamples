package nl.capaxit.mybatisexamples.resulthandler;

import nl.capaxit.mybatisexamples.mappers.PersonMapper;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSessionFactory;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSetup;
import org.apache.ibatis.session.SqlSession;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by jamiecraane on 03/07/16.
 */
public class ResultHandlerTest {
    public static void main(String[] args) {
        new ResultHandlerTest().run();
    }

    private void run() {
        new DatabaseSetup().executeScript("db/migration/V1__initial.sql");
        new DatabaseSetup().executeScript("init-db.sql");

        final SqlSession session = DatabaseSessionFactory.getInstance().openSession();
        BufferedWriter writer = null;
        try {
            Files.delete(Paths.get("persons.csv"));
            writer = Files.newBufferedWriter(Paths.get("persons.csv"), Charset.forName("UTF-8"), StandardOpenOption.CREATE_NEW);
            final PersonsCsvResultHandler resultHandler = new PersonsCsvResultHandler(writer);
            session.select("retrieveAllPersons", resultHandler); // Make sure statement name is unique across all mappers.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeWriter(writer);
            session.close();
        }
    }

    private void closeWriter(final BufferedWriter writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
}
