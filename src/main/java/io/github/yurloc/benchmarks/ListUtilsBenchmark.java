package io.github.yurloc.benchmarks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class ListUtilsBenchmark {

    private final Random random = new Random(0);
    @Param("100")
    private int listSize;
    private List<Integer> input;

    @Setup(Level.Trial)
    public void generateInputList() {
        input = Stream.generate(random::nextInt)
                .limit(listSize)
                .collect(Collectors.toList());
    }

    @Benchmark
    public List<Integer> copyAndReverse() {
        return ListUtils.copyAndReverse(input);
    }

    @Benchmark
    public List<Integer> collectionsReverse() {
        List<Integer> output = new ArrayList<>(input);
        Collections.reverse(output);
        return output;
    }
}
