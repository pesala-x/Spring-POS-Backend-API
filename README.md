<h1 align="center" id="title">Spring POS Backend API</h1>

<p id="description">The Spring POS Backend API offers a powerful and scalable solution for managing retail operations efficiently. Developed with the Spring Framework, this API streamlines customer, item, and order management. It leverages Spring Data JPA with Hibernate ORM for seamless database interactions and supports MySQL as the backend database. Designed for small to medium-sized businesses, it provides a robust platform for real-time sales transactions, inventory tracking, and smooth integration with any front-end interface.</p>

---

<h2>✨ Key Features</h2>

This project offers the following key functionalities:

- Manage customers, items, and orders effortlessly.  
- Real-time inventory tracking to maintain stock levels.  
- Create orders with multiple payment methods (Cash, Card, or Mobile Wallets).  
- Robust data handling via Hibernate ORM and Spring Data JPA.  
- Exception handling with validation powered by Spring Validator.  
- RESTFull endpoints with JSON response structure for easy integration.

---

<h2>🚀 Installation Guide</h2>

<p>Follow these steps to set up the project:</p>

**Step 1:** Clone the repository:  
```bash
git clone https://github.com/pesala-x/Spring-POS-Backend-API.git
```

**Step 2:** Build the application using Maven:
```bash
mvn clean install
```

**Step 3:** Run the project. By default, the server will be accessible at:
```
http://localhost:8080
```

---

<h2>📚 API Endpoints Overview</h2>

<h3>📂 Customer Endpoints</h3>

- **GET** `/customer` - Fetch all customers.
- **POST** `/customer` - Add a new customer.
- **PUT** `/customer` - Update an existing customer.
- **DELETE** `/customer/{id}` - Remove a customer by ID.

<h3>📦 Item Endpoints</h3>

- **GET** `/item` - Retrieve all items.
- **POST** `/item` - Create a new item.
- **PUT** `/item` - Update item details.
- **DELETE** `/item/{id}` - Delete an item by ID.

<h3>🛒 Order Endpoints</h3>

- **POST** `/order` - Place a new order.

---

<h2>⚙️ Built With</h2>

This project leverages the following technologies:

- **Spring Framework** - Backend development with Java.
- **Hibernate ORM** - Object-relational mapping for database operations.
- **Spring Data JPA** - Repository abstraction layer.
- **MySQL** - Relational database.
- **Lombok** - Reduces boilerplate code with annotations.

---

<h2>📖 API Documentation</h2>

For a detailed overview of the API with example requests and responses, visit the [API Documentation](https://documenter.getpostman.com/view/35385497/2sAXxV5puH).

---

<h2>🛡️ License</h2>

This project is distributed under the MIT License. See the [LICENSE](./LICENSE) file for more details.

------
