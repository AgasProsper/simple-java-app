!#/bin/bash

export IMAGE_NAME=$1

sudo docker pull $1

sudo docker-compose up 