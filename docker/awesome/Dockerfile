FROM java:8-jre
MAINTAINER DockerMeetup DockerMeetup.com  "Docker@Meetup.com"

LABEL SERVICE="awesome-app"

RUN mkdir -p /app/logs

COPY conf/prod-docker.yml /app/prod.yml 
COPY target/awesome-app-1.0-SNAPSHOT.jar /app/awesome-prod.jar

EXPOSE 8080
EXPOSE 8081

WORKDIR /app

ENTRYPOINT ["java" ,"-jar", "awesome-prod.jar", "server", "prod.yml" ]
