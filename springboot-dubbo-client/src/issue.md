## SpringBoot Dubbo
springboot-dubbo-server is ok, but the client raised the exception. It told me no provider for the service.
```
java.lang.IllegalStateException: Failed to check the status of the service com.springboot.yzhao.springbootdubboclient.dubbo.CityDubboService. No provider available for the service com.springboot.yzhao.springbootdubboclient.dubbo.CityDubboService:1.0.0 from the url zookeeper://10.66.8.126:2181/com.alibaba.dubbo.registry.RegistryService?application=consumer&dubbo=2.5.3&interface=com.springboot.yzhao.springbootdubboclient.dubbo.CityDubboService&methods=findCityByName&pid=26349&revision=1.0.0&side=consumer&timestamp=1531798289690&version=1.0.0 to the consumer 10.66.8.126 use dubbo version 2.5.3
	at com.alibaba.dubbo.config.ReferenceConfig.createProxy(ReferenceConfig.java:420) ~[dubbo-2.5.3.jar:2.5.3]
	at com.alibaba.dubbo.config.ReferenceConfig.init(ReferenceConfig.java:300) ~[dubbo-2.5.3.jar:2.5.3]
	at com.alibaba.dubbo.config.ReferenceConfig.get(ReferenceConfig.java:138) ~[dubbo-2.5.3.jar:2.5.3]
	at com.alibaba.dubbo.config.spring.AnnotationBean.refer(AnnotationBean.java:302) ~[dubbo-2.5.3.jar:2.5.3]
	at com.alibaba.dubbo.config.spring.AnnotationBean.postProcessBeforeInitialization(AnnotationBean.java:233) ~[dubbo-2.5.3.jar:2.5.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:409) [spring-beans-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1626) [spring-beans-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:555) [spring-beans-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483) [spring-beans-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:312) [spring-beans-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) [spring-beans-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:308) [spring-beans-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) [spring-beans-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:761) [spring-beans-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:867) [spring-context-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:543) [spring-context-4.3.18.RELEASE.jar:4.3.18.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:122) [spring-boot-1.5.14.RELEASE.jar:1.5.14.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:693) [spring-boot-1.5.14.RELEASE.jar:1.5.14.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:360) [spring-boot-1.5.14.RELEASE.jar:1.5.14.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:303) [spring-boot-1.5.14.RELEASE.jar:1.5.14.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1118) [spring-boot-1.5.14.RELEASE.jar:1.5.14.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1107) [spring-boot-1.5.14.RELEASE.jar:1.5.14.RELEASE]
	at com.springboot.yzhao.springbootdubboclient.SpringbootDubboClientApplication.main(SpringbootDubboClientApplication.java:13) [classes/:na]
```

After , it raise the  NPE exception:
```
Exception in thread "main" java.lang.NullPointerException
	at com.springboot.yzhao.springbootdubboclient.dubbo.CityDubboConsumerService.printCity(CityDubboConsumerService.java:15)
	at com.springboot.yzhao.springbootdubboclient.SpringbootDubboClientApplication.main(SpringbootDubboClientApplication.java:17)
```
