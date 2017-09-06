# BENCHMARK并发测试
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/babymm/mumu-benchmark/blob/master/LICENSE) [![Maven Central](https://img.shields.io/maven-central/v/com.weibo/motan.svg?label=Maven%20Central)](https://github.com/babymm/mumu-benchmark) [![Build Status](https://travis-ci.org/babymm/mumu-rocketmq.svg?branch=master)](https://travis-ci.org/babymm/mumu-benchmark) [![OpenTracing-1.0 Badge](https://img.shields.io/badge/OpenTracing--1.0-enabled-blue.svg)](http://opentracing.io)

benchmark是一个模拟webbench的java客户端并发测试程序。benchmark包含两个重要的参数，并发数、程序运行时间。
-  并发数：运行多少个并发，每一个并发数代表着一个客户端。
-  运行时间：每一个客户端运行时间，运行时间中还包含程序预热时间，默认预热时间设置的为30秒，不统计预热时间的并发数。到程序运行完成之后，统计tps、requests等相关信息。

## benchmark原理分析
程序运行的时候，需要传递并发数和运行时间等参数。每一个并发数开启一个客户端程序，然后在运行时间内一直调用测试方法，知道运行时间结束为止。在运行时间内，前三十秒为程序的预热时间，程序不会统计该时间段的调用信息，在预热时间过后，程序在每一次调用完测试程序后收集测试结果。当所有的客户端都运行结束之后，开始收集统计信息，包括成功请求数、错误请求数、平均TPS、MaxTPS、MinTPS等信息。


## benchmark统计信息
![zookeeper节点创建并发测试](http://note.youdao.com/yws/api/personal/file/0D176DD8331A449B802A7C969282565F?method=download&shareKey=562957c964ff3c6a9289e615f2b1d1b7)

## jmh测试
> jmh 是一个microbenchmark的测试工具，可以通过jmh来测试程序。

```
Mode.Throughput	计算一个时间单位内操作数量
Mode.AverageTime	计算平均运行时间
Mode.SampleTime	计算一个方法的运行时间(包括百分位)
Mode.SingleShotTime	方法仅运行一次(用于冷测试模式)。或者特定批量大小的迭代多次运行(具体查看后面的“`@Measurement“`注解)——这种情况下JMH将计算批处理运行时间(一次批处理所有调用的总时间)
这些模式的任意组合	可以指定这些模式的任意组合——该测试运行多次(取决于请求模式的数量)
Mode.All	所有模式依次运行

    /**
     * 主要是测试是吞吐量
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void display(){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        
        
```
最近一直在找一种测试工具，以至于自己编写了一套benchmark测试工具，但是看到了jmh，感觉自己写的测试工具完全可以不用用了，jmh太强大了。  
[jmh使用指南](http://ju.outofmemory.cn/entry/87054)

 > 以上观点纯属个人看法，如有不同，欢迎指正。  
 > 联系方式：  
 > email:<babymm@aliyun.com>   
 > github:[https://github.com/babymm](https://github.com/babymm)  


