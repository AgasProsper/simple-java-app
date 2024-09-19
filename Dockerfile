FROM eclipse-temurin:17

WORKDIR /app

COPY ./target/*.jar /app/package.jar

EXPOSE 8080

RUN apt install python

CMD [ "java","-jar","/app/package.jar" ]