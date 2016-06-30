package nl.capaxit.mybatisexamples.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jamiecraane on 30/06/16.
 */
public class Document {
    private Long id;
    private String title;
    private String message;
    private List<DocumentImage> images = new ArrayList<>();

    public void addImage(final DocumentImage image) {
        if (image != null) {
            images.add(image);
        }
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public List<DocumentImage> getImages() {
        return Collections.unmodifiableList(images);
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setImages(final List<DocumentImage> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Document{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", images=").append(images);
        sb.append('}');
        return sb.toString();
    }
}
