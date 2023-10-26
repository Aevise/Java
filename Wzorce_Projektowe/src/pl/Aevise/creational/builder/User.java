package pl.Aevise.creational.builder;

public class User {

    private final String firstName;
    private final String lastName;
    private final String email;

    public User(final UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder{
        private String firstName;
        private String lastName;
        private String email;

        public UserBuilder firstName(final String firstName){
            this.firstName = firstName;
            return this;
        }
        public UserBuilder lastName(final String lastName){
            this.lastName = lastName;
            return this;
        }
        public UserBuilder email(final String email){
            this.email = email;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
