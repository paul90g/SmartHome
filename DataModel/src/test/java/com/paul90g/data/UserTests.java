package com.paul90g.data;

import com.paul90g.exceptions.InvalidDataException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class UserTests {

    private static final String USERNAME = "paul90g";
    private static final String BAD_USERNAME = "1paul90g";
    private static final String FIRST_NAME = "Paul";
    private static final String LAST_NAME = "Marian";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "paul90g@gmail.com";
    private static final String BAD_EMAIL = "9paul90g@gmail.com";

    @BeforeAll
    static void init() {
        log.info("\n\n*****************************\n"
                + "Testing \"User\" data model\n"
                + "*****************************\n");
    }

    @AfterAll
    static void deInit() {
        log.info("\n\n*****************************\n"
                + "Tests for \"User\" are complete\n"
                + "*****************************\n");
    }

    @Test
    void testUserOk() {
        log.info("Test valid user creation");
        User user = new User(USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, EMAIL);
        assertNotNull(user);
        log.info("Test OK");
    }

    @Test
    void testUserBadEmail() {
        log.info("Testing user creation with invalid email");
        Executable exec = () -> new User(USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, BAD_EMAIL);
        assertThrows(InvalidDataException.class, exec);
        log.info("Test OK");
    }

    @Test
    void testUserBadUsername() {
        log.info("Testing user creation with invalid username");
        Executable exec = () -> new User(BAD_USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, EMAIL);
        assertThrows(InvalidDataException.class, exec);
        log.info("Test OK");
    }

}
