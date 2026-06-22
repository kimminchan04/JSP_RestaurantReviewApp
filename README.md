# JSP_RestaurantReviewApp

JSP/Servlet 기반 **맛집 리뷰 웹 애플리케이션**입니다.  
회원 가입·로그인, 식당 등록·조회, 리뷰 작성·관리 기능을 Eclipse Dynamic Web Project 형태로 구현했습니다.

## 주요 기능

- **회원**: 회원가입, 로그인, 가입 성공/실패 처리
- **식당**: 맛집 정보 등록 및 목록 조회
- **리뷰**: 식당에 대한 리뷰 작성·수정·삭제
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
│   ├── java/com/           # Servlet·DAO·Model
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

## 실행 방법

### 1. 사전 준비

- JDK 8+
- Eclipse IDE for Enterprise Java and Web Developers
- Apache Tomcat 9.x (또는 호환 버전)
- MySQL (프로젝트 DB 설정에 맞게)

### 2. Eclipse에서 Import

1. **File → Import → Existing Projects into Workspace**
2. `JSP_RestaurantReviewApp` 폴더 선택
3. Tomcat Server Runtime 설정

### 3. DB 및 설정

- `WEB-INF` 또는 Java 소스의 DB 연결 정보를 로컬 MySQL에 맞게 수정
- 필요 시 DB 스키마(회원, 식당, 리뷰 테이블) 생성

### 4. 배포 및 실행

1. 프로젝트를 Tomcat에 Add and Remove
2. Server 시작
3. 브라우저에서 `http://localhost:8080/[컨텍스트경로]/` 접속

## 페이지 개요

| 경로 | 설명 |
|------|------|
| `/index.jsp` | 메인 |
| `/member/joinForm.jsp` | 회원가입 폼 |
| `/member/login.jsp` | 로그인 |
| `/restaurant/*` | 식당 CRUD |
| `/review/*` | 리뷰 CRUD |

## 참고

- Servlet 매핑 및 DB 접속 정보는 `WEB-INF/web.xml`과 Java DAO 클래스를 확인하세요.
- 한글 인코oding은 `UTF-8` 필터 설정을 권장합니다.
