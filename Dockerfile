FROM maven:3.8.3-openjdk-17 as build

COPY . /home/mvn/project
WORKDIR /home/mvn/project

RUN mvn package

FROM openjdk:17-jdk-alpine
RUN mkdir -p /app
COPY --from=build /home/mvn/project/target/*.jar /app/app.jar

WORKDIR /app

CMD java -jar app.jar