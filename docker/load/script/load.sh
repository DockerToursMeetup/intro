#!/bin/bash
PATH_ELASTICSEARCH_DATA=/usr/share/elasticsearch/data/elasticsearch-prod/nodes/0/indices

if [ ! -d $PATH_ELASTICSEARCH_DATA/awesome ];
	then
        	echo "Load contacts"
        	curl localhost:9200/_bulk --data-binary @/data/sample.bulk
		while [[ $? -gt "0" ]]; do
                  sleep 2 
                  curl localhost:9200/_bulk --data-binary @/data/sample.bulk 
		done
	else 
        	echo "Contacts already loaded"
	fi
exit 1
