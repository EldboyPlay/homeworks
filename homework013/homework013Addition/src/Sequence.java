import utils.ByCondition;

import java.util.Arrays;

public class Sequence {
    public static int[] filter(int[] array, ByCondition<Integer> condition) {
        return Arrays.stream(array)
                .filter(n -> condition.test(n))
                .toArray();
    }
}
