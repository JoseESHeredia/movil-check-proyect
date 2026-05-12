-- 1. Catálogo Maestro de Equipos (Atributos comparables)
CREATE TABLE Equipos (
    id_equipo INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(50),
    modelo_comercial VARCHAR(100),
    codigo_tecnico VARCHAR(50),
    procesador VARCHAR(100),
    memoria_ram INT,           -- Para restar/comparar
    almacenamiento INT,        -- Para restar/comparar
    camara INT,
    bateria INT
);

-- 2. Gestión de Usuarios y SSO
CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    url_foto VARCHAR(255),
    token_push VARCHAR(255),
    estado_cuenta TINYINT DEFAULT 1
);

-- 3. Preferencias (Alimenta franja negra y barra lateral)
CREATE TABLE Preferencias_Usuario (
    id_preferencia INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    id_equipo_actual INT,
    id_equipo_interes INT,
    alerta_precio_objetivo DECIMAL(10,2),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_equipo_actual) REFERENCES Equipos(id_equipo),
    FOREIGN KEY (id_equipo_interes) REFERENCES Equipos(id_equipo)
);

-- 4. Gestión de Tiendas (Apartado Admin)
CREATE TABLE Tiendas (
    id_tienda INT PRIMARY KEY AUTO_INCREMENT,
    nombre_tienda VARCHAR(100),
    sitio_web_base VARCHAR(255),
    tipo VARCHAR(50), -- Retail u Operadora
    url VARCHAR(255)
);

-- 5. Vitrina de Ofertas del Día
CREATE TABLE Ofertas_Dia (
    id_oferta INT PRIMARY KEY AUTO_INCREMENT,
    id_equipo INT,
    id_tienda INT,
    precio_contado DECIMAL(10,2),
    precio_plan DECIMAL(10,2),
    nombre_plan VARCHAR(100),
    url_directa_compra VARCHAR(255),
    fecha_actualizacion DATETIME,
    FOREIGN KEY (id_equipo) REFERENCES Equipos(id_equipo),
    FOREIGN KEY (id_tienda) REFERENCES Tiendas(id_tienda)
);

-- 6. Monitoreo (Métricas para el Admin)
CREATE TABLE Log_Monitoreo (
    id_log INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATETIME,
    cantidad_registros INT,
    latencia_ms INT,
    estado_proceso VARCHAR(50)
);
