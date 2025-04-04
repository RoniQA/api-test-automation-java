# API Test Automation Project

This project provides a structure for automating REST API tests using **Java**, **JUnit 5**, and **RestAssured**.

## 📦 Project Structure

- `src/test/java` - Organized test cases per feature/module (e.g., `user`, `product`).
- `src/main/java` - Utility classes like configuration readers.
- `config/config.properties` - Centralized configuration file for environment values.
- `BaseTest.java` - Common setup/teardown logic shared across test classes.
- `build.gradle.kts` - Gradle Kotlin DSL build file.

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Gradle 8+
- IntelliJ IDEA (recommended)

### Setup
```bash
# Clone the repository
git clone https://github.com/RoniQA/api-test-automation-java.git
cd api-test-automation-java

# Run tests
gradlew clean test
```

## 🧪 Running Tests
```bash
./gradlew clean test
```

## 📊 Reports
Integrate with tools like **Allure** or **ExtentReports** for advanced reporting.

## 📌 Technologies Used
- Java 17
- Gradle Kotlin DSL
- JUnit 5
- RestAssured

## 🙌 Contributing
Feel free to fork this repo and contribute with new features, bug fixes, or improvements.