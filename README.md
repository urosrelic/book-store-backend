![image](https://github.com/urosrelic/book-store-frontend/assets/72343856/dc38488c-d2f0-4e84-9aff-9ee8f1eded36)

Online book library where users can buy books and see detailed information about them

## Tech Stack

**Backend:**

- Spring Boot
- MySQL

**Frontend:**

- React
- CSS
- Material UI

You can find the frontend project code [here](https://github.com/urosrelic/book-store-frontend).


## Run Locally
Make sure you have MySQL installed and running on your local machine.

Clone the project

```bash
  git clone https://github.com/urosrelic/book-store-backend.git
```

Go to the project directory

```bash
  cd my-project
```

Open the src/main/resources/application.yml file and configure your MySQL database connection settings:

```bash
  spring:
    datasource:
        url: jdbc:mysql://localhost:3306/example_db
        username: root
        password: root
    jpa:
        database-platform: org.hibernate.dialect.MySQLDialect
        show-sql: true
        hibernate:
            ddl-auto: update
```

Start the server
