# 4i Solution - Patient Case management project

This repository contains Selenium test scripts for automated browser testing.

## Overview

In the delivery of anaesthesiology service in Singapore, patient medical history and medications currently administered has to be collected before the day of surgery and the patient has to provide further medical test results if required. The patient has to be informed of the procedure of anaesthesia and allowed to choose different types of anaesthesia. Before the day of the operation, patient has to be reminded to stop certain medications at the predetermined time, and also follow other preparation steps as determined by the anaesthesiologist.  

 

A pre-determined checklist of items will be reviewed with the patient on the day of operation before the operation begins. After the operation is performed, another pre-determined checklist of items will be reviewed with the patient. After the day of operation, a post operation survey will be performed. 

## 🚀 Features

- 🔍 Cross-browser testing (Chrome, Firefox, Edge)
- 🧪 TestNG integration
- 📸 Automatic screenshot capture on failure - (Development inprogress)
- 📊 Test report generation (ChainTest Report) - (Development inprogress)
- 🔁 Data-driven testing (Excel/CSV/JSON support)
- ⚙️ Configurable with `config.properties`
- ✅ CI/CD Ready (GitHub Actions)

# Selenium Automation Framework

This repository contains a Selenium-based automation framework built for automating web application testing. It is designed to be scalable, maintainable, and easy to use for QA teams and developers.


## 📁 Project Structure

4isolution/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   └── TestBase.java               # Base test setup (WebDriver init, teardown, etc.)
│   │   │   │
│   │   │   ├── config/
│   │   │   │   └── appconfig.properties        # Configuration file (e.g., browser, URL, credentials)
│   │   │   │
│   │   │   └── pages/
│   │   │       ├── Admin_Login1.java           # Testcases for Admin Login
│   │   │       ├── Doctor_creation_2.java      # Testcases for Doctor Creation
│   │   │       ├── Patient_Case_3.java         # Testcases for Patient Case
│   │   │       ├── Survey_Creation_4.java      # Testcases for Survey Creation
│   │   │       └── Patient_survey_5.java       # Testcases for Patient Survey
│   │   │
│   │   └── resources/
│   │       └── testng.xml                      # TestNG configuration file
│
│   └── test/
│       ├── java/
│       │   └── Test/
│       │       ├── Admin_login_test.java               # Individual TestNG for Admin Login
│       │       ├── Doctor_creation_test_2.java         # Individual TestNG for Doctor Creation
│       │       ├── Patient_Case_Test_3.java            # Individual TestNG for Patient Case
│       │       ├── survey_Creation_Test_4.java         # Individual TestNG for Survey Creation
│       │       └── Patient_survey_test_5.java          # Individual TestNG for Patient Survey
│       │
│       └── resources/
│           └── uploading_file/                         # Folder to store test upload files
│
├── pom.xml                       # Maven build configuration file
├── README.md                     # Project documentation

---

## 🛠️ Getting Started

### Prerequisites

- Java (8 or higher)
- Maven
- ChromeDriver/firefoxdriver/edgedriver (update matching your browser version)
- IDE like IntelliJ or Eclipse (Eclipse preferred)

### Installation

1. **Clone the repository**
   ```bash
   git clone https:[//github.com/your-username/selenium-automation.git](https://github.com/Wilson1998180/4iautomation.git)
   cd selenium-automation

---

## 🛠️ Steps to run (Navigation)

1. Open "Eclipse > src/main/resources" 
2. Open testng.xml
3. Click "Run as TestNg" 



