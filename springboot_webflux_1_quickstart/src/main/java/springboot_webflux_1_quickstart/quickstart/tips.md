Don't use the web and webflux together.

```
		<!--<dependency>-->
			<!--<groupId>org.springframework.boot</groupId>-->
			<!--<artifactId>spring-boot-starter-web</artifactId>-->
		<!--</dependency>-->
```

Webflux is ok!
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>

```