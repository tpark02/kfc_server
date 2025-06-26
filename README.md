# ⚽ KFC - Kickoff Football Club Simulator

KFC is a full-stack football club simulation web application. It allows users to build squads, simulate leagues, manage players and formations, and view team stats in a game-like experience inspired by modern football manager platforms.

---

## 🧠 Project Overview

Kickoff Football Club Simulator (KFC) is a football management simulation platform built with a professional service-oriented mindset.

While the theme is football, the true goal is to demonstrate capabilities in **full-stack development**, including RESTful API design, frontend architecture, user authentication, data modeling, dynamic UI rendering, and **efficient large-scale data processing**.

---


## 🛠️ Tech Stack

| Layer        | Stack |
|--------------|-------|
| Frontend     | React + TypeScript + Zustand + Material UI (MUI) |
| Backend      | Spring Boot 3, Java 17, JPA/Hibernate, RESTful APIs |
| Database     | H2 / MariaDB |
| Deployment   | Docker + VPS (Contabo) |


---

## 📁 Project Structure

```
kfc_server-main/
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
├── excel_data/                # Contains initial CSV data for clubs/players
├── src/
│   ├── main/
│   │   ├── java/com/example/kfc/
│   │   │   ├── controller/     # REST controllers (API endpoints)
│   │   │   ├── service/        # Business logic
│   │   │   ├── entity/         # JPA entity classes (Player, Club, etc.)
│   │   │   ├── repository/     # Spring Data JPA repositories
│   │   │   ├── dto/            # Data transfer objects (input/output)
│   │   │   ├── Request/        # Custom request classes
│   │   │   ├── Response/       # Custom response classes
│   │   │   ├── config/         # Spring configuration (Web, SQL loader, etc.)
│   │   │   └── data/           # Utility helpers like FormationUtil
│   │   └── resources/
│   │       ├── application.properties  # Spring Boot config
│   │       ├── schema.sql              # DB schema definition
│   │       ├── *.sql                   # Initial SQL data
│   │       ├── static/                 # Static web files (HTML)
│   │       └── templates/              # Template views (if used)
│   └── test/                           # Unit & integration tests
```

---

## 🚀 Getting Started

### 🖥 Backend Setup

```bash
cd kfc_server-main
./gradlew bootRun
```

> Ensure Java 17+ is installed. Default DB is H2 (in-memory) unless configured in `application.properties`.

### 🌐 Frontend Setup

```bash
cd kfc-main
npm install
npm run dev
```

