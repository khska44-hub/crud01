# Product Stock Management System
# 商品在庫管理システム

---

# Overview / プロジェクト概要

### English

This project is a product stock management system developed using Spring MVC.

It provides asynchronous CRUD operations and wildcard search functionality using JavaScript (ES6), Fetch API, and async/await.

The project was developed to understand the Spring MVC architecture, database integration, and asynchronous communication in web applications.

### 日本語

Spring MVCを用いて開発した商品在庫管理システムです。

JavaScript (ES6+) のFetch APIとasync/awaitを利用し、CRUD機能およびワイルドカード検索機能を非同期通信で実装しました。

Spring MVCアーキテクチャやデータベース連携、Webアプリケーションにおける非同期通信を学習することを目的として制作しました.

---

# Tech Stack

## Backend

- Java
- Spring MVC
- MyBatis
- Oracle Database

## Frontend

- JSP
- HTML5
- CSS3
- JavaScript (ES6+)
- Fetch API
- async / await

## Development Tools

- Eclipse
- Maven
- Git
- GitHub

---

# Features / 実装機能

### English

- Asynchronous Product Registration
- Asynchronous Product List
- Asynchronous Product Update
- Asynchronous Product Deletion
- Wildcard Search
- Asynchronous Communication using Fetch API (async/await)

### 日本語

- 商品登録（非同期）
- 商品一覧（非同期）
- 商品修正
- 商品削除（非同期）
- ワイルドカード検索（非同期）
- Fetch API（async/await）による非同期通信

---

# System Architecture

```
JSP
 │
 ▼
Controller
 │
 ▼
Service
 │
 ▼
MyBatis
 │
 ▼
Oracle Database
```

---

# Database Structure / データベース構造

## PRODUCT

| Column | Type | Key | Description |
|--------|------|-----|-------------|
| P_CODE | VARCHAR2(5) | PK | Product Code |
| P_NAME | VARCHAR2(30) | | Product Name |
| PRICE | NUMBER | | Product Price |
| STOCK | NUMBER | | Stock Quantity |

### 日本語

| カラム名 | 型 | キー | 説明 |
|-----------|------|------|------|
| P_CODE | VARCHAR2(5) | PK | 商品コード |
| P_NAME | VARCHAR2(30) | | 商品名 |
| PRICE | NUMBER | | 商品価格 |
| STOCK | NUMBER | | 在庫数 |

---

# What I Learned / 学習内容

### English

- Spring MVC Architecture
- Controller-Service-DAO Structure
- MyBatis Integration
- Oracle Database
- CRUD Implementation
- Fetch API
- Asynchronous Communication using async/await
- Wildcard Search Implementation

### 日本語

- Spring MVCアーキテクチャ
- Controller・Service・DAO構造
- MyBatisによるデータベース連携
- Oracle Database
- CRUD機能の実装
- Fetch API
- async/awaitによる非同期通信
- ワイルドカード検索機能

---

# Screenshots

## Product List

<img src="images/product-list.png" width="800">

---

## Product Registration

<img src="images/product-create.png" width="800">

---

## Product Update

<img src="images/product-update.png" width="800">

---

## Product Search

<img src="images/product-search.png" width="800">

---

# Project Purpose / 制作目的

### English

The purpose of this project is to understand the Spring MVC architecture and improve backend development skills through CRUD implementation, database integration, and asynchronous communication.

### 日本語

本プロジェクトは、Spring MVCアーキテクチャへの理解を深めるとともに、CRUD機能・データベース連携・非同期通信を実践的に学習することを目的として制作しました。

---

# Next Version / 今後の改善予定

## Planned Improvements

### Frontend

```
JavaScript (JSP)
        ↓
TypeScript (HTML / CSS / TS)
```

### Goals

- Improve Type Safety
- Improve Code Readability
- Improve Maintainability

---

### English

The next version of this project will migrate the frontend from JavaScript running on JSP to TypeScript with HTML and CSS.

The main goal is to improve type safety and code maintainability while keeping the existing CRUD operations and search functionality.

### 日本語

次のバージョンでは、フロントエンドをJSP上のJavaScript(.jsp)から、TypeScript(.ts)・HTML・CSSへ移行する予定です。

既存のCRUD機能や検索機能はそのまま維持しながら、型安全性やコードの可読性を向上させることを目標としています。
