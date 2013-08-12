QTrack - README
===========

## Environment Setup

1. Make sure you have MySQL/MariaDB installed and running
2. Execute the following SQL:
     1. CREATE DATABASE qtrack;
     2. GRANT ALL ON qtrack.* to 'qtrack'@'localhost' IDENTIFIED BY 'qtrack';
3. Import the Maven project into any IDE (Eclipse/IntelliJ IDEA)
4. Execute the following: mvn clean install
5. Run it like: mvn compile tomcat:run

## Authentication

1. Currently two users exist
     1. john/admin
     2. jane/user