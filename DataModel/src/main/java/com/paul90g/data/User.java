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

    public User(String username, String firstName, String lastName,
                String password, String email) {
        if (username.isEmpty() || !username.matches(REGEX_USERNAME))
            throw new InvalidDataException("Invalid username format!");
        this.username = username.toLowerCase();
        if (firstName.isEmpty()) throw new InvalidDataException("Invalid first name!");
        this.firstName = firstName;
        if (lastName.isEmpty()) throw new InvalidDataException("Invalid last name!");
        this.lastName = lastName;
        if (password.isEmpty()) throw new InvalidDataException("Invalid password!");
        this.password = password;
        if (email.isEmpty() || !email.matches(REGEX_EMAIL)) throw new InvalidDataException("Invalid email format!");
        this.email = email.toLowerCase();
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

}
