FROM openjdk:11
ADD build/libs/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]