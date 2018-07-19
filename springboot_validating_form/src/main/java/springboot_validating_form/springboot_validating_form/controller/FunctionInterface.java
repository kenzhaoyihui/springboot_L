package springboot_validating_form.springboot_validating_form.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterface {
    public static void donation(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    public static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
        List<Integer> resultList = new ArrayList<>();
        for (int x=0; x<num; x++ ) {
            resultList.add(supplier.get());
        }
        return resultList;
    }

    public static Integer convert(String s, Function<String, Integer> function) {
        return function.apply(s);
    }

    public static  List<String> filter(List<String> fruit, Predicate<String> predicate) {
        List<String> f = new ArrayList<>();
        for (String s: fruit) {
            if (predicate.test(s)) {
                f.add(s);
            }
        }
        return f;
    }

    public static void main(String[] args) {
        donation(1000, xx -> System.out.println("==" + xx));

        List<Integer> list = supply(10, () -> (int)(Math.random()*100));
        list.forEach(System.out::println);

        Integer value = convert("28", x -> Integer.parseInt(x));
        System.out.println("value=" + value);

        List<String> fruits = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> newfruit = filter(fruits, f -> f.length()==2);
        newfruit.forEach(System.out::println);
    }
}
