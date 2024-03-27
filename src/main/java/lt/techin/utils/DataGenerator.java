package lt.techin.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {
    public static String addSixLetters() {
        return RandomStringUtils.randomAlphanumeric(6);
    }
}
