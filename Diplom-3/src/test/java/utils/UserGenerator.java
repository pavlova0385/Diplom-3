package utils;

import model.User;
import java.util.UUID;

public class UserGenerator {

    public static User getRandomUser() {
        String uniqueId = UUID.randomUUID().toString().substring(0, 8);
        String email = "test_" + uniqueId + "@yandex.ru";
        String password = "password123";
        String name = "User_" + uniqueId;

        return new User(email, password, name);
    }
}
