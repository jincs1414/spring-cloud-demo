service-discovery 服务注册中心

service-client 服务1 service-client在service-discovery里面注册自身，以提供给其他服务调用

 [springcloud(三)：服务提供与调用](https://www.cnblogs.com/ityouknow/p/6859802.html)

service-consumer 服务的消费方，使用service-client中提供的服务

zipkin 收集调用服务日志

[SpringCloud2.0 zipkin简单demo](https://blog.csdn.net/z28126308/article/details/84674254)

[Spring Cloud Sleuth + Zipkin（一）链路监控](https://blog.csdn.net/hubo_88/article/details/80878632)

Spring Cloud Hystrix 断路器

[Feign断路器支持（Hystrix）](https://blog.csdn.net/yelllowcong/article/details/79580099)

断路器是放在服务的消费方上，防止服务提供者出现异常，导致消费方自身出现问题或者整个系统出现雪崩

关键点：服务A出现异常，导致调用方服务B出现异常，防止服务B自身出现问题或者整个系统出现雪崩

srping cloud 实现负载均衡 避免单点故障

[Ribbon客户端负载均衡](https://www.cnblogs.com/huangjuncong/p/9022055.html)


分布式事务 服务B去调用服务A的提供的服务，服务B调用完成后，由于某种原因，服务B出现异常，服务A的数据库操作能够进行回滚，避免出现服务A数据异常 
关键点：服务A正常提供服务，调用方服务B出现异常，防止正常提供服务的一方出现数据错误

[LCN框架](https://txlcn.org/zh-cn/)


api网关 gateway

[轻松搞定SpringCloud微服务-API网关zuul](https://www.cnblogs.com/hyhnet/p/8097635.html)


[springcloud之config组件在本地配置中心的使用](https://blog.csdn.net/qq_31489805/article/details/80448886)


消息总线 [Spring boot 2.0 消息总线(Spring Cloud Bus) 高可用分布式配置中心 实例](https://www.jianshu.com/p/70b0e95b0ec3)