package nl.capaxit.mybatisexamples.infrastructure.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * Created by jamiecraane on 04/07/16.
 */
public class SessionTemplate {
    public static <T> T execute(final SessionProvider<T> sessionProvider) {
        final SqlSession session = DatabaseSessionFactory.getInstance().openSession();
        try {
            return sessionProvider.withSession(session);
        } finally {
            session.close();
        }
    }

    public static <T> T executeInTransaction(final SessionProvider<T> sessionProvider) {
        final SqlSession session = DatabaseSessionFactory.getInstance().openSession();
        try {
            final T t = sessionProvider.withSession(session);
            session.commit();
            return t;
        } catch (Throwable t) {
            session.rollback();
            throw t;
        } finally {
            session.close();
        }
    }

}
