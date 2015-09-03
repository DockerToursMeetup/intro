From elasticsearch:1.7.1
MAINTAINER DockerMeetup DockerMeetup.com  "Docker@Meetup.com"
LABEL SERVICE="awesome-app"

VOLUME ["/usr/share/elasticsearch/data"]

COPY  ./conf/elasticsearch.yml /usr/share/elasticsearch/config/elasticsearch.yml
COPY  ./conf/logging.yml /usr/share/elasticsearch/config/logging.yml
