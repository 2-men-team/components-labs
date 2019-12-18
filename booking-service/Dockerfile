FROM openjdk:latest

ADD target/backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9093

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
