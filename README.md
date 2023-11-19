# 

### ディレクトリ構成
- ルート`com.mysql`
- `com.mysql.controller`: アプリケーションのコントローラークラスを配置します。これらのクラスはユーザーのリクエストを受け取り、適切なサービスクラスを呼び出し、レスポンスを生成します。
- `com.mysql.service`: ビジネスロジックを実装するサービスクラスを配置します。これらのクラスはコントローラーから呼び出され、必要な処理を行います。
- `com.mysql.dao`: データベースへのアクセスを行うDAO（Data Access Object）クラスを配置します。これらのクラスはサービスクラスから呼び出され、データベースの操作を行います。
- `com.mysql.model`: データモデルクラスを配置します。これらのクラスはデータベースのテーブルを表現します。
- `com.mysql.util`: ユーティリティクラスを配置します。これらのクラスは共通のヘルパー関数や定数を提供します。
- `com.mysql.logging`: ログ出力に関連するクラスを配置します。


### 開発方針
メソッド作成する度にテストで確認

### ビルドコマンド
```
# target,work/unzipディレクトリをきれいにする
mvn clean

# ビルド時にworkディレクトリにコピーを配置>>解凍して中身の確認等を行う
mvn package
```

### 実行コマンド
```
java -jar /workspaces/java-mysql/demo/target/demo-1.0-SNAPSHOT.jar
```

### 解凍
```
# 参考
unzip /workspaces/java-mysql/demo/work/demo-1.0-SNAPSHOT.jar -d /workspaces/java-mysql/demo/work/unpacked

ls /workspaces/java-mysql/demo/work/unpacked/WEB-INF/lib/
```

### jarファイルが増えすぎないよう
```
# 5つ以上のjarファイルが配置されている場合、古いverから削除していく
chmod +x /workspaces/java-mysql/demo/src/main/resources/scripts/clean_old_jars.sh
```