-- Insertar tipos de pago
INSERT INTO tipo_pago (tipo, descripcion) VALUES ('Efectivo', 'Pago en efectivo');
INSERT INTO tipo_pago (tipo, descripcion) VALUES ('Tarjeta de Crédito', 'Pago con tarjeta de crédito');
INSERT INTO tipo_pago (tipo, descripcion) VALUES ('Tarjeta de Débito', 'Pago con tarjeta de débito');
INSERT INTO tipo_pago (tipo, descripcion) VALUES ('Transferencia', 'Transferencia bancaria');

-- Insertar personas
INSERT INTO persona (nombre, apellido, dni, celular, correo) VALUES ('Juan', 'Pérez', '12345678', '987654321', 'juan.perez@email.com');
INSERT INTO persona (nombre, apellido, dni, celular, correo) VALUES ('María', 'García', '87654321', '123456789', 'maria.garcia@email.com');
INSERT INTO persona (nombre, apellido, dni, celular, correo) VALUES ('Carlos', 'López', '11223344', '555666777', 'carlos.lopez@email.com');
INSERT INTO persona (nombre, apellido, dni, celular, correo) VALUES ('Ana', 'Martínez', '44332211', '777888999', 'ana.martinez@email.com');

-- Insertar usuarios
INSERT INTO usuario (id_persona, username, password) VALUES (1, 'jperez', 'password123');
INSERT INTO usuario (id_persona, username, password) VALUES (2, 'mgarcia', 'password123');
INSERT INTO usuario (id_persona, username, password) VALUES (3, 'clopez', 'password123');
INSERT INTO usuario (id_persona, username, password) VALUES (4, 'amartinez', 'password123');

-- Insertar roles
INSERT INTO rol (rol, estado) VALUES ('Administrador', true);
INSERT INTO rol (rol, estado) VALUES ('Vendedor', true);
INSERT INTO rol (rol, estado) VALUES ('Supervisor', true);
INSERT INTO rol (rol, estado) VALUES ('Cliente', true);

-- Insertar competencias
INSERT INTO competencia (nombre, descripcion) VALUES ('Ventas', 'Competencia en ventas y atención al cliente');
INSERT INTO competencia (nombre, descripcion) VALUES ('Administración', 'Competencia en tareas administrativas');
INSERT INTO competencia (nombre, descripcion) VALUES ('Contabilidad', 'Competencia en manejo contable');
INSERT INTO competencia (nombre, descripcion) VALUES ('Logística', 'Competencia en gestión logística');

-- Insertar clasificaciones
INSERT INTO clasificacion (grupo) VALUES ('Electrónicos');
INSERT INTO clasificacion (grupo) VALUES ('Ropa');
INSERT INTO clasificacion (grupo) VALUES ('Hogar');
INSERT INTO clasificacion (grupo) VALUES ('Deportes');
INSERT INTO clasificacion (grupo) VALUES ('Libros');

-- Insertar proveedores
INSERT INTO proveedores (ruc, telefono, pais, correo, moneda) VALUES ('20123456789', '01-2345678', 'Perú', 'proveedor1@email.com', 'PEN');
INSERT INTO proveedores (ruc, telefono, pais, correo, moneda) VALUES ('20987654321', '01-8765432', 'Perú', 'proveedor2@email.com', 'PEN');
INSERT INTO proveedores (ruc, telefono, pais, correo, moneda) VALUES ('20111222333', '01-1112223', 'Perú', 'proveedor3@email.com', 'PEN');
INSERT INTO proveedores (ruc, telefono, pais, correo, moneda) VALUES ('20444555666', '01-4445556', 'Perú', 'proveedor4@email.com', 'PEN');

-- Insertar productos
INSERT INTO producto (stock, precio_unitario, unidad, id_clasificacion, id_proveedor, iva) VALUES (100, 850.00, 'Unidad', 1, 1, true);
INSERT INTO producto (stock, precio_unitario, unidad, id_clasificacion, id_proveedor, iva) VALUES (50, 45.00, 'Unidad', 2, 2, false);
INSERT INTO producto (stock, precio_unitario, unidad, id_clasificacion, id_proveedor, iva) VALUES (200, 25.00, 'Unidad', 3, 3, false);
INSERT INTO producto (stock, precio_unitario, unidad, id_clasificacion, id_proveedor, iva) VALUES (75, 120.00, 'Unidad', 4, 4, true);
INSERT INTO producto (stock, precio_unitario, unidad, id_clasificacion, id_proveedor, iva) VALUES (150, 35.00, 'Unidad', 5, 1, false);

-- Insertar facturas
INSERT INTO factura (ruc, id_persona, fecha, id_tipo_pago, descuento, total) VALUES ('20123456789', 1, '2024-01-15', 1, 0.00, 850.00);
INSERT INTO factura (ruc, id_persona, fecha, id_tipo_pago, descuento, total) VALUES ('20123456789', 2, '2024-01-16', 2, 10.00, 80.00);
INSERT INTO factura (ruc, id_persona, fecha, id_tipo_pago, descuento, total) VALUES ('20123456789', 3, '2024-01-17', 1, 0.00, 240.00);
INSERT INTO factura (ruc, id_persona, fecha, id_tipo_pago, descuento, total) VALUES ('20123456789', 4, '2024-01-18', 3, 5.00, 115.00);

-- Insertar items de factura
INSERT INTO item_factura (id_factura, id_producto, cantidad, precio, subtotal) VALUES (1, 1, 1, 850.00, 850.00);
INSERT INTO item_factura (id_factura, id_producto, cantidad, precio, subtotal) VALUES (2, 2, 2, 45.00, 90.00);
INSERT INTO item_factura (id_factura, id_producto, cantidad, precio, subtotal) VALUES (3, 4, 2, 120.00, 240.00);
INSERT INTO item_factura (id_factura, id_producto, cantidad, precio, subtotal) VALUES (4, 5, 4, 35.00, 140.00);
