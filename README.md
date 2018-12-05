# blog-springboot
GKEに置くDockerコンテナに乗る、Springbootのプロジェクトです。

## ソフトウェア構成
- Java/Springboot
- MySQL 5.7
- JPA/Hibernate

## はまったところ
GKEの設定が完了した後に、Google Cloud SQLを繋ぐ時にはまりました。

以下、依存関係のあるライブラリの追加と更新を行いました。

     mysql:mysql-connector-java:8.0.11
     com.google.cloud.sql:mysql-socket-factory-connector-j-8:1.0.11
     com.google.cloud.sql:jdbc-socket-factory-core:1.0.11

build.gradleを参照したください。

mysql-socket-factory-connector-j-8の他にも、
j-5, j-6とMySQLに対応するようにバージョンがありますが、
後方互換があるようで、j-8を使っていて問題なさそうです。

com.google.cloud.sql:jdbc-socket-factory-core:1.0.11は追加しないと
以下のようなエラーが発生します。
     
     NoClassDefFoundError: com/mysql/cj/protocolSocketFactory

## 次の課題
- HTMLをもうちょっと見れる形にしたい
- 投稿する部分をどうするかは要検討