package com.lovecws.mumu.benchmark.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class BenchmarkModeDemo {

    /**
     * 主要是测试是吞吐量
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void display(){

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkModeDemo.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(10)
                .forks(1)
                //.shouldDoGC(true)
                .threads(1)
                .build();

        new Runner(opt).run();
    }
}
