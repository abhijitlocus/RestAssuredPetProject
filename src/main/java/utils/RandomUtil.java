package utils;

import java.util.List;
import java.util.Random;

public class RandomUtil {

    public static <T> T getRandomElement(List<T> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
