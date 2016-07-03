package nl.capaxit.mybatisexamples.resulthandler;

import nl.capaxit.mybatisexamples.domain.Person;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.io.IOException;
import java.io.Writer;

/**
 * Result handler which writes the output of the persons query to a comma separated file (CSV).
 * <p>
 * Created by jamiecraane on 03/07/16.
 */
public class PersonsCsvResultHandler implements ResultHandler<Person> {
    private final Writer writer;

    public PersonsCsvResultHandler(final Writer writer) {
        this.writer = writer;
    }

    @Override
    public void handleResult(final ResultContext<? extends Person> resultContext) {
        final Person person = resultContext.getResultObject();
        final StringBuilder sb = new StringBuilder(person.getFirstName())
                .append(",")
                .append(person.getLastName())
                .append("\n");
        try {
            writer.write(sb.toString());
        } catch (IOException e) {
            // Ignore
        }
    }
}
