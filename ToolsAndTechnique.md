# ビルドツールとMaven
## ビルドツールの必要性
* Javaの __ビルド__ ... 画像や設定ファイルなどのリソースをまとめたり、アプリケーションで利用するライブラリの場所をコンパイル時・実行時に-classpathというオプションで指定して使えるようにしたり、最終成果物としてコンパイル済みの.classファイルやリソースをひとまとめにした __JAR__ (Java ARchive)ファイルを作成したりといった、やや複雑な作業が必要になる。

## Mavenの基本
* Maven ... Javaアプリケーション開発の現場では最も利用されているビルドツール。JavaIDEには基本的にMavenが内蔵されている。

## Mavenのモジュールとディレクトリ構成
* モジュール ... プロジェクトの構成単位1つのモジュールは、成果物として1つのJARファイルやWAR(Webアーカイブ)ファイルなどを生成する。

Mavenのモジュールはpom.xmlというXMLファイルで定義する。

必要最小限のpom.xml
```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>jp.gihyo.projava</groupId>
    <artifactId>mvn-minimal</artifactId>
    <version>1.0</version>
</project>
```

## groupId と artifactId
* __groupId__ ... Javaのパッケージ名と同じで、名前の衝突を避けるために組織のドメイン名を逆順(gihyo.jpであればjp.gihyo)にしたものに、必要に応じてプロジェクトなどを識別できるものを加えた、英小文字とドットによる識別子を指定する。
* __artifactId__ ... そのモジュール用の固有でわかりやすい名前を、英小文字とハイフンで指定する。