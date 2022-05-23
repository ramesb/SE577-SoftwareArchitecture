
FROM maven:3.8.2-jdk-8
WORKDIR /SE577-SoftwareArchitecture/spring-boot-h2-database-crud
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run
EXPOSE 8080
