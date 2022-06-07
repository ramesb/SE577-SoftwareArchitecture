## Highlevel Component Diagram

![image](https://user-images.githubusercontent.com/8881102/172287119-72268136-397a-46bc-ae41-5e6e7d70b89e.png)

## Implementation
```
- Spring Boot exports REST Apis using Spring Web MVC & interacts with Github API using retrofit2 client.
- Vue Client sends HTTP Requests and retrieve HTTP Responses using axios, shows data on the components. 
- Vue Router for navigating to pages.
```

## Project setup
```
npm install
```
### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```
Commands to execute for docker spring application
Docker build
docker build -t spring-boot:1

verify Docker image
docker images | grep spring-boot

Docker Run
docker run -d --name spring-boot -p 8080:8080 spring-boot:1

## Technology
Java 1.8
Spring Boot 2.4 (with Spring Web MVC, Spring Data JPA)
Maven 3.6.1
Vue3
Retrofit2
