FROM eclipse-temurin:21-jre-alpine

COPY build/libs/*.jar /opt/app/application.jar

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/application.jar"]