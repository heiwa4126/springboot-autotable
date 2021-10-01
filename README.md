# springboot-autotable

JPA Hibernate��SQL�̃e�[�u���������ō������A�����f�[�^��ǉ������肷��B


# �Q�l

- [�gHow-to�h Guides - howto.data-initialization](https://docs.spring.io/spring-boot/docs/2.5.5/reference/html/howto.html#howto.data-initialization)
- [Spring Boot �u�g�����v�K�C�h - 9. �f�[�^�x�[�X�̏�����](https://spring.pleiades.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization) - ������ƌÂ������B�ł����{��


# �Œ���̐ݒ� (tag : v0.0.0)

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

�� resources�̉�(�Ƃ�����CLASSPATH:�̂ǂ���)��`data.sql`��u���B

����Ń��f���ɏ]�����e�[�u�����ł��A������data.sql������B�����߂�ǂ������B

�m�F�� H2 console �� ON�Ȃ� http://localhost:8080/h2-console/ �� `SELECT * FROM WORD;`


# �i���� (tag : v0.0.1)

H2������������t�@�C���ɂ��Ă݂�B

application.properties

```
# spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.url=jdbc:h2:C:\\H2\\autotable
```

(Windows�ł���Ă܂��B���`md C:\H2`���Ƃ����ƁB����YAML���ƃo�b�N�X���b�V����1���Ǝv��)

�e�[�u���͂ł��邯�ǃf�[�^������Ȃ��B�Ȃ����B�ȉ���ǉ����Ă݂�B

```
spring.sql.init.mode=always
```

�������͂���邯�ǁASpring Boot���ċN������ƃG���[�ɂȂ�(������܂�)�B����������Spring Batch���g���Ƃ������Ƃ��B
�Ƃ肠����SQL��UPSERT�I�ɑΏ����Ă݂�BH2���� `INSERT INTO` �� [MERGE INTO](http://www.h2database.com/html/commands.html#merge_into) �ŁB
���ꂾ�ƒl���㏑���ɂȂ� & H2�ȊO�ł͂��߂Ƃ������_�͂��邯�ǁA�Ƃ肠��������B

�T�[�r�X�ƃ��|�W�g����ǉ����āAcurl��`select *`���o�Ă���悤�ɂ���B

...�e�[�}�Ɗ֌W�Ȃ��R�[�h������������
`curl localhost:8080/list -s`
�ňꗗ��JSON�ŋA��悤�ɂȂ����B


# �O��DB (tag : v0.0.2)

** PostgreSQL�̐ݒ�͏ȗ� ***

PostgreSQL�ɂ��Ă݂�B`MERGE INTO`�͂Ȃ��B
`INSERT INTO ... ON CONFLICT ON CONSTRAINT (column_name) DO NOTHONG;`�ɂ���B�A
�����ID���������炱��Ȃ��́B

���Ƃ� `spring.datasource.*`�����������ďI���B


# �v���t�@�C���Ő؂�ւ�����悤�ɂ��� (tag : v0.0.3)

* dev - �Œ���̐ݒ�(H2:mem)
* h2file - H2:File
* pg - PostgreSQL

�݂����ɂ���B
