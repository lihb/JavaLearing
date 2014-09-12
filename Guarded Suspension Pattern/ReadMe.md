## Guarded Suspension pattern介绍

guarded是“被保护着的”、“被防卫着的”的意思，suspension是“暂停”的意思。当现在并不适合马上执行某个操作时，就要求想要执行该操作的线程等待，这就是 Guarded Suspension Pattern。该模式会要求线程等候，以保障实例的安全性。

![时序图](https://raw.githubusercontent.com/lihb/lihb.github.com/master/images/chengfa.jpg)


