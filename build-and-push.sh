#!/bin/bash

# Script para construir y subir la imagen a Docker Hub
# Reemplaza 'tuusuario' con tu nombre de usuario de Docker Hub

DOCKER_USERNAME="tuusuario"
IMAGE_NAME="sistema-facturacion"
VERSION="latest"

echo "🏗️  Compilando la aplicación con Maven..."
mvn clean package -DskipTests

echo "🐳 Construyendo la imagen Docker..."
docker build -t $DOCKER_USERNAME/$IMAGE_NAME:$VERSION .

echo "📤 Subiendo la imagen a Docker Hub..."
docker push $DOCKER_USERNAME/$IMAGE_NAME:$VERSION

echo "✅ Imagen subida exitosamente a Docker Hub!"
echo "🔗 Para usar la imagen: docker pull $DOCKER_USERNAME/$IMAGE_NAME:$VERSION"
