# autotable

JPA Hibernate��SQL�̃e�[�u���������ō������A�����f�[�^��ǉ������肷��B


# �Q�l

- [�gHow-to�h Guides - howto.data-initialization](https://docs.spring.io/spring-boot/docs/2.5.5/reference/html/howto.html#howto.data-initialization)
- [Spring Boot �u�g�����v�K�C�h - 9. �f�[�^�x�[�X�̏�����](https://spring.pleiades.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization) - ������ƌÂ������B�ł����{��


# �Œ���̐ݒ�

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

�� resources�̉�(�Ƃ�����CLASSPATH�F�̂ǂ���)��`data.sql`��u���B

����Ń��f���ɏ]�����e�[�u�����ł��A������data.sql������B�����߂�ǂ������B