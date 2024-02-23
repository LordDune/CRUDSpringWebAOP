24.02.2024
Приложение дополнено Unit и интеграционным тестами


CRUD приложение дополнено функциональностью AOP:

1) Добавлены следующие зависимости

```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.8</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>6.1.3</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
    <version>3.2.2</version>
</dependency>
```

2) Создана Аннотация TrackUserAction, которая добавлена в методы класса UserService (findAll, saveUser, deleteById, update)

```
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TrackUserAction {
}
```
3) Создан конфигурационный файл
```
@EnableAspectJAutoProxy
@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "com.example.demo")
public class Configuration {
@Bean
    public LoggingAspects aspects() {
        return new LoggingAspects();
    }
}
```
4) Создан класс LoggingAspect и метод log, который выводит в консоль информацию об используемых методах при работе с приложением
```
@Aspect
public class LoggingAspects {

    @Around(value = "@annotation(TrackUserAction)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnByMethod = joinPoint.proceed();
        System.out.println("Пользователь совершил действие с базой данных: "
                + joinPoint.getSignature().getName()
                + Arrays.asList(joinPoint.getArgs()).get(0).toString());
        return returnByMethod;
    }
}
```
```
Пользователь совершил действие с базой данных: saveUserUser(id=0, firstName=Max, lastName=Popov)
Пользователь совершил действие с базой данных: updateUser(id=1, firstName=Max, lastName=Zemov)
Пользователь совершил действие с базой данных: deleteById1
```