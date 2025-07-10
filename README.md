# 🏥 Gestión de Citas Médicas - Spring Boot + H2

Este es un proyecto de backend desarrollado con **Java 17** y **Spring Boot 3.5**, que simula un sistema de gestión de citas médicas. Incluye las funcionalidades básicas para manejar **pacientes**, **médicos** y **citas**.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot (Web, Data JPA, Validation, Security)
- Base de datos en memoria H2
- Lombok
- Swagger (documentación de API REST)
- Maven

---

## 📂 Estructura de funcionalidades

### ✅ Pacientes
- Crear, listar, actualizar y eliminar pacientes

### ✅ Médicos
- Crear, listar, actualizar y eliminar médicos

### ✅ Citas médicas
- Crear cita asignando paciente y médico
- Listar todas las citas
- Eliminar cita

---

## 🛠 Configuración

Este proyecto usa base de datos H2 en memoria. No requiere configuración extra.

Accede a la consola H2 desde:

http://localhost:8080/h2-console

---

## 🔎 Documentación Swagger

La API REST está documentada con Swagger:

http://localhost:8080/swagger-ui.html


---

## 📦 Instalación

```bash
git clone https://github.com/Emmanuel30412/gestion-clinica.git
cd gestion-clinica
./mvnw spring-boot:run