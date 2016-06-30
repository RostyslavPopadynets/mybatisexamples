package nl.capaxit.mybatisexamples.objectfactory;

import com.google.gson.Gson;
import nl.capaxit.mybatisexamples.domain.Document;
import nl.capaxit.mybatisexamples.domain.DocumentImage;
import nl.capaxit.mybatisexamples.mappers.DocumentMapper;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSessionFactory;
import nl.capaxit.mybatisexamples.mybatis.DatabaseSetup;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jamiecraane on 30/06/16.
 */
public class ObjectFactoryTest {
    public static void main(String[] args) {
        new ObjectFactoryTest().run();
    }

    private void run() {
        new DatabaseSetup().executeScript("db/migration/V1__initial.sql");

        final SqlSession session = DatabaseSessionFactory.getInstance().openSession();
        try {
            final DocumentMapper mapper = session.getMapper(DocumentMapper.class);
            mapper.insertDocument(new Gson().toJson(getDocument()));
            mapper.insertDocument(new Gson().toJson(getDocument()));
            mapper.insertDocument(new Gson().toJson(getDocument()));

            final List<Document> documents = mapper.retrieveAll();
            System.out.println("documents = " + documents);
        } finally {
            session.close();
        }
    }

    private Document getDocument() {
        final Document document = new Document();
        document.setMessage("Message");
        document.setTitle("title");
        document.addImage(getDocumentImage("/image1"));
        document.addImage(getDocumentImage("/image2"));
        document.addImage(getDocumentImage("/image3"));
        return document;
    }

    private DocumentImage getDocumentImage(final String url) {
        final DocumentImage image = new DocumentImage();
        image.setUrl(url);
        return image;
    }

}
