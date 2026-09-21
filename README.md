# 💧 Water Quality Monitoring System

A full-stack IoT-simulated water quality monitoring platform built with Spring Boot. Simulates real-time sensor data (pH, turbidity, temperature, flow rate), persists it to a database, and visualizes it through a live dashboard with role-based admin controls.

**🔗 Live Demo:** _(https://water-quality-monitoring-system-a8l2.onrender.com)

## Features
- 📡 Simulated multi-sensor data generation (pH, turbidity, temperature, flow rate)
- 💾 Persistent storage with Spring Data JPA + H2 database
- 📊 Live-updating dashboard with real-time status cards
- 📈 Historical trend visualization (Chart.js)
- ⚠️ Automated alert logging for unsafe water quality readings
- 🔐 Authentication & role-based access control (Admin / Viewer) via Spring Security
- ⚙️ Admin panel to configure safety thresholds in real time

## Tech Stack
- **Backend:** Java 21, Spring Boot, Spring Data JPA, Spring Security
- **Database:** H2 (file-based)
- **Frontend:** HTML, CSS, JavaScript, Chart.js
- **Build Tool:** Maven

## Architecture