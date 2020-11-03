#!/bin/bash
mvn package
java -jar target/GamLib-0.0.1-SNAPSHOT.jar & echo $! > ./pid.file &
