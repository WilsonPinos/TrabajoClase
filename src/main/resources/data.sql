-- Script para insertar datos de prueba en la base de datos bd_sistema_facturacion

-- Insertar tipos de pago
INSERT INTO tipo_pago (tipo, descripcion) VALUES 
('Efectivo', 'Pago en efectivo'),
('Tarjeta de Crédito', 'Pago con tarjeta de crédito'),
('Tarjeta de Débito', 'Pago con tarjeta de débito'),
('Transferencia', 'Transferencia bancaria')
ON CONFLICT DO NOTHING;

-- Insertar personas
INSERT INTO persona (nombre, apellido, dni, celular, correo) VALUES 
('Juan', 'Pérez', '12345678', '987654321', 'juan.perez@email.com'),
('María', 'García', '87654321', '123456789', 'maria.garcia@email.com'),
('Carlos', 'López', '11223344', '555666777', 'carlos.lopez@email.com'),
('Ana', 'Martínez', '44332211', '777888999', 'ana.martinez@email.com')
ON CONFLICT (dni) DO NOTHING;

-- Insertar usuarios
INSERT INTO usuario (id_persona, username, password) VALUES 
(1, 'jperez', 'password123'),
(2, 'mgarcia', 'password123'),
(3, 'clopez', 'password123'),
(4, 'amartinez', 'password123')
ON CONFLICT (username) DO NOTHING;

-- Insertar roles
INSERT INTO rol (rol, estado) VALUES 
('Administrador', true),
('Vendedor', true),
('Supervisor', true),
('Cliente', true)
ON CONFLICT DO NOTHING;

-- Insertar competencias
INSERT INTO competencia (nombre, descripcion) VALUES 
('Ventas', 'Competencia en ventas y atención al cliente'),
('Administración', 'Competencia en tareas administrativas'),
('Contabilidad', 'Competencia en manejo contable'),
('Logística', 'Competencia en gestión logística')
ON CONFLICT (nombre) DO NOTHING;

-- Insertar clasificaciones
INSERT INTO clasificacion (grupo) VALUES 
('Electrónicos'),
('Ropa'),
('Hogar'),
('Deportes'),
('Libros')
ON CONFLICT DO NOTHING;

-- Insertar proveedores
INSERT INTO proveedores (ruc, telefono, pais, correo, moneda) VALUES 
('20123456789', '01-2345678', 'Perú', 'proveedor1@email.com', 'PEN'),
('20987654321', '01-8765432', 'Perú', 'proveedor2@email.com', 'PEN'),
('20111222333', '01-1112223', 'Perú', 'proveedor3@email.com', 'PEN'),
('20444555666', '01-4445556', 'Perú', 'proveedor4@email.com', 'PEN')
ON CONFLICT (ruc) DO NOTHING;

-- Insertar productos
INSERT INTO producto (stock, precio_unitario, unidad, id_clasificacion, id_proveedor, iva) VALUES 
(100, 850.00, 'Unidad', 1, 1, true),
(50, 45.00, 'Unidad', 2, 2, false),
(200, 25.00, 'Unidad', 3, 3, false),
(75, 120.00, 'Unidad', 4, 4, true),
(150, 35.00, 'Unidad', 5, 1, false)
ON CONFLICT DO NOTHING;

-- Insertar facturas
INSERT INTO factura (ruc, id_persona, fecha, id_tipo_pago, descuento, total) VALUES 
('20123456789', 1, '2024-01-15', 1, 0.00, 850.00),
('20123456789', 2, '2024-01-16', 2, 10.00, 80.00),
('20123456789', 3, '2024-01-17', 1, 0.00, 240.00),
('20123456789', 4, '2024-01-18', 3, 5.00, 115.00)
ON CONFLICT DO NOTHING;

-- Insertar items de factura
INSERT INTO item_factura (id_factura, id_producto, cantidad, precio, subtotal) VALUES 
(1, 1, 1, 850.00, 850.00),
(2, 2, 2, 45.00, 90.00),
(3, 4, 2, 120.00, 240.00),
(4, 5, 4, 35.00, 140.00)
ON CONFLICT DO NOTHING;