Then go to: [http://localhost:5173](http://localhost:5173)

---

## 📊 Features

- 🧠 Random squad generation
- 🎮 League & match simulations
- 🛠 Drag & drop squad builder
- 📝 Custom formations
- 🏆 Team chemistry, pace, defense, stamina, cohesion
- 📦 CSV import support for player/club data
- 🔐 Login / Sign Up system (planned)

---

## 📡 API Endpoints

Most endpoints are prefixed with `/api`.

| Method   | Path                                      | Controller            |
|----------|-------------------------------------------|------------------------|
| POST     | /api/login                                | AuthController         |
| POST     | /api/signup                               | AuthController         |
| GET      | /api/leagues                              | LeagueController       |
| GET      | /api/teams                                | TeamController         |
| GET      | /api/logos                                | TeamLogoController     |
| GET      | /api/logos/{id}                           | TeamLogoController     |
| POST     | /api/teams/random                         | RandomTeamController   |
| POST     | /api/simulations/schedule                 | SimController          |
| GET      | /api/protected                            | ProtectedController    |
| GET      | /api/me                                   | UserInfoController     |
| GET      | /api/users/{userId}                       | UserInfoController     |
| GET      | /api/users/{userId}/clubs                 | MyClubController       |
| PUT      | /api/users/{userId}/clubs/{clubId}        | MyClubController       |
| DELETE   | /api/users/{userId}/clubs/{clubId}        | MyClubController       |
| PUT      | /api/users/{userId}/players/{idx}         | MyClubController       |
| GET      | /api/users/{userId}/players               | PlayerController       |
| POST     | /api/players                              | PlayerController       |
| PUT      | /api/store/players/purchase               | MyStoreController      |

---

## ⚙️ Configuration

You can switch to MySQL by editing:

```properties
# src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/kfc_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 🧠 Team Chemistry Logic

The backend includes logic like:

- +5 chemistry for same nationality
- +3 chemistry for same league
- +7 chemistry for same team

---

## 📜 License

MIT © 2025 Daniel Park ([GitHub](https://github.com/tpark02))

---

## 🤝 Contribution

Pull requests welcome! For feature suggestions or bug reports, open an issue first.

---

# ⚽ KFC - 킥오프 풋볼 클럽 시뮬레이터

**KFC**는 풀스택으로 개발된 축구 클럽 시뮬레이션 웹 애플리케이션입니다. 사용자는 스쿼드를 구성하고, 리그를 시뮬레이션하며, 선수와 포메이션을 관리하고, 실제 축구 매니저 게임에서 영감을 받은 방식으로 팀 통계를 확인할 수 있습니다.

---

## 🧠 프로젝트 개요

Kickoff Football Club Simulator (KFC)는 서비스 지향적인 마인드셋으로 구축된 축구 매니지먼트 시뮬레이션 플랫폼입니다.

비록 주제는 축구이지만, 진정한 목표는 **풀스택 개발 역량**을 보여주는 데 있습니다.  
이에는 RESTful API 설계, 프론트엔드 아키텍처, 사용자 인증, 데이터 모델링, 동적 UI 렌더링, **대규모 데이터 처리** 기술이 포함됩니다.

---

## 🛠️ 기술 스택

| 계층        | 스택 |
|-------------|------|
| 프론트엔드  | React + TypeScript + Zustand + Material UI (MUI) |
| 백엔드      | Spring Boot 3, Java 17, JPA/Hibernate, RESTful API |
| 데이터베이스 | H2 / MariaDB |
| 배포        | Docker + VPS (Contabo) |

---

## 📁 프로젝트 구조

```
kfc_server-main/
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
├── excel_data/                # 초기 CSV 데이터 (클럽/선수)
├── src/
│   ├── main/
│   │   ├── java/com/example/kfc/
│   │   │   ├── controller/     # REST 컨트롤러 (API 엔드포인트)
│   │   │   ├── service/        # 비즈니스 로직
│   │   │   ├── entity/         # JPA 엔티티 클래스 (Player, Club 등)
│   │   │   ├── repository/     # Spring Data JPA 리포지토리
│   │   │   ├── dto/            # 데이터 전달 객체 (입출력)
│   │   │   ├── Request/        # 커스텀 요청 클래스
│   │   │   ├── Response/       # 커스텀 응답 클래스
│   │   │   ├── config/         # 스프링 설정 (Web, SQL 로더 등)
│   │   │   └── data/           # FormationUtil 등 유틸리티
│   │   └── resources/
│   │       ├── application.properties  # Spring Boot 설정
│   │       ├── schema.sql              # DB 스키마 정의
│   │       ├── *.sql                   # 초기 SQL 데이터
│   │       ├── static/                 # 정적 파일 (HTML 등)
│   │       └── templates/              # 템플릿 뷰 (사용 시)
│   └── test/                           # 유닛 및 통합 테스트
```

---

## 🚀 시작하기

### 🖥 백엔드 설정

```bash
cd kfc_server-main
./gradlew bootRun
```

> Java 17 이상이 설치되어 있어야 합니다. 기본 DB는 H2 (인메모리)이며, `application.properties`에서 변경 가능합니다.

### 🌐 프론트엔드 설정

```bash
cd kfc-main
npm install
npm run dev
```

그런 다음 브라우저에서 [http://localhost:5173](http://localhost:5173) 접속하세요.

---

## 📊 주요 기능

- 🧠 랜덤 스쿼드 생성
- 🎮 리그 및 경기 시뮬레이션
- 🛠 드래그 & 드롭 스쿼드 빌더
- 📝 커스텀 포메이션
- 🏆 팀 케미스트리, 스피드, 수비, 체력, 조직력
- 📦 CSV로 선수 및 클럽 데이터 가져오기 지원
- 🔐 로그인 / 회원가입 시스템 (예정)

---

## 📡 API 엔드포인트

대부분의 엔드포인트는 `/api` 접두어를 가집니다.

| 메서드  | 경로                                        | 컨트롤러              |
|---------|---------------------------------------------|------------------------|
| POST    | /api/login                                  | AuthController         |
| POST    | /api/signup                                 | AuthController         |
| GET     | /api/leagues                                | LeagueController       |
| GET     | /api/teams                                  | TeamController         |
| GET     | /api/logos                                  | TeamLogoController     |
| GET     | /api/logos/{id}                             | TeamLogoController     |
| POST    | /api/teams/random                           | RandomTeamController   |
| POST    | /api/simulations/schedule                   | SimController          |
| GET     | /api/protected                              | ProtectedController    |
| GET     | /api/me                                     | UserInfoController     |
| GET     | /api/users/{userId}                         | UserInfoController     |
| GET     | /api/users/{userId}/clubs                   | MyClubController       |
| PUT     | /api/users/{userId}/clubs/{clubId}          | MyClubController       |
| DELETE  | /api/users/{userId}/clubs/{clubId}          | MyClubController       |
| PUT     | /api/users/{userId}/players/{idx}           | MyClubController       |
| GET     | /api/users/{userId}/players                 | PlayerController       |
| POST    | /api/players                                | PlayerController       |
| PUT     | /api/store/players/purchase                 | MyStoreController      |

---

## ⚙️ 설정

MySQL을 사용하려면 아래를 수정하세요:

```properties
# src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/kfc_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 🧠 팀 케미스트리 로직

백엔드에는 다음과 같은 로직이 포함되어 있습니다:

- 동일 국적: +5 케미스트리
- 동일 리그: +3 케미스트리
- 동일 팀: +7 케미스트리

---

## 📜 라이선스

MIT © 2025 Daniel Park ([GitHub](https://github.com/tpark02))

---

## 🤝 기여

Pull Request는 언제든지 환영입니다! 기능 제안이나 버그 리포트는 이슈를 먼저 등록해주세요.
