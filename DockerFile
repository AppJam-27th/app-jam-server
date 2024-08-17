FROM openjdk:17
ARG JAR_FILE=build/libs/27th-appjam-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} appjam.jar
ENTRYPOINT ["java","-jar","/appjam.jar"]
