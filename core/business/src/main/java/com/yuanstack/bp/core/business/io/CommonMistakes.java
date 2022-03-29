package com.yuanstack.bp.core.business.io;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

/**
 * @description: 文件操作常见错误
 * @author: hansiyuan
 * @date: 2021/10/18 8:42 下午
 */
@Slf4j
public class CommonMistakes {
    public static void main(String[] args) throws IOException {
//        init();
//        readLargeFileRight();
//        readLargeFileWrong();
        linesTest();
//        wrong();
//        right();
//        generateData();
    }

    public static void generateData() throws IOException {
        Files.write(Paths.get("files/large.txt"),
                IntStream.rangeClosed(1, 100000).mapToObj(i -> UUID.randomUUID().toString()).collect(Collectors.toList())
                , UTF_8, CREATE, TRUNCATE_EXISTING);
    }

    public static void init() throws IOException {

        String s = IntStream.rangeClosed(1, 1000)
                .mapToObj(a -> "a")
                .collect(Collectors.joining("")) + UUID.randomUUID();
//        Files.deleteIfExists(Paths.get("large.txt"));
//        IntStream.rangeClosed(1, 10).forEach(__ -> {
//            try {
//                Files.write(Paths.get("large.txt"),
//                        IntStream.rangeClosed(1, 500000).mapToObj(i -> payload).collect(Collectors.toList())
//                        , UTF_8, CREATE, APPEND);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
        Files.write(Paths.get("files/demo.txt"),
                IntStream.rangeClosed(1, 10).mapToObj(i -> UUID.randomUUID().toString()).collect(Collectors.toList())
                , UTF_8, CREATE, TRUNCATE_EXISTING);
    }

    private static void readLargeFileRight() throws IOException {
        AtomicLong atomicLong = new AtomicLong();
        Files.lines(Paths.get("files/large.txt")).forEach(line -> atomicLong.incrementAndGet());
        log.info("lines {}", atomicLong.get());
    }

    private static void linesTest() throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("read 200000 lines");
        log.info("lines {}", Files.lines(Paths.get("files/large.txt")).limit(200000).collect(Collectors.toList()).size());
        stopWatch.stop();
        stopWatch.start("read 2000000 lines");
        log.info("lines {}", Files.lines(Paths.get("files/large.txt")).limit(2000000).collect(Collectors.toList()).size());
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
    }

    public static void readLargeFileWrong() throws IOException {
        log.info("lines {}", Files.readAllLines(Paths.get("files/large.txt")).size());
    }

    private static void wrong() {
        //ps aux | grep CommonMistakesApplication
        //lsof -p 63937
        LongAdder longAdder = new LongAdder();
        IntStream.rangeClosed(1, 1000000).forEach(i -> {
            try {
                Files.lines(Paths.get("files/demo.txt")).forEach(line -> longAdder.increment());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        log.info("total : {}", longAdder.longValue());
    }

    private static void right() {
        //https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
        LongAdder longAdder = new LongAdder();
        IntStream.rangeClosed(1, 1000000).forEach(i -> {
            try (Stream<String> lines = Files.lines(Paths.get("files/demo.txt"))) {
                lines.forEach(line -> longAdder.increment());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        log.info("total : {}", longAdder.longValue());
    }

}
