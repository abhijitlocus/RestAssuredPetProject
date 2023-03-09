package models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;

import static utils.RandomUtil.getRandomElement;

public class User {

    String id;
    String name;
    String email;
    GenderEnum gender;
    StatusEnum status;

    public User() {
        this.name = RandomStringUtils.randomAlphabetic(10);
        this.email = String.format("%s@%s.%s", RandomStringUtils.randomAlphabetic(10)
                , RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomAlphabetic(3));
        this.gender = getRandomElement(Arrays.asList(GenderEnum.male, GenderEnum.female));
        this.status = getRandomElement(Arrays.asList(StatusEnum.active, StatusEnum.inactive));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public GenderEnum getGender() {
        return this.gender;
    }

    public StatusEnum getStatus() {
        return this.status;
    }
}
