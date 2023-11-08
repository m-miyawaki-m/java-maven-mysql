# 

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