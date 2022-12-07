# Developer Assessment Project

*Simple Spring Boot app with Elastisearch*

## Table of contents
* [General info](#general-info)
* [Prerequisites](#prerequisites)
* [Setup the environment](#setup-the-environment)
* [API Documentation](#api-documentation)
* [Postman Collection](#postman-collection)

## General info

**Description**

The assessment comes with 3 CSV files. The files contain data for countries, airports and runways.
Write a program that retrieves the following information given the provided files:
* Runways for each airport given a country code or country name.
* Top 10 countries with highest number of airports.

**Requirements**

Bonus: Support retrieving the information given a partial/fuzzy country code/name as input parameter, e.g. entering 'zimb' will result in 'Zimbabwe'.

* The program should be written in Java.
* Write production-ready code.
* Document how to run the application.
* Publish the source code into GitHub (using your own personal account) and share it with us.

## Prerequisites

* Java 17
* Apache Maven (3.8.6)
* Docker
* Elasticsearch

## Setup the environment

* [How to install and run MariaDB with Dockcer](#how-to-run-elasticsearch-and-kibana-with-docker-compose).
* [How to Build the project with Maven](#how-to-build-the-project-with-maven)
* [How to start the Spring Boot application with Docker](#how-to-start-the-spring-boot-application-with-docker)
* [Import countries, airports and runways data into Elasticsearch](import-countries-airports-and-runways-data-into-elasticsearch)

### How to run Elasticsearch and Kibana with Docker Compose

Go to the folder (project root) where the **docker-compose.yml** is located:

	cd {base_project_path}/developer-assessment-es
	
**Create and start Elasticsearch and Kibana**:
	
	docker-compose up -d
	
To **stop** Elasticsearch and Kibana containers **without removing them**:
	
	docker-compose stop
	
To **stop** Elasticsearch and Kibana containers and **to remove the stopped containers as well as any networks that were created**:

	docker-compose down
	
To **delete the network, containers, and volumes** when you stop the cluster, specify the -v option:

	docker-compose down -v

**Access Kibana** through the web application on port 5601

<code>http://localhost:5601/

**Elasticsearch** running on:

	http://localhost:9200/
	

*(optional)* If the process Vmmem consumes a lot of memory, you can set the file .wslconfig. For Windows environment, the folder where put the file is C:\Users\{user} to limit it. Below is my configuration that limits VM memory in WSL 2 to 8 GB:

	[wsl2]<br>memory=8GB</br>

### How to Build the project with Maven

	mvn clean install -Plocal

There are the following **Maven profiles**:

* **local**: local environment. When this profile is activated, the application reads the application-local.properties
* **prod**: production environment, e.g. Docker. When this profile is activated, the application reads the application-prod.properties

### How to start the Spring Boot application with Docker

Go to the folder (project root) where the **dockerfile** is located:

	cd {base_project_path}/developer-assessment-es

**Create an image** from the dockerfile:

	docker build -t mg/app-developer-assessment-es-app .

**Run the container** from the image:

	docker run -d -p 8080:8080 --name app-developer-assessment-es-app mg/app-developer-assessment-es-app:latest

### Import countries, airports and runways data into Elasticsearch:

	http://localhost:8080/assessment/import/json/data

Returns true if this operation is successful

## API Documentation

*Access Swagger UI to visualize and interact with the API’s resources:*

	http://localhost:8080/assessment/swagger-ui/index.html
	
#### 1.To import the countries, airports and runways data

	GET /assessment/import/json/data

Returns true if this operation is successful

####  2. To retrieve the top x countries  with the highest number of airports
	
	GET /assessment/airport/statistics/top/{limit}/countries
	
*Path Parameters:*

* **limit** *(required)*: represents the max number of airport runways that are retrieved, e.g. if you want ten countries, set {limit} to 10


#### 3. To retrieve the runways for each airport given a country code or country name. It also works with partial/fuzzy code or name

	>POST /assessment/aiport/statistics/given/country

*JSON body parameters:*

* **code** *(optional)*: represents the country code whose airport runways you would like to retrieve.
* **name** *(optional)*: represents the country name whose airport runways you would like to retrieve.
* **page** *(required)*: represents the page that is retrieved
* **size** *(required)*: represents the max number of airport runways that are retrieved
* **sortBy** *(required)*: represents the property to order for, e.g. id
* **sortOrder** (required): represents the sort directions (asc/desc). Default: asc

## Postman Collection

The postman collection is in the project root. [Click here](https://github.com/manuele-g/developer-assessment-es/blob/main/developer-assessment-es.postman_collection.json) to see the postman collection.
