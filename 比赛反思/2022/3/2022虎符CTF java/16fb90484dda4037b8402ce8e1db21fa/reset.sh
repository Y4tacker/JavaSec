#!/bin/bash

do
    docker-compose down -v
    docker-compose up -d
    sleep 900
done