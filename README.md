# JSP_RestaurantReviewApp

JSP, Servlet 기반 **맛집 리뷰 웹 애플리케이션**입니다.  
회원 가입, 로그인, 식당 등록, 조회, 리뷰 작성·관리 기능을 Eclipse Dynamic Web Project 형태로 구현했습니다.

## 주요 기능

- **회원**: 회원가입, 로그인, 가입 성공, 실패 처리
- **식당**: 맛집 정보 등록 및 목록 조회
- **리뷰**: 식당에 대한 리뷰 작성, 수정, 삭제
- **공통 UI**: `header.jsp` 공통 헤더, `index.jsp` 메인 페이지

## 기술 스택

| 구분 | 기술 |
|------|------|
| View | JSP |
| Backend | Java Servlet |
| Server | Apache Tomcat |
| IDE | Eclipse (Dynamic Web Project) |

## 프로젝트 구조

```
JSP_RestaurantReviewApp/
├── src/main/
│   ├── java/com/           # Servlet, DAO, Model
│   └── webapp/
│       ├── index.jsp
│       ├── header.jsp
│       ├── member/         # joinForm, joinSuccess, joinFail, login
│       ├── restaurant/     # 식당 관련 JSP
│       ├── review/         # 리뷰 관련 JSP
│       └── WEB-INF/        # web.xml, lib
├── .classpath
└── .project
```

## 페이지 개요

| 경로 | 설명 |
|------|------|
| `/index.jsp` | 메인 |
| `/member/joinForm.jsp` | 회원가입 폼 |
| `/member/login.jsp` | 로그인 |
| `/restaurant/*` | 식당 CRUD |
| `/review/*` | 리뷰 CRUD |
