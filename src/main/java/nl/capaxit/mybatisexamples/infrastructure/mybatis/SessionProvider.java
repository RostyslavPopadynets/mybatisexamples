package nl.capaxit.mybatisexamples.infrastructure.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * Created by jamiecraane on 04/07/16.
 */
public interface SessionProvider<T> {
    T withSession(SqlSession session);
}
