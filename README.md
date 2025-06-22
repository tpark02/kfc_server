# ⚽ KFC - Kickoff Football Club Simulator

**KFC** is a full-stack football club simulation web application where users can manage their teams, simulate leagues, build squads with filters, and analyze football stats with game-like visuals.

## 🧱 Tech Stack

### 💻 Frontend (React + Vite)
- React + TypeScript
- Zustand for state management
- Tailwind CSS + MUI
- Vite as the build tool

### 🚀 Backend (Spring Boot)
- Spring Boot 3+
- Java 17
- JPA/Hibernate
- H2 or MySQL
- RESTful API
- Gradle for build

---

## 📁 Project Structure

```
frontend/
├── src/
│   ├── Components/      # Shared UI
│   ├── Modal/           # Filtering & selectors
│   ├── Util/            # Utility functions
│   ├── api/             # Axios wrappers
│   ├── store/           # Zustand stores
│   ├── style/           # CSS & Tailwind styles

backend/
├── src/
│   ├── main/java/com/example/kfc/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── entity/
│   │   ├── repository/
│   ├── resources/
│       ├── schema.sql
│       ├── *.sql (data files)
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

- 🧠 AI-based random squad generation
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
