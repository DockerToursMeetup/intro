FROM tutum/curl:trusty
MAINTAINER DockerMeetup DockerMeetup.com  "Docker@Meetup.com"

LABEL SERVICE="awesome-app"

COPY ./script/load.sh /elasticsearch/load.sh


WORKDIR /elasticsearch/

ENTRYPOINT ["./load.sh"]

