package nl.capaxit.mybatisexamples.domain;

/**
 * Created by jamiecraane on 30/06/16.
 */
public class DocumentImage {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocumentImage{");
        sb.append("url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
