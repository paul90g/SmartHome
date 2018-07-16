package com.paul90g.data;

import com.paul90g.exceptions.InvalidDataException;
import lombok.NonNull;

@SuppressWarnings({"unused", "WeakerAccess"})
public class User {

    private static final String REGEX_USERNAME = "[a-zA-Z][a-zA-Z0-9]{1,20}";
    private static final String REGEX_EMAIL = "[a-zA-Z][a-zA-Z0-9]{2,20}@[a-zA-Z0-9.]{2,20}\\.[a-z]{2,3}";

    @NonNull
    private String username;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String password;
    @NonNull
    private String email;

    private User() {
    }

    /**
     * Build a new User instance with all the fields set.
     * <br>
     * If the data provided is not valid, an {@link InvalidDataException} will be thrown!
     *
     * @param username  username specific to the represented user
     * @param firstName User's first name
     * @param lastName  User's last name
     * @param password  User's password, not encoded
     * @param email     User's email
     */
    public User(String username, String firstName, String lastName,
                String password, String email) {
        this.username = username.toLowerCase();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email.toLowerCase();
        if (!isValid()) throw new InvalidDataException("Invalid data!");
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    private boolean isValid() {
        if (username.isEmpty() || !username.matches(REGEX_USERNAME)) return false;
        if (firstName.isEmpty()) return false;
        if (lastName.isEmpty()) return false;
        if (password.isEmpty()) return false;
        return !email.isEmpty() && email.matches(REGEX_EMAIL);
    }

}
