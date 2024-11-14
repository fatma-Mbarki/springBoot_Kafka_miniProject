# Mon Projet Kafka avec Spring Boot
This project demonstrates a Spring Boot application that consumes real-time changes from Wikimedia using Kafka and stores the changes in a MySQL database. The project uses Spring Boot, Kafka, and MySQL to demonstrate event-driven data streaming and storage.

## Table of Contents
  - *overview*
  - *Features*
  - *Requirements*
  - *Setup and Configuration*
  - *Running the Application*
  - *Kafka Commands*
  - *Usage*

## Overview
This application consumes data from a Kafka topic that streams recent changes from Wikimedia. 
The data is processed and saved into a MySQL database for later analysis.

## Features
- Real-time data streaming from Wikimedia
- Kafka integration for event processing
- Persistence of events in MySQL database
## Requirements
- Java 11+
- Apache Kafka
- MySQL Server
- MySQL Workbench (optional for database management)
- Setup and Configuration
- Clone the Repository

##  Setup and Configuration
### Clone the Repository
```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name 
```
### Kafka Setup
  Start Zookeeper:
```bash
# Commande pour démarrer Zookeeper
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

  Start Kafka Server:
```bash
#
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
  Create Kafka topic:
```bash
#
.\bin\windows\kafka-topics.bat --create --topic wikimedia_recent_change --bootstrap-server localhost:9092
```
## MySQL Setup

Create a MySQL database named wikimedia.
Update the connection details in application.properties:
```properties

spring.datasource.url=jdbc:mysql://localhost:3306/wikimedia
spring.datasource.username=root
spring.datasource.password=your_password
```
Build the Project

```bash
mvn clean install
Running the Application
```
To run the application:

```bash

mvn spring-boot:run
```
This starts the application, which listens to the Kafka topic wikimedia_recent_change and persists events in the MySQL database.

Kafka Commands
Consume Messages from Topic:
```bash
Copier le code
.\bin\windows\kafka-console-consumer.bat --topic wikimedia_recent_change --from-beginning --bootstrap-server localhost:9092
```
### Usage
The application listens to Wikimedia’s recent change stream.
When new events are detected, they are saved into the MySQL database.
You can monitor the logs to verify message consumption and storage:

```bash
tail -f logs/application.log
```
