# Mutabaah Backend

## Project Setup

To set up this project, follow these steps:

1. Rename the file `application.properties.example` to `application.properties`.

2. Open the `application.properties` file and update the following configuration values to match your environment:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:port/database_name
   spring.datasource.username=your_postgres_username
   spring.datasource.password=your_postgres_password
   spring.jpa.generate-ddl=true
