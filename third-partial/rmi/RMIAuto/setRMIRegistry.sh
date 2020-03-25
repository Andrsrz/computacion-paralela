#!/bin/bash
port="$1"
echo "rmiregistry..."
rmiregistry $port

# javac MyRemoteInterface2.java
# javac MyRemoteClass2.java
# echo "Java files compiled"
# echo "rmiregistry..."
# rmiregistry 1234
