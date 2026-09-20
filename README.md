<div align="center">

# 🧮 Calculator Application

A modern, full-stack calculator application featuring a sleek web-based frontend and a robust Java backend API with persistent history storage.

[Features](#-features) • [Tech Stack](#-tech-stack) • [Project Structure](#-project-structure) • [Setup & Installation](#-setup-and-installation)

---

</div>

## 🚀 Features

* **✨ Interactive UI:** Clean, responsive, and user-friendly interface built with vanilla JavaScript, HTML, and CSS.
* **🔌 RESTful API:** Java-backed backend controller seamlessly routing calculation requests and logic.
* **💾 Persistent History:** Database-backed storage using Spring/JPA entities and repositories to store and retrieve past calculations.

---

## 🛠️ Tech Stack

| Component | Technology |
| :--- | :--- |
| **Frontend** | HTML5, CSS3, JavaScript |
| **Backend** | Java |
| **Database** | SQL (`calculator_db`) |

---

## 📂 Project Structure

```text
📦 Calculator-application
 ┣ 📜 calculation.java      # Entity model for mapping calculation history records
 ┣ 📜 calculationRepo.java  # Repository interface for database persistence operations
 ┣ 📜 controller.java       # REST controller managing backend endpoints and requests
 ┣ 📜 database.sql          # SQL initialization script for database and tables
 ┣ 📜 index.html            # Main calculator user interface layout
 ┣ 📜 script.js             # Calculator logic and async frontend-to-backend communication
 ┗ 📜 style.css             # UI styling and responsive design configurations
