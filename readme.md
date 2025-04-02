# API de Gestión de Estudiantes

Este proyecto es una API REST desarrollada con **Spring Boot**, que permite gestionar estudiantes a través de un CRUD (Crear, Leer, Actualizar y Eliminar). Los datos se almacenan en memoria utilizando un `Repository`, sin necesidad de una base de datos.

## Características
- Crear un nuevo estudiante
- Obtener todos los estudiantes
- Obtener un estudiante por su ID
- Actualizar un estudiante existente
- Eliminar un estudiante por su ID

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Lombok** (para reducir código repetitivo)

## Requisitos Previos
Antes de clonar el proyecto, asegúrate de tener instalado:
- **Java 17 o superior**
- **Maven**
- **IDE** como IntelliJ IDEA, Spring Tool Suite o VS Code
- **Postman** (opcional, para probar la API)

## Instalación y Ejecución

1. Clona el repositorio:
   ```sh
   git clone https://github.com/leaox77/Crud-Estudiantes.git
   ```

2. Ingresa al directorio del proyecto:
   ```sh
   cd Crud-Estudiantes
   ```

3. Compila y ejecuta el proyecto con Maven:
   ```sh
   mvn spring-boot:run
   ```

4. La API estará disponible en:
   ```sh
   http://localhost:8082/api/students
   ```

## Uso de la API
Puedes probar los endpoints utilizando **Postman** o `cURL`.

### 1. Crear un estudiante
- **Método:** `POST`
- **Endpoint:** `/api/students`
- **Respuesta esperada:** Código `201 Created`

### 2. Obtener todos los estudiantes
- **Método:** `GET`
- **Endpoint:** `/api/students`
- **Respuesta esperada:** Lista de estudiantes con código `200 OK`

### 3. Obtener un estudiante por ID
- **Método:** `GET`
- **Endpoint:** `/api/students/{id}`
- **Respuesta esperada:** Datos del estudiante con código `200 OK` o `404 Not Found` si no existe

### 4. Actualizar un estudiante
- **Método:** `PUT`
- **Endpoint:** `/api/students/{id}`
- **Respuesta esperada:** Datos actualizados con código `200 OK` o `404 Not Found`

### 5. Eliminar un estudiante
- **Método:** `DELETE`
- **Endpoint:** `/api/students/{id}`
- **Respuesta esperada:** Código `204 No Content` o `404 Not Found`

## Autor
- **Leandro Eduardo Chavez Fernandez**
- **Usuario de GitHub: leaox77**

