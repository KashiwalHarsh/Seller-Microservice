````markdown
# ⚡ EV Charging Seller Microservice

This is the **Seller Microservice** for an EV Charging Station Locator platform. It handles all operations related to **Sellers**, their hosted **Swappable Batteries**, **Chargers**, **Charging Stations**, and **User Reviews**.

---

## 🧩 Modules Covered

- Seller Management (CRUD)
- Battery Hosting and Availability
- Charger Hosting and Power Details
- Charging Station Location & Info
- Review System (for batteries, chargers, sellers, stations)

---

## ⚙️ Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **ModelMapper**
- **Lombok**
- **REST APIs**
- **Maven**

---

## 🗂️ Project Structure

```bash
src/main/java/com/infy/sellerMs/
├── controller/          # REST Controllers
├── service/             # Interfaces
├── service/impl/        # Service Implementations
├── repository/          # JPA Repository Interfaces
├── entity/              # Entity Models
├── dto/                 # DTOs for external communication
├── config/              # ModelMapper configuration
└── SellerMsApplication.java
````

---

## 📦 API Endpoints

### ✅ Seller

| Method | Endpoint            | Description       |
| ------ | ------------------- | ----------------- |
| POST   | `/api/sellers`      | Create new seller |
| GET    | `/api/sellers`      | List all sellers  |
| GET    | `/api/sellers/{id}` | Get seller by ID  |

### ✅ Battery

| Method | Endpoint              | Description           |
| ------ | --------------------- | --------------------- |
| POST   | `/api/batteries`      | Add swappable battery |
| GET    | `/api/batteries`      | List all batteries    |
| GET    | `/api/batteries/{id}` | Get battery by ID     |

### ✅ Charger

| Method | Endpoint             | Description       |
| ------ | -------------------- | ----------------- |
| POST   | `/api/chargers`      | Add charger       |
| GET    | `/api/chargers`      | List all chargers |
| GET    | `/api/chargers/{id}` | Get charger by ID |

### ✅ Charging Station

| Method | Endpoint             | Description          |
| ------ | -------------------- | -------------------- |
| POST   | `/api/stations`      | Add charging station |
| GET    | `/api/stations`      | List all stations    |
| GET    | `/api/stations/{id}` | Get station by ID    |

### ✅ Review

| Method | Endpoint       | Description                        |
| ------ | -------------- | ---------------------------------- |
| POST   | `/api/reviews` | Post a review                      |
| GET    | `/api/reviews` | Get reviews by target (via params) |

---

## 📄 Sample JSON Payloads

### 🚀 POST `/api/sellers`

```json
{
  "name": "EV Fast Pvt Ltd",
  "gstNumber": "27AABCU9603R1Z2",
  "contactInfo": {
    "email": "evfast@example.com",
    "phone": "9876543210"
  },
  "rating": 4.6
}
```

### 🔋 POST `/api/batteries`

```json
{
  "type": "Li-ion",
  "capacity": 2.5,
  "connectorType": "Type-A",
  "companyName": "BatteryCo",
  "age": 6,
  "quantity": 20,
  "pricePerBattery": 250.00,
  "latitude": 12.9716,
  "longitude": 77.5946,
  "sellerId": 1,
  "rating": 4.2
}

3. Set credentials in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ev_charging
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

---

## 🧪 Testing

Use Postman or Swagger UI to test the APIs.

You can generate Swagger using:

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.5.0</version>
</dependency>
```

Access it at: `http://localhost:8080/swagger-ui.html`

---

## 🚀 Run the Project

```bash
mvn clean install
mvn spring-boot:run
```

---

## 📁 Future Improvements

* JWT Authentication
* Booking microservice for slot-based charger reservations
* Prometheus + Grafana monitoring
* Dockerized deployment
---

Let me know if you'd like:
- A Swagger/OpenAPI YAML file
- Dockerfile for MySQL or this microservice
- Frontend integration README section
```
