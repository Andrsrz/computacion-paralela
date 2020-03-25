#!/bin/bash
javac MyRMIClient.java
echo "Java file compiled"
java MyRMIClient 127.0.1.1 1234
echo "Client initialized"