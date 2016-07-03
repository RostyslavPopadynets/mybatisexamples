package nl.capaxit.mybatisexamples.domain;

/**
 * Created by jamiecraane on 01/07/16.
 */
public class Cd extends Product {
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cd{");
        sb.append("artist='").append(artist).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
