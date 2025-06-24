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
