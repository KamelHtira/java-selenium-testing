# Selenium Web Automation Tests for automobile.tn

This project contains automated UI tests for the automobile marketplace [automobile.tn](https://www.automobile.tn), written in Java using JUnit and Selenium. The tests are run against a Selenium Grid using `RemoteWebDriver`.

---

## 🧪 Features Tested

- Performing a login in **User Login**
- Filtering **Occasion Cars** by body type and manual gear and verifying if we get results.
- Navigating to **Prix du Neuf** and selecting a Random car brand then go back and select specific car brand and model
- Navigating to **Mon espace** and logging out 

---

## 📂 Project Structure

```text
.
├── AutomobileTest.java         # Main test class with JUnit tests
├── BasePage.java               # Shared page methods and utilities
├── LoginPage.java              # Page Object for login page
├── MonEspacePage.java          # Page Object for user profile and logout
├── OccasionPage.java           # Page Object for used car filters
├── PrixDuNeufPage.java         # Page Object for new car selection
├── README.md                   # This file
