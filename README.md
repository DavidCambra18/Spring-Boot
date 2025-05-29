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

    Ejemplo: 

    ```bash
    POSTGRES_URL=jdbc:postgresql://mi-host:5432/mibasededatos?sslmode=require
    POSTGRES_USER=usuario
    POSTGRES_PASS=contraseña

    MONGO_URI=mongodb+srv:/usuario:contraseña@midominio.mongodb.net/?retryWrites=true&w=majority
    MONGO_DB=robotarmy

3. **No subas nunca tu ```.env``` real al repositorio.**

    El archivo ```.gitignore``` ya lo excluye por seguridad.