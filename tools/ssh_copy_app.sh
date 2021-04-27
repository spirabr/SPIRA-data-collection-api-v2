#!/usr/bin/env bash


# Load .env
export $(egrep -v '^#' $(pwd)/.env | xargs)

#
echo "copying files to ${SSH_HOST}"
#
scp -P ${SSH_PORT} -r ${SRC_ROOT_PATH}build/quarkus-app ${SSH_HOST}:${SSH_PATH}
