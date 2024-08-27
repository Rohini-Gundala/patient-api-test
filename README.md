# Patient API Test Suite

This project contains automated API tests for the Patient API using Java, RestAssured, and TestNG. The tests are designed to verify the integrity and correctness of the API by checking various aspects like response status codes, presence of required fields, and data validation.

## Dependencies

This project uses the following dependencies:

- **RestAssured**: For API testing
- **TestNG**: As the test framework
- **Hamcrest**: For assertion matchers

### Maven Dependency Setup

Ensure you have the following dependencies in your `pom.xml` file:

```xml
<dependencies>
    <!-- RestAssured for API testing -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.0</version>
    </dependency>

    <!-- TestNG for test framework -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>

    <!-- JSON Path for parsing JSON responses -->
    <dependency>
        <groupId>com.jayway.jsonpath</groupId>
        <artifactId>json-path</artifactId>
        <version>2.7.0</version>
    </dependency>

    <!-- Hamcrest for matchers -->
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest</artifactId>
        <version>2.2</version>
    </dependency>
</dependencies>
```

## Setup Instructions

Clone the Repository

```bash
git clone https://github.com/yourusername/patient-api-tests.git
cd patient-api-tests
```

Build the Project

Ensure Maven is installed, then run:

```bash
mvn clean install
```

## Configure the Base URL

The base URL for the API is configurable via a system property. By default, it is set to:

```ruby
https://apimgmt-dev-crisp.azure-api.net/patients/query/
```
To change it, pass the baseUrl parameter when running the tests.

## Running the Tests
You can run the TestNG tests directly from the command line using Maven:

```bash
mvn test -DbaseUrl=https://your-api-url.com
```

To run a specific test class:

```bash
mvn -Dtest=PatientApiTests test
```
