QTrack - README
===========

## Docker

1. Run `docker-compose up -d --build`
2. Navigate to http://localhost:8080/QTrack

## Local/Non-Docker Environment Setup

1. Make sure you have MySQL/MariaDB installed and running
2. Execute the following SQL:
     1. CREATE DATABASE qtrack;
     2. GRANT ALL ON qtrack.* to 'qtrack'@'localhost' IDENTIFIED BY 'qtrack';
3. Import the Maven project into any IDE (Eclipse/IntelliJ IDEA)
4. Execute the following: mvn clean install
5. Run it like: mvn compile tomcat:run

## Authentication

1. Currently two users exist
     1. admin/admin
     2. user/user
