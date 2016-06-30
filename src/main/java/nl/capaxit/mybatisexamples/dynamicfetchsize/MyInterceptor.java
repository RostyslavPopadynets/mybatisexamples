package nl.capaxit.mybatisexamples.dynamicfetchsize;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by jamiecraane on 30/06/16.
 */
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(final Invocation invocation) throws Throwable {
        return invocation;
    }

    @Override
    public Object plugin(final Object target) {
        if (target instanceof DefaultParameterHandler) {
            DefaultParameterHandler defaultParameterHandler = (DefaultParameterHandler) target;
            try {
                final Field mappedStatement = defaultParameterHandler.getClass().getDeclaredField("mappedStatement");
//                Just for testing purposes.
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return target;
    }

    @Override
    public void setProperties(final Properties properties) {

    }
}
