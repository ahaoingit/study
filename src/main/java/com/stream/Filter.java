package com.stream;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author ahao 2020-08-27
 */
public class Filter {
    static Path path = Paths.get("D:\\studyworkspace\\test.txt");
    ArrayList<Integer> num = new ArrayList<>();

    {
        for (int i = 0; i < 100; i++) {
            num.add(new Random().nextInt(1000));
        }
    }
    /***.
     *@param :
     *@author ahao
     *@date 2020-08-27 16:11
     *@return
     *创建流
     * Stream.of 数组创建流
     * Array.stream(array,from,to) [from,to) 集合流
     * Stream.empty 空流
     * Stream.generate() 无限流
     *
     */
    public static <T> void creatStream(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> streamList =  stream.limit(SIZE+1)
                .collect(Collectors.toList());
        System.out.println(title+":");

    }


    public static void main(String[] args) throws IOException {
        Filter filter = new Filter();
        long collect = filter.num.stream()
                .filter(num -> {
                    System.out.println(num);
                    return true;
                })
                .count();
        long count = filter.num.parallelStream()
                .filter(num -> num > 5)
                .count();
        String s = new String(Files.readAllBytes(path));
        String[] split = s.split("\\PL+");
        for (String s1 : split) {
            System.out.println(s1);
        }
    }
}
