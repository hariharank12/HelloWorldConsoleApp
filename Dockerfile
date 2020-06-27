FROM openjdk:8-jdk-alpine
COPY target/HelloWorldConsoleApp-1.0-SNAPSHOT.jar /tmp/HelloWorldConsoleApp-1.0-SNAPSHOT.jar
CMD ["java","-jar","/tmp/HelloWorldConsoleApp-1.0-SNAPSHOT.jar","alamelu"]