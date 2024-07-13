# Account Service

## Project Overview

This project provides essential functionality for managing accounts using Spring Boot and JPA (Java Persistence API). It ensures robust handling of account operations with transactional support.

### Features

- **Add Account:** Method to add a new account to the repository.
- **Get Account:** Retrieves an account by its unique ID, handling exceptions if the account does not exist.
- **Edit Account:** Updates an existing account's details based on provided data.
- **Delete Account:** Removes an account from the repository, ensuring data integrity and handling exceptions.
- **Get Accounts:** Retrieves a list of all accounts stored in the repository.

### Technologies Used

- **Spring Framework:** Utilizes Spring's `@Service` and `@Autowired` annotations for dependency injection and service management.
- **Spring Data JPA:** Interacts with the database through JPA repositories (`AccountRepository`) for persistent storage and retrieval.
- **Transactional Management:** Ensures atomicity and consistency of operations with `@Transactional` annotation.
- **Exception Handling:** Custom exception handling (`NoSuchResourceException`) for gracefully managing errors related to resource absence.

### Purpose

This project serves as a foundational component for applications requiring secure and efficient management of account-related data. It integrates seamlessly with Spring Boot applications, leveraging its powerful features for enterprise-grade solutions.
