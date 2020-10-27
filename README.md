# Fare Evasion Reporting API
> An API to report incidents. Utilises role-based access control.

 ## Table of Contents
 
 - [About](#about)
 - [Getting Started](#getting-started)
 - [Contributing](#contributing)
 - [Contact](#contact)

---

## About
![Java](https://img.shields.io/badge/-java-brown)
![SpringBoot](https://img.shields.io/badge/-springboot-brightgreen)
![PostgreSQL](https://img.shields.io/badge/-postgresql-blue)
![GitHub issues](https://img.shields.io/github/issues/aquashi/evasion-report)
![GitHub repo size](https://img.shields.io/github/repo-size/aquashi/evasion-report)
![GitHub last commit](https://img.shields.io/github/last-commit/aquashi/evasion-report)

This API was developed in Java using Spring Boot, Spring Security, JPA, Hibernate and PostgreSQL. 
It utilises role-based access control for different types of user accounts. The API allows users to report incidents. 
Users with different privileges can also search and investigate these incidents.

---

## Getting Started

1. If you do not have PostgreSQL installed, please visit [https://www.postgresql.org/download/](https://www.postgresql.org/download/)
2. Clone the repo

    ```sh
    git clone https://github.com/aquashi/evasion-report.git
    ```

3. Setup database to match the following `application.properties` file snippet

    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/FERT?currentSchema=fert
    spring.datasource.username=postgres
    spring.datasource.password=postgres
    ```

4. Run the Maven project and the API is ready to use.

---

## Contributing

1. Fork the project
2. Create a feature branch: `git checkout -b feature-branch`
3. Commit your changes: `git commit -am 'Added new features'`
4. Push your changes: `git push origin feature-branch`
5. Create a pull request

---

## Contact

**Developer:** Aaron Quashie - aaronquashie@gmail.com

Repository Link: [https://github.com/aquashi/evasion-report](https://github.com/aquashi/evasion-report)