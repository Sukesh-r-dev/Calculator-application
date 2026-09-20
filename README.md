<div align="center">

# 🧮 Full-Stack Calculator Application
### A modern, persistent calculator web app powered by Java & Spring.

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/HTML5)
[![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
[![SQL](https://img.shields.io/badge/SQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)

[Features](#-features) • [Tech Stack](#-tech-stack) • [Project Structure](#-project-structure) • [Setup & Installation](#-setup--installation)

---

</div>

## 🚀 Key Features

* **✨ Dynamic UI:** Built with clean, responsive vanilla HTML, CSS, and JavaScript for smooth calculations.
* **🔌 RESTful Architecture:** Features a robust Java backend controller to effortlessly route calculation logic.
* **💾 Persistent Calculation History:** Integrated database storage utilizing Spring/JPA entities and repositories so past calculation sessions are safely stored and retrieved.

---

## 🛠️ Tech Stack

| Layer | Technology Used |
| :--- | :--- |
| **Frontend** | HTML5, CSS3, JavaScript |
| **Backend** | Java |
| **Database** | SQL (`calculator_db`) |

---

## 📂 Project Structure

```text
📦 Calculator-application
 ┣ 📜 calculation.java      # Entity model mapping out database calculation records
 ┣ 📜 calculationRepo.java  # Data repository interface for query handling and persistence
 ┣ 📜 controller.java       # Backend REST controller managing API routing
 ┣ 📜 database.sql          # SQL database initialization script
 ┣ 📜 index.html            # Calculator user interface layout
 ┣ 📜 script.js             # Calculator functionality & asynchronous API calls
 ┗ 📜 style.css             # Custom styling and responsive UI elements
