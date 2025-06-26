# Sistema de Facturación - API REST

Este proyecto es un microservicio desarrollado en Spring Boot que proporciona una API RESTful para la gestión de un sistema de facturación.

## Características

- **Framework**: Spring Boot 3.5.3
- **Base de datos**: PostgreSQL
- **Documentación API**: Swagger/OpenAPI 3
- **ORM**: JPA/Hibernate
- **Build Tool**: Maven

## Entidades del Sistema

El sistema incluye las siguientes entidades:

1. **TipoPago** - Gestión de tipos de pago
2. **Persona** - Información de personas
3. **Usuario** - Usuarios del sistema
4. **Rol** - Roles de usuario
5. **Competencia** - Competencias
6. **Clasificacion** - Clasificación de productos
7. **Proveedores** - Información de proveedores
8. **Producto** - Gestión de productos
9. **Factura** - Facturas del sistema
10. **ItemFactura** - Ítems de las facturas

## Configuración de la Base de Datos

1. Crear una base de datos PostgreSQL llamada `bd_sistema_facturacion`
2. Configurar las credenciales en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/bd_sistema_facturacion
   spring.datasource.username=postgres
   spring.datasource.password=1234
   ```

### Verificar Datos en la Base de Datos

Para confirmar que los datos se han cargado correctamente, puedes:

1. **Usar Swagger UI** para probar los endpoints GET
2. **Conectarte directamente a PostgreSQL**:
   ```sql
   SELECT COUNT(*) FROM persona;      -- Debe retornar 4
   SELECT COUNT(*) FROM producto;     -- Debe retornar 5
   SELECT COUNT(*) FROM factura;      -- Debe retornar 4
   SELECT COUNT(*) FROM tipo_pago;    -- Debe retornar 4
   ```

3. **Usar los endpoints de prueba**:
   - `GET /api/personas` → Debería mostrar 4 personas
   - `GET /api/productos` → Debería mostrar 5 productos
   - `GET /api/facturas` → Debería mostrar 4 facturas

## Ejecución del Proyecto

1. **Compilar el proyecto**:
   ```bash
   mvn clean compile
   ```

2. **Ejecutar la aplicación**:
   ```bash
   mvn spring-boot:run
   ```

3. **Acceder a Swagger UI**:
   - URL: `http://localhost:8080/swagger-ui.html`
   - Documentación API: `http://localhost:8080/api-docs`

## Endpoints Principales

### TipoPago
- `GET /api/tipos-pago` - Obtener todos los tipos de pago
- `GET /api/tipos-pago/{id}` - Obtener tipo de pago por ID
- `POST /api/tipos-pago` - Crear nuevo tipo de pago
- `PUT /api/tipos-pago/{id}` - Actualizar tipo de pago
- `DELETE /api/tipos-pago/{id}` - Eliminar tipo de pago

### Personas
- `GET /api/personas` - Obtener todas las personas
- `GET /api/personas/{id}` - Obtener persona por ID
- `GET /api/personas/dni/{dni}` - Obtener persona por DNI
- `POST /api/personas` - Crear nueva persona
- `PUT /api/personas/{id}` - Actualizar persona
- `DELETE /api/personas/{id}` - Eliminar persona

### Productos
- `GET /api/productos` - Obtener todos los productos
- `GET /api/productos/{id}` - Obtener producto por ID
- `GET /api/productos/en-stock` - Obtener productos en stock
- `GET /api/productos/precio-rango` - Filtrar por rango de precio
- `POST /api/productos` - Crear nuevo producto
- `PUT /api/productos/{id}` - Actualizar producto
- `DELETE /api/productos/{id}` - Eliminar producto

### Facturas
- `GET /api/facturas` - Obtener todas las facturas
- `GET /api/facturas/{id}` - Obtener factura por ID
- `GET /api/facturas/persona/{idPersona}` - Facturas por persona
- `GET /api/facturas/fecha-rango` - Facturas por rango de fechas
- `GET /api/facturas/total-ventas` - Total de ventas por fechas
- `POST /api/facturas` - Crear nueva factura
- `PUT /api/facturas/{id}` - Actualizar factura
- `DELETE /api/facturas/{id}` - Eliminar factura

### Clasificaciones
- `GET /api/clasificaciones` - Obtener todas las clasificaciones
- `POST /api/clasificaciones` - Crear nueva clasificación
- `PUT /api/clasificaciones/{id}` - Actualizar clasificación
- `DELETE /api/clasificaciones/{id}` - Eliminar clasificación

