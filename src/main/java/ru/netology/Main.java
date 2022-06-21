package ru.netology;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("pageOfBook"); // Обязательно надо писать .txt

        List<String> list = Files.readAllLines(path);
        //Программа написана в функциональном стиле - интерфейс Function
        Function<String, List<String>> function = (a) ->
                Arrays.stream(a.split("\\s+|,\\s*|\\.\\s*|!\\s*|–\\s*|:\\s*|…\\s*| \\s*"))
                        .filter(x -> x.length() > 2)
                        .sorted()
                        .distinct()
                        .toList();
        function.apply(String.valueOf(list)).forEach(System.out::println);
    }
}