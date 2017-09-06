package com.lovecws.mumu.benchmark.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JMHHelloWorldDemo {

    @Benchmark
    public void wellHelloThere() {
        //System.out.println("jhm");
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Options opt = new OptionsBuilder()
                .include(JMHHelloWorldDemo.class.getSimpleName())
                .forks(1) //运行次数
                .build();
        try {
            new Runner(opt).run();
            System.out.println(System.currentTimeMillis());
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
}