### Proveedores
- `GET /api/proveedores` - Obtener todos los proveedores
- `GET /api/proveedores/{id}` - Obtener proveedor por ID
- `GET /api/proveedores/ruc/{ruc}` - Obtener proveedor por RUC
- `POST /api/proveedores` - Crear nuevo proveedor
- `PUT /api/proveedores/{id}` - Actualizar proveedor
- `DELETE /api/proveedores/{id}` - Eliminar proveedor

### Usuarios
- `GET /api/usuarios` - Obtener todos los usuarios
- `GET /api/usuarios/{id}` - Obtener usuario por ID
- `GET /api/usuarios/username/{username}` - Obtener usuario por nombre de usuario
- `POST /api/usuarios` - Crear nuevo usuario
- `PUT /api/usuarios/{id}` - Actualizar usuario
- `DELETE /api/usuarios/{id}` - Eliminar usuario

### Roles
- `GET /api/roles` - Obtener todos los roles
- `GET /api/roles/{id}` - Obtener rol por ID
- `GET /api/roles/nombre/{rol}` - Obtener rol por nombre
- `POST /api/roles` - Crear nuevo rol
- `PUT /api/roles/{id}` - Actualizar rol
- `DELETE /api/roles/{id}` - Eliminar rol

### Competencias
- `GET /api/competencias` - Obtener todas las competencias
- `GET /api/competencias/{id}` - Obtener competencia por ID
- `GET /api/competencias/nombre/{nombre}` - Obtener competencia por nombre
- `POST /api/competencias` - Crear nueva competencia
- `PUT /api/competencias/{id}` - Actualizar competencia
- `DELETE /api/competencias/{id}` - Eliminar competencia

### Items de Factura
- `GET /api/items-factura` - Obtener todos los items de factura
- `GET /api/items-factura/{id}` - Obtener item por ID
- `GET /api/items-factura/factura/{idFactura}` - Items por factura
- `GET /api/items-factura/producto/{idProducto}` - Items por producto
- `POST /api/items-factura` - Crear nuevo item
- `PUT /api/items-factura/{id}` - Actualizar item
- `DELETE /api/items-factura/{id}` - Eliminar item

## Datos de Prueba

El proyecto incluye un archivo `data.sql` con datos de prueba que incluye:

- **4 Tipos de Pago**: Efectivo, Tarjeta de Crédito, Tarjeta de Débito, Transferencia
- **4 Personas**: Juan Pérez, María García, Carlos López, Ana Martínez
- **4 Usuarios**: Usuarios asociados a las personas con credenciales básicas
- **4 Roles**: Administrador, Vendedor, Supervisor, Cliente
- **4 Competencias**: Ventas, Administración, Contabilidad, Logística
- **5 Clasificaciones**: Electrónicos, Ropa, Hogar, Deportes, Libros
- **4 Proveedores**: Proveedores con RUC y datos de contacto
- **5 Productos**: Productos variados con diferentes precios y clasificaciones
- **4 Facturas**: Facturas de ejemplo con diferentes fechas y totales
- **4 Items de Factura**: Detalles de productos en las facturas

Los datos se cargan automáticamente al iniciar la aplicación (configuración puede variar).

## Tecnologías Utilizadas

- Spring Boot 3.5.3
- Spring Data JPA
- PostgreSQL Driver
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── org/example/trabajoclase/
│   │       ├── config/          # Configuraciones
│   │       ├── controller/      # Controladores REST
│   │       ├── entity/          # Entidades JPA
│   │       ├── repository/      # Repositorios JPA
│   │       ├── service/         # Servicios de negocio
│   │       └── TrabajoClaseApplication.java
│   └── resources/
│       ├── application.properties
│       └── data.sql
└── test/
    └── java/
        └── org/example/trabajoclase/
            └── TrabajoClaseApplicationTests.java
```

## Pruebas con Swagger

1. Iniciar la aplicación
2. Navegar a `http://localhost:8080/swagger-ui.html`
3. Probar los diferentes endpoints disponibles
4. Usar los datos de prueba incluidos para realizar operaciones CRUD

## Ejemplos de Uso

### Consultar todos los productos disponibles
```
GET /api/productos
```

### Buscar una persona por DNI
```
GET /api/personas/dni/12345678
```

### Obtener facturas de un cliente específico
```
GET /api/facturas/persona/1
```

### Filtrar productos por rango de precio
```
GET /api/productos/precio-rango?minPrecio=20&maxPrecio=100
```

### Obtener total de ventas por período
```
GET /api/facturas/total-ventas?fechaInicio=2024-01-01&fechaFin=2024-12-31
```

### Crear una nueva factura (POST)
```json
{
  "ruc": "20123456789",
  "idPersona": 1,
  "fecha": "2024-06-26",
  "idTipoPago": 1,
  "descuento": 0.0,
  "total": 1000.0
}
```

## Autor

Proyecto desarrollado para el curso de Programación.
