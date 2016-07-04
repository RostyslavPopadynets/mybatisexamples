package nl.capaxit.mybatisexamples.demos.dynamic;

/**
 * Created by jamiecraane on 01/07/16.
 */
public class SearchSpec {
    private String firstName;
    private String lastName;

    public SearchSpec(final Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Builder {
        private String firstName;
        private String lastName;

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public SearchSpec build() {
            return new SearchSpec(this);
        }
    }
}
