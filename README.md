# Scientific Calculator CI/CD Project

## Scientific Functions
The calculator supports the following operations:
* **Square Root ($\sqrt{x}$):** Calculates the square root of a given number.
* **Factorial ($x!$):** Computes the factorial of an integer.
* **Natural Logarithm ($\ln(x)$):** Calculates the base-e logarithm.
* **Power Function ($x^b$):** Raises a base to a specified exponent.

## Technology Stack
* **Language**: Java 17. 
* **Build Tool**: Maven. 
* **Testing**: JUnit 4. 
* **CI/CD**: Jenkins with GitHub Webhooks. 
* **Containerization**: Docker. 
* **Deployment**: Ansible.

## CI/CD Pipeline Stages
The automation is defined in the `Jenkinsfile` and follows these steps:
1. **Checkout**: Pulls the source code from the specific GitHub repository branch (`main`) using the `git` command.
2. **Build & Test**: Compiles the application and runs unit tests in `ScientificCalcTest.java` using Maven. 
3. **Docker Build**: Creates a Docker image tagged `suchirokram/scientific_calculator:latest`. 
4. **Push**: Uploads the image to Docker Hub using secure credentials. 
5. **Ansible Deploy**: Executes a playbook to pull the latest image and run the container in an interactive-detached (`-dit`) state on the localhost. 
6. **Notifications**: Sends success or failure emails to `noiropx59@gmail.com`.

## Local Execution & Verification
To verify the application status on the host machine:
* **Check Logs**:
`docker logs calculator_service`
* **Interactive Test**:
`docker exec -it calculator_service java -jar app.jar`

## Project Structure
```
ScientificCalculator/
│
├── src/
│   ├── main/java/org/example/
│   │       ScientificCalculator.java
│   │
│   └── test/java/
│           ScientificCalcTest.java
│
├── pom.xml
├── Jenkinsfile
├── Dockerfile
├── inventory.ini
├── ansbldeploy.yml
├── Calculator.log
└── README.md
```

## Repository Links
* **GitHub**: https://github.com/Su-ok/MT2025124-SPEMiniProject.
* **Docker Hub**: https://hub.docker.com/r/suchirokram/scientific_calculator/tags.