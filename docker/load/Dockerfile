FROM tutum/curl:trusty
MAINTAINER DockerMeetup DockerMeetup.com  "Docker@Meetup.com"


COPY ./script/load.sh /elasticsearch/load.sh


WORKDIR /elasticsearch/

ENTRYPOINT ["./load.sh"]

