# Javaの文法
<hr>

## パッケージ宣言
<hr>
Javaのプログラムはpackage宣言から始まる。

`原則としてクラスは何らかのパッケージに含めるようにする`

* パッケージ名は全て小文字
* サブパッケージ（パッケージ内のパッケージ）がある場合は「.」で区切る。

```java
    package projava;
```
* Intellij IDEA ではクラスの作成や移動時にpackageが自動的に設定される。

<br>
<br>

## import文
<hr>

```java
    import javax.swing.*;
```

<br>
<br>

## クラス宣言
<hr>

Javaのプログラムはclassかそれに相当するもので囲まれる。

```java
    public class SampleForm {
    
}
```

* クラス名は大文字で書き始めて小文字で書き、単語の区切りは大文字にする。
* Javaのプログラムでコードのまとまりは `{}` で囲む

```java
    public class SampleForm {
        public static void main (String[] args) {
            
        }    
    }   
```

<br>
<br>

## メインメソッド
<hr>

Javaのプログラムは __mainメソッド__ から始まる。

```java
    public static void main(String[] args){
    
    }
```