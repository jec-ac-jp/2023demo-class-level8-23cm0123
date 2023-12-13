# 【第8回】フレームワークを使ったプログラミング
## テーマ
1.  Daoクラスについて

## 開発環境について
* この演習では、Codespacesと呼ばれるサービスを使って開発を行います。
* ブラウザ上で動作する開発環境です、インストール不要で使う事ができます。

## Codespacesで実行してみよう
* 第一回で実施した[手順](/Codespacesの実行手順.md)を参照してください。

## Daoクラスについて学習
1. `Let's try!`を押します。<br>
![image](https://user-images.githubusercontent.com/32722128/155145052-adbc34cd-bb78-4f5d-97db-fe83b8569988.png)

2. コメント一覧とコメント投稿を行う画面が表示される事を確認しましょう。<br>
![image](https://user-images.githubusercontent.com/32722128/155418950-029bc2f8-b417-423b-b530-2cd03e1f6023.png)

3. 削除するIDを入れて削除ボタンを押してください、削除機能は未実装なので削除されない事を確認してください。<br>
![image](https://user-images.githubusercontent.com/32722128/155418906-55f4d372-a55e-4acb-8e3d-4ffe192873d8.png)

## 解説
### Daoについて
* データアクセスオブジェクトの略で「ダオ」と呼ばれます、アプリケーション内でのデータアクセスの機能を担います。
* データベースアクセス専門のクラスを作って、データベースに関する事はすべてそのクラスに任せようという考えの元作られたデザインパターン(汎用的な設計パターン)です。
* DBMS（データベース管理システム）が変わったりした場合(例えばOracleからMySQL)DAOのみを変更する事で対処する事が出来るので、変更に強いデザインパターンといわれています。  

* 今回の例では、DAOに以下の機能が実装されています。
  * insertComment  
    コメントを登録する機能
  * getAll  
    コメントを全件取得する機能
  * getCommentSerchByname  
    名前でコメントを検索する機能
* 以下の機能はこの演習で実装してください。
  * deleteComment  
    コメントを削除する機能
    
* DAOの実装方法について
insertCommentメソッドを例に説明していきます。  
JdbcTemplateを利用してSQL実行しDBに対して操作を行っています。  
insert、update、deleteはJdbcTemplateクラスのupdateメソッドを使用しています。  
[updateメソッドについて](https://spring.pleiades.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html#update-java.lang.String-java.lang.Object...-  )  
![image](https://user-images.githubusercontent.com/32722128/155273449-e5e7e2b1-4e0b-4bf1-a8a8-6c265b428789.png)  
第一引数にSQLを、第二引数以降に、クエリにバインドする引数を指定しています。  
SQLの「?」の部分に第二引数以降に指定した引数で置き換えられます。  
今回の演習ではdeleteCommentメソッドに、idで指定したコメントを削除する機能を追加しましょう。
![image](https://user-images.githubusercontent.com/32722128/155274751-3b60450e-96ec-485e-a2a6-7a88248d60ba.png)

### Entityクラス(エンティティクラス)について
DBから取得するデータまたは、DBに格納するデータのやり取りに、Entityクラスと呼ばれるクラスのオブジェクトを利用しています。  
insertCommentメソッドを例とすると、CommentクラスがEntityクラスにあたります。  
通常エンティティクラスの一つのオブジェクトがデータベーステーブルの一行に対応するようクラス定義が行われます。  
似たようなものとして、入力フォームのデータを保持するために使用されるフォームクラスがあります、  
今回の演習ではCommentFormクラスがフォームクラス、CommentクラスがEntityクラスとなっています。  
EntityクラスであるCommentクラスには作成日時(created)項目が存在しますが、フォームクラスであるCommentFormクラスには存在していません。  
フォームの入力項目として作成日時は存在しないためこのようなつくりとなっています。  
このように、フォームの入力項目として持ちたい項目と、DBのテーブル項目が異なる事が多々ありますので、フォームクラスとEntityクラスは別々に作成しましょう。  

## 演習level2 step8
1. STEP-8のページを開きます、idを指定し削除ボタンを押すと、指定したコメントが削除されるよう機能を追加してください。<br>

## ヒント
1. `CommentDaoImpl`クラスの、`deleteComment`メソッドに処理を追加しましょう。
* 編集先:`~/src/main/java/com/classroom/assignment/repository/CommentDaoImpl.java`

## テスト
* 提出前に回答があっているかテストしてみましょう。

1. `~/src/test/java/com/classroom/assignment/controller/api/Step8ControllerTests.java`を開きます。

2. クラス名の前の再生ボタンをクリックします。(画面コピーは一度テスト実施済みのためチェックマークに変わっています。)
![image](https://user-images.githubusercontent.com/32722128/155289607-c5d098f7-e1ca-4479-bee0-366944d29393.png)

3. 再生ボタンがチェックマークに変わればテスト成功です！

## 課題の提出
* 課題の提出は第一回と同じ[操作](/課題の提出手順.md)のコミット・プッシュ・プルリクエストを実施しましょう。
