package nl.capaxit.mybatisexamples.objectfactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nl.capaxit.mybatisexamples.domain.Document;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;

/**
 * Created by jamiecraane on 30/06/16.
 */
public class DocumentObjectFactory extends DefaultObjectFactory {
    private static final Gson GSON = new GsonBuilder().create();

    @Override
    public <T> T create(final Class<T> type, final List<Class<?>> constructorArgTypes, final List<Object> constructorArgs) {
        if (type.equals(Document.class)) {
            return createDocument(constructorArgs);
        } else {
            return super.create(type, constructorArgTypes, constructorArgs);
        }
    }

    private <T> T createDocument(final List<Object> ctorArgs) {
        final Document document = GSON.fromJson((String) ctorArgs.get(0), Document.class);
        document.setId((Long) ctorArgs.get(1));
        return (T) document;
    }
}
