import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String[] array = {"a1", "a2", "a3", "a1", "a4", "a5", "a1"};

        //1) Дана коллекция строк {"a1, "a2", "a3", "a1", "a4", "a5, "a1"}, вернуть количество вхождений объекта «a1» с помощью streamAPI;
        System.out.println(Arrays.stream(array).filter("a1"::equals).count());

        //2) Найти элемент в коллекции равный «a3» или вывести ошибку;
        try {
            System.out.println(Arrays.stream(array).filter("a3"::equals).findFirst().orElseThrow((() -> new Exception("Array is empty"))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //3) Вернуть последний элемент коллекции или «empty», если коллекция пуста;
        System.out.println(Arrays.stream(array).skip(Arrays.stream(array).count() - 1).findFirst().orElse("empty"));

        //4) Вернуть два элемента начиная со второго элемента коллекции;
        System.out.println(Arrays.stream(array).skip(1).limit(2).collect(Collectors.toList()));

        //5) Из коллекции имен убрать все повторения и найти среднюю длину имен;
        System.out.println(Arrays.stream(array).distinct().mapToInt(String::length).average().orElse(0));

        //6) Отсортировать коллекцию строк по убыванию и убрать дубликаты;
        System.out.println(Arrays.stream(array).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        //7) Вернуть сумму нечетных чисел или 0;
        System.out.println(Stream.of(1,2,3,4,5).filter(num -> num % 2 != 0).reduce(Integer::sum).orElse(0));


    }
}