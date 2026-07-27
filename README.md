# 商品在庫管理システム
Product Inventory Management System

## 概要
韓国の「情報処理産業技師」実技試験対策として制作したWebアプリケーションです。

JSP・JDBC・Oracle Databaseを使用し、商品の登録・一覧・更新・削除・検索機能を実装しました。

## 開発環境

- Java
- JSP (Scriptlet)
- HTML5
- CSS3
- JavaScript
- jQuery
- JDBC
- Oracle Database
- Apache Tomcat

## 機能

- 商品一覧表示
- 商品登録
- 商品修正
- 商品削除
- 商品検索

## システム構成

Browser

↓

JSP

↓

DTO

↓

DAO

↓

Oracle Database

## データベース

| Table | Description |
|------|-------------|
| PRODUCT | 商品情報管理 |

| Column | Type |
|---------|------|
| P_CODE | VARCHAR2(5) |
| P_NAME | VARCHAR2(30) |
| PRICE | NUMBER |
| STOCK | NUMBER |

## 学んだこと

- JSPを利用したWebアプリケーション開発
- request.getParameter()を利用したフォームデータ処理
- JDBCによるOracle Databaseとの連携（特に、SQLにワイルドカードがある場合、PreparedStatementを使う際　String sql ="'%?%'"(X); pstmt.setString("%"+str+"%");(O))
- DAO・DTOパターンの基本構成
- SQL CRUD処理
- JavaScript・jQueryによる入力チェック

## 今後改善したい点

- Servletを利用したMVC構成への改善
- Spring Frameworkへの移行
- UI改善
