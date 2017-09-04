# BENCHMARK并发测试
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/babymm/mumu-benchmark/blob/master/LICENSE) [![Maven Central](https://img.shields.io/maven-central/v/com.weibo/motan.svg?label=Maven%20Central)](https://github.com/babymm/mumu-benchmark) [![Build Status](https://img.shields.io/travis/weibocom/motan/master.svg?label=Build)](https://github.com/babymm/mumu-benchmark) [![OpenTracing-1.0 Badge](https://img.shields.io/badge/OpenTracing--1.0-enabled-blue.svg)](http://opentracing.io)

benchmark是一个模拟webbench的java客户端并发测试程序。benchmark包含两个重要的参数，并发数、程序运行时间。
-  并发数：运行多少个并发，每一个并发数代表着一个客户端。
-  运行时间：每一个客户端运行时间，运行时间中还包含程序预热时间，默认预热时间设置的为30秒，不统计预热时间的并发数。到程序运行完成之后，统计tps、requests等相关信息。

## benchmark原理分析
程序运行的时候，需要传递并发数和运行时间等参数。每一个并发数开启一个客户端程序，然后在运行时间内一直调用测试方法，知道运行时间结束为止。在运行时间内，前三十秒为程序的预热时间，程序不会统计该时间段的调用信息，在预热时间过后，程序在每一次调用完测试程序后收集测试结果。当所有的客户端都运行结束之后，开始收集统计信息，包括成功请求数、错误请求数、平均TPS、MaxTPS、MinTPS等信息。


## benchmark统计信息
![zookeeper节点创建并发测试](http://note.youdao.com/yws/api/personal/file/0D176DD8331A449B802A7C969282565F?method=download&shareKey=562957c964ff3c6a9289e615f2b1d1b7)


 > 以上观点纯属个人看法，如有不同，欢迎指正。  
 > 联系方式：  
 > email:<babymm@aliyun.com>   
 > github:[https://github.com/babymm](https://github.com/babymm)  


