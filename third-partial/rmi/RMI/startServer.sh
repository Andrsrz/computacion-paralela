#!/bin/bash
javac MyRemoteInterface.java
javac MyRemoteClass.java
echo "Java files compiled"
rmic -d . MyRemoteClass
# rmiregistry 1234
echo "Register done"
echo "Initializing server..."
java MyRemoteClass 1234