# Proyecto Spring Boot de clase

## 🚀 Tecnologías utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Thymeleaf**
- **Lombok**
- **Bootstrap / Tailwind CSS** (para el frontend)
- **RestTemplate** (para consumir la API externa de Superhero)

## 📦 Estructura del proyecto

src/ \
└─ main/ \
├─ java/ \
│ └─ com.cebem.medidor \
│ ├─ models/ \
│ ├─ repositories/ \
│ ├─ controllers/ \
└─ resources/ \
├─ templates/ \
└─ application.properties

# 🦸‍♂️ Superhero API

Este proyecto es una **API y web app** hecha en Spring Boot para buscar y mostrar información de superhéroes usando la [SuperHero API](https://superheroapi.com/).  
Incluye endpoints REST y vistas HTML (Thymeleaf) para visualizar las cartas de personajes.


## ⚙️ Instalación y ejecución

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/tuusuario/superhero-api-springboot.git
   cd superhero-api-springboot

## 🚀 Tecnologías utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data MongoDB**
- **Spring Data JPA** (PostgreSQL)
- **Thymeleaf** (para las vistas HTML)
- **Lombok**
- **MongoDB Atlas**
- **PostgreSQL**
- **Bootstrap / Tailwind CSS** (para el frontend)


---

# 🤖 RobotArmy

Proyecto de gestión de robots y misiones para el ejército del futuro.  
Realizado en **Spring Boot** con persistencia en **MongoDB Atlas** (robots/misiones).

## 🖥️ Vistas web (Thymeleaf)
- /robots/lista — Lista de robots y acceso al historial de misiones de cada robot.

- /misiones/lista — Lista de misiones con filtro por dificultad y estado.

- /robots/{id}/historial — Historial de misiones de un robot.

## ⭐️ Funcionalidades destacadas

- Comprobación de energía y nivel al asignar robots a misiones.

- Historial de misiones por robot.

- Filtros en la vista de misiones por dificultad y estado.

- Separación de endpoints REST y vistas web.

---


## ⚙️ Configuración de variables de entorno

Este proyecto necesita un archivo `.env` en la raíz para las credenciales y configuraciones sensibles.

**Por seguridad, el archivo `.env` real NO se incluye en el repositorio.**

### Pasos para configurarlo:

1. **Copia el archivo de ejemplo:**

   ```bash
   cp .env.example .env

2. **Rellena tus datos reales en el archivo ```.env```:**

- POSTGRES_URL — Cadena de conexión a PostgreSQL

- POSTGRES_USER — Usuario de la base de datos

- POSTGRES_PASS — Contraseña de la base de datos

- MONGO_URI — URI de conexión a MongoDB Atlas

- MONGO_DB — Nombre de la base de datos de MongoDB

    *Ejemplo:* 

    ```
    POSTGRES_URL=jdbc:postgresql://mi-host:5432/mibasededatos?sslmode=require
    POSTGRES_USER=usuario
    POSTGRES_PASS=contraseña
    MONGO_URI=mongodb+srv:/usuario:contraseña@midominio.mongodb.net/?retryWrites=true&w=majority
    MONGO_DB=robotarmy

3. **No subas nunca tu ```.env``` real al repositorio.**

    El archivo ```.gitignore``` ya lo excluye por seguridad.

---

# 👨‍💻 Autor
David Cambra \
Proyecto para CEBEM - DAM \
2025