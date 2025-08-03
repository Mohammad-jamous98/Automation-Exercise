# 🧪 Selenium Test Automation Framework - AutomationExercise.com

This project is a complete Selenium Test Automation framework designed for the website [AutomationExercise.com](https://www.automationexercise.com). It covers real-world eCommerce scenarios including registration, login, product search, cart management, and checkout — powered with dynamic test data from a MySQL database.

---

## 📁 Project Structure

```
src/
├── Bases/
│   └── BaseTest.java         # Common test setup and teardown
├── Pages/
│   ├── LoginPage.java        # Page Object for Login
│   ├── SignupPage.java       # Page Object for Signup
│   ├── ProductsPage.java     # Page Object for Products
│   ├── PaymentPage.java      # Page Object for Checkout/Payment
├── Tests/
│   ├── LoginTest.java        # Login test using DB data
│   ├── SignupTest.java       # Registration test using DB data
│   ├── ProductSearchTest.java# Product search and cart validation
│   └── CheckoutTest.java     # Full checkout flow test
└── Utils/
    └── DatabaseUtils.java    # Connects to DB and fetches test data
```

---

## 🧰 Tech Stack

- **Language:** Java
- **Frameworks:** Selenium WebDriver, TestNG
- **Design Pattern:** Page Object Model (POM)
- **Database:** MySQL (with JDBC)
- **Build Tool:** Maven
- **Test Execution:** TestNG
- **Others:** WebDriverManager, PageFactory

---

## 🔌 Prerequisites

- Java 11 or higher
- Maven
- MySQL (Sample data in `classicmodels` or similar)
- ChromeDriver (managed by WebDriverManager)
- Eclipse / IntelliJ

---

## ⚙️ Configuration

1. **Database Setup:**

   Make sure your MySQL server is running and contains a `signup_data` or `customers` table with proper user data.

2. **DatabaseUtils.java**  
   Configure the DB connection:

```java
String url = "jdbc:mysql://localhost:3306/classicmodels";
String username = "root";
String password = "your_password";
```

---

## 🚀 How to Run

1. Clone the repository:

```bash
git clone https://github.com/your_username/Selenium-Automation-Framework.git
```

2. Open project in Eclipse/IntelliJ.

3. Run specific tests via `TestNG` annotations:

```bash
Right-click → Run as → TestNG Test
```

4. You can also group tests into a suite using `testng.xml`.

---

## ✅ Covered Scenarios

- User Signup (Data-driven from DB)
- User Login
- Product Search and Add to Cart
- Cart Validation
- Checkout and Payment
- Data assertions and error validation

---

## 📸 Sample Screenshot

> Screenshots are saved upon failure inside `/screenshots` folder (optional enhancement).

---

## 🤝 Contribution

Feel free to fork and extend this project — add parallel execution, logging, or CI pipelines.

---

## 🧑‍💻 Author

**Mohammad Jamous**  
QA Engineer & Automation Enthusiast  
[LinkedIn](https://www.linkedin.com/in/mohammad-jamous998/)

---

## 📄 License

This project is for educational and demonstration purposes.
