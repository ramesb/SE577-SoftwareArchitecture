<h2>SE577 Software Architecture</h2>
<h3>proj-release-4</h3>

# Commands to execute for docker spring application
# Docker build
>docker build -t spring-boot:1
# verify Docker image
>docker images | grep spring-boot

# Docker Run

>docker run -d --name spring-boot -p 8080:8080 spring-boot:1

# Spring boot integration with Github.
application.properties requires accessToken
