#!/bin/bash
echo "Initializing server..."
java -Djava.rmi.server.hostname=192.168.0.12 -Djava.security.policy=policy MyRemoteClass2 1234