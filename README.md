# springboot-autotable

JPA HibernateでSQLのテーブルを自動で作ったり、初期データを追加したりする。


# 参考

- [“How-to” Guides - howto.data-initialization](https://docs.spring.io/spring-boot/docs/2.5.5/reference/html/howto.html#howto.data-initialization)
- [Spring Boot 「使い方」ガイド - 9. データベースの初期化](https://spring.pleiades.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization) - ちょっと古いかも。でも日本語


# 最低限の設定 (tag : v0.0.0)

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

で resourcesの下(というかCLASSPATH:のどこか)に`data.sql`を置く。

これでモデルに従ったテーブルができ、そこにdata.sqlが入る。ああめんどくさい。

確認は H2 console が ONなら http://localhost:8080/h2-console/ で `SELECT * FROM WORD;`


# 永続化 (tag : v0.0.1)

H2をメモリからファイルにしてみる。

application.properties

```
# spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.url=jdbc:h2:C:\\H2\\autotable
```

(Windowsでやってます。先に`md C:\H2`しとくこと。あとYAMLだとバックスラッシュは1つだと思う)

テーブルはできるけどデータが入らない。なぜだ。以下を追加してみる。

```
spring.sql.init.mode=always
```

初期化はされるけど、Spring Bootを再起動するとエラーになる(あたりまえ)。ここから先はSpring Batchを使えということか。
とりあえずSQLのUPSERT的に対処してみる。H2だと `INSERT INTO` を [MERGE INTO](http://www.h2database.com/html/commands.html#merge_into) で。
これだと値が上書きになる & H2以外ではだめという欠点はあるけど、とりあえず回避。

サービスとレポジトリを追加して、curlで`select *`が出てくるようにする。

...テーマと関係ないコードが増えたけど
`curl localhost:8080/list -s`
で一覧がJSONで帰るようになった。


# 外部DB (tag : v0.0.2)

** PostgreSQLの設定は省略 ***

PostgreSQLにしてみる。`MERGE INTO`はない。
`INSERT INTO ... ON CONFLICT ON CONSTRAINT (column_name) DO NOTHONG;`にする。、
今回はIDだけだからこんなもの。

あとは `spring.datasource.*`を書き換えて終わり。


# プロファイルで切り替えられるようにする (tag : v0.0.3)

* dev - 最低限の設定(H2:mem)
* h2file - H2:File
* pg - PostgreSQL

みたいにする。
