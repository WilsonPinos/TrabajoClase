@echo off
REM Script para construir y subir la imagen a Docker Hub
REM Reemplaza 'tuusuario' con tu nombre de usuario de Docker Hub

set DOCKER_USERNAME=tuusuario
set IMAGE_NAME=sistema-facturacion
set VERSION=latest

echo 🏗️  Compilando la aplicación con Maven...
call mvn clean package -DskipTests

if %errorlevel% neq 0 (
    echo ❌ Error en la compilación
    exit /b 1
)

echo 🐳 Construyendo la imagen Docker...
docker build -t %DOCKER_USERNAME%/%IMAGE_NAME%:%VERSION% .

if %errorlevel% neq 0 (
    echo ❌ Error construyendo la imagen
    exit /b 1
)

echo 📤 Subiendo la imagen a Docker Hub...
docker push %DOCKER_USERNAME%/%IMAGE_NAME%:%VERSION%

if %errorlevel% neq 0 (
    echo ❌ Error subiendo la imagen
    exit /b 1
)

echo ✅ Imagen subida exitosamente a Docker Hub!
echo 🔗 Para usar la imagen: docker pull %DOCKER_USERNAME%/%IMAGE_NAME%:%VERSION%
