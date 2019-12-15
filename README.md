# このプロジェクトについて
ドメイン駆動開発の前提としてオニオンアーキテクチャ構成のプロジェクトを作成する上で、Gradleマルチモジュールにてインフラストラクチャ層を別モジュールとして独立させることにより、アプリケーション本体のインフラ技術への依存性を排除したい。

アプリケーション層およびドメイン層にリポジトリのインタフェースを用意し、インフラストラクチャ層に実装クラスを配置する依存性逆転の構成をGradleマルチモジュールにて実現する方法を調査する。

# 利用技術
* Spring Boot 2.2.1
* Lombok
* Doma 2
* MySQL 5.7

# インポート
## IntelliJ IDEA Ultimate
1. gradleプロジェクトとしてインポート
2. アノテーションプロセッサ設定

## eclipse
1. gradleプロジェクトとしてインポート
2. gradleタスク`cleanEclipse`実行
3. gradleタスク`eclipse`実行

# 実行方法
## DB準備
1. テストスキーマ作成
2. init.sql実行
3. application.propertiesのDB設定変更を合わせる

## アプリケーション実行テスト
1. アプリケーション起動
2. `http://localhost:8080/api`にてJsonが返却される。

## リポジトリテスト
`multi-project-infrastructure`モジュール配下の`MessageRepositoryImplTest`をjUnitで実行。

## アプリケーションサービステスト
`multi-project-main`モジュール配下の`MessageCommandServiceTest`をjUnitで実行。

# 実現方法
## モジュール構成
### `multi-project-boot`モジュール
アプリケーションクラスのみを配置。

なお、テスト時における依存性を排除するため、他モジュールの`test`配下にもテスト用アプリケーションクラスを配置している。

### `multi-project-infrastructure`モジュール
#### domainパッケージ
`multi-project-main`モジュールの`domain`パッケージに格納したドメインクラスのパッケージプライベートな再構築用コンストラクタを利用するファクトリクラスを配置。

#### infrastructureパッケージ
上記ファクトリクラスを利用するリポジトリ実装クラスやクエリサービス実装クラスを配置。

### `multi-project-main`モジュール
#### application
アプリケーション層のアプリケーションサービスクラスおよびクエリサービスインタフェースを配置。

#### domain
ドメイン層のドメインクラスおよびリポジトリインタフェースを配置。

#### presentation
プレゼンテーション層のコントローラなどを配置。

## Gradle設定
### 依存関係
基本的にはプロジェクト間の依存関係を設定するのみ。テスト用に`configurations`設定など行ったが、eclipseでは効果無かったのでもっと単純な設定で良かったかもしれない。

### eclipseタスク
アノテーションプロセッサ有効化、Domaファクトリ設定の他、循環参照エラーレベル変更設定を実施。

# ビルド依存関係
## 通常起動時
boot → instastructure → main

## テスト実行時
### infrastructureモジュール
特になし

### mainモジュール
main → infrastructure

# 苦しんだポイント
以前かなり凝った構成で試した際にeclipseだけビルドが通らなかったため、モジュール数やモジュール間の依存関係を最小にしたが、今回もテストのみの依存性であっても循環参照エラーが発生。
Gradleの依存性設定ではどうやっても解消することができなかったため、eclipseタスクにてエラーレベルをワーニングに変更することで回避したが、この調査だけで1週間くらい使った。

# 参考
* [WEB+DB PRESS Vol.113｜技術評論社](https://gihyo.jp/magazine/wdpress/archive/2019/vol113)
* [WEB+DB PRESS特集「体験 ドメイン駆動」を執筆しました [DDD] - little hands&#39; lab](https://little-hands.hatenablog.com/entry/2019/10/24/web-db-press-ddd)
* [little-hands/webdbpress-2019-10-ddd: WEB+DB PRESS 2019年10月号「体験 ドメイン駆動設計 モデリングから実装までを一気に制覇」サンプルコード<](https://github.com/little-hands/webdbpress-2019-10-ddd)
