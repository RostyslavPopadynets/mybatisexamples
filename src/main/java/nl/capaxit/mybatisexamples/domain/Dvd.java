package nl.capaxit.mybatisexamples.domain;

/**
 * Created by jamiecraane on 01/07/16.
 */
public class Dvd extends Product {
    private String actor;

    public String getActor() {
        return actor;
    }

    public void setActor(final String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dvd{");
        sb.append("actor='").append(actor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
