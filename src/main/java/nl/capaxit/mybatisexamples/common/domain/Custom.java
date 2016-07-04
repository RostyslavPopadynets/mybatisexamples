package nl.capaxit.mybatisexamples.common.domain;

/**
 * Created by jamiecraane on 03/07/16.
 */
public class Custom {
    private Long id;
    private boolean value;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Custom{");
        sb.append("id=").append(id);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(final boolean value) {
        this.value = value;
    }
}
