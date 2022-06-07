##Highlevel Architecture overview

![image](https://user-images.githubusercontent.com/8881102/172287119-72268136-397a-46bc-ae41-5e6e7d70b89e.png)


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
