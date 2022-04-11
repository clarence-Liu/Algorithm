package Z_Entry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Print {

    public static <T> String print(List<T> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (T t : list) {
            builder.append(t.toString()).append("],");
        }
        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }

    public static <T> String print(T[] array){
        return print(Arrays.asList(array));
    }

    public static String print(int[] array) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int num : array) {
            builder.append(num).append(",");
        }
        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }

    public static String print(int[][] arrays) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int[] array : arrays) {
            builder.append(print(array)).append(",");
        }
        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }
}
