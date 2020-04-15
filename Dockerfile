FROM adoptopenjdk:11-jre-openj9
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "/app.jar"]