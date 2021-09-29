# autotable

JPA HibernateでSQLのテーブルを自動で作ったり、初期データを追加したりする。


# 参考

- [“How-to” Guides - howto.data-initialization](https://docs.spring.io/spring-boot/docs/2.5.5/reference/html/howto.html#howto.data-initialization)
- [Spring Boot 「使い方」ガイド - 9. データベースの初期化](https://spring.pleiades.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization) - ちょっと古いかも。でも日本語


# 最低限の設定

application.properties

```
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
spring.sql.init.encoding=UTF-8
```

で resourcesの下(というかCLASSPATH：のどこか)に`data.sql`を置く。

これでモデルに従ったテーブルができ、そこにdata.sqlが入る。ああめんどくさい。