# Despliegue con Docker

## Pasos para subir a Docker Hub

### 1. Preparación
Asegúrate de tener Docker instalado y estar logueado en Docker Hub:
```bash
docker login
```

### 2. Compilar y construir la imagen

**Para Windows:**
```bash
build-and-push.bat
```

**Para Linux/Mac:**
```bash
chmod +x build-and-push.sh
./build-and-push.sh
```

**Comandos manuales:**
```bash
# Compilar la aplicación
mvn clean package -DskipTests

# Construir la imagen (reemplaza 'tuusuario' con tu usuario de Docker Hub)
docker build -t tuusuario/sistema-facturacion:latest .

# Subir a Docker Hub
docker push tuusuario/sistema-facturacion:latest
```

### 3. Actualizar docker-compose.yml
Edita el archivo `docker-compose.yml` y cambia:
```yaml
image: tuusuario/sistema-facturacion:latest
```

### 4. Ejecutar con Docker Compose

**Para desarrollo local (construye la imagen localmente):**
```bash
# Comentar la línea 'image:' y descomentar 'build: .' en docker-compose.yml
docker-compose up --build
```

**Para producción (usa imagen de Docker Hub):**
```bash
docker-compose up -d
```

## Acceso a los servicios

- **API REST:** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **Adminer (DB Admin):** http://localhost:8081
  - Server: postgres
  - Username: postgres
  - Password: 1234
  - Database: bd_sistema_facturacion

## Comandos útiles

```bash
# Ver logs de la aplicación
docker-compose logs app

# Ver logs de PostgreSQL
docker-compose logs postgres

# Reiniciar solo la aplicación
docker-compose restart app

# Parar todos los servicios
docker-compose down

# Parar y eliminar volúmenes (borra la base de datos)
docker-compose down -v

# Ver estado de los contenedores
docker-compose ps
```

## Estructura de la imagen

- **Base:** OpenJDK 17 slim
- **Puerto:** 8080
- **Aplicación:** /app/app.jar
- **Variables de entorno:** Configurables via docker-compose.yml
