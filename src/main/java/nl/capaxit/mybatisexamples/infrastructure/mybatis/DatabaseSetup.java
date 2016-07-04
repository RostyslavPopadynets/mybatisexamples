package nl.capaxit.mybatisexamples.infrastructure.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * Created by jamiecraane on 30/06/16.
 */
public class DatabaseSetup {
    public void executeScript(final String script) {
        final SqlSession sqlSession = DatabaseSessionFactory.getInstance().openSession();
        final ScriptRunner runner = new ScriptRunner(sqlSession.getConnection());
        try {
            runner.setAutoCommit(true);
            runner.setStopOnError(true);
            runner.runScript(Resources.getResourceAsReader(script));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            runner.closeConnection();
            sqlSession.close();
        }

    }
}
