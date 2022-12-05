#Developer Assessment Project

##Instructions

<h2>Description</h2>
<p>The assessment comes with 3 CSV files. The files contain data for countries, airports and runways.
Write a program that retrieves the following information given the provided files:
<li>Runways for each airport given a country code or country name.</li>
<li>Top 10 countries with highest number of airports.</li>
</p>
<p>Bonus: Support retrieving the information given a partial/fuzzy country code/name as input parameter, e.g. entering 'zimb' will result in 'Zimbabwe'.</p>

<h2>Requirements</h2>
<li>The program should be written in Java.</li>
<li>Write production-ready code.</li>
<li>Document how to run the application.</li>
<li>Publish the source code into GitHub (using your own personal account) and share it with us.</li>

#Spring Boot web application

<h2>Prerequisites</h2>
<li>Java 17</li>
<li>Apache Maven (3.8.6)</li>
<li>Docker</li>
<li>Elasticsearch</li>

<h2>How to prepare the environment</h2>

<h3>Running Elasticsearch and Kibana with Docker Compose</h3>
<p>Running Docker</p>
<p>Go to the folder (project root) where the docker-compose.yml is located:</p>
<code>cd {base_project_path}/developer-assessment-es</code>
<p>Create and start Elasticsearch and Kibana:</p>
<code>docker-compose up -d</code>
<p>To stop Elasticsearch and Kibana containers without removing them:</p>
<code>docker-compose stop</code>
<p>To stop Elasticsearch and Kibana containers and to remove the stopped containers as well as any networks that were created:</p>
<code>docker-compose down</code>
<p>To delete the network, containers, and volumes when you stop the cluster, specify the -v option:</p>
<code>docker-compose down -v</code>

<p>Access Kibana through the web application on port 5601</p>
<code>http://localhost:5601/</code>
<p>Elasticsearch running on:</p>
<code>http://localhost:9200/</code>

<p>(optional) if the process Vmmem consumes a lot of memory, you can set the file ..wslconfig. For Windows environment, the folder where put the file is C:\Users\{user} to limit it. Below is my configuration that limits VM memory in WSL 2 to 8 GB:</p>
<code>[wsl2]<br>memory=8GB</br></code>

<h3>How to Build the project with Maven</h3>
<code>mvn clean install -Pprod</code>
<p>Exist two Maven profiles:
<li><b>local</b>: local environment: <code>mvn clean install -Plocal</code></li>
<li><b>prod</b>: production environment, e.g. Docker: <code>mvn clean install -Pprod</code></li>
</p>

<h3>How to start the Spring Boot application with Docker</h3>
<p>Go to the folder (project root) where the dockerfile is located:</p>
<code>cd {base_project_path}/developer-assessment-es</code>
<p>Create an image from the Dockerfile</p>
<code>docker build -t mg/app-developer-assessment-es-app .</code>
<p>Run the container from the image:</p>
<code>docker run -d -p 8080:8080 --name app-developer-assessment-es-app mg/app-developer-assessment-es-app:latest</code>

<h3>How to access Swagger UI to visualize and interact with the API’s resources:</h3>
<code>http://localhost:8080/assessment/swagger-ui/index.html</code>

<h3>Import countries, airports and runways data into Elasticsearch:</h3>
<code>http://localhost:8080/assessment/import/json/data</code>
<p>Returns true if this operation is successful</p>

<h2>API Documentation</h2>

<h3>1.To import the countries, airports and runways data</h3>
<code>GET /assessment/import/json/data</code>
<p>Returns true if this operation is successful</p>

<h3>2. To retrieve the top x countries  with the highest number of airports</h3>
<code>GET /assessment/airport/statistics/top/{limit}/countries</code>
<p>Path Parameters:
<li>limit (required): represents the max number of airport runways that are retrieved, e.g. if you want ten countries, set {limit} to 10</li>
</p>

<h3>3. To retrieve the runways for each airport given a country code or country name. It also works with partial/fuzzy code or name</h3>
<code>POST /assessment/aiport/statistics/given/country</code>
<p>JSON body parameters:
<li><b>code</b> (optional): represents the country code whose airport runways you would like to retrieve.</li>
<li><b>name</b> (optional): represents the country name whose airport runways you would like to retrieve.</li>
<li><b>page</b> (required): represents the page that is retrieved</li>
<li><b>size</b> (required): represents the max number of airport runways that are retrieved</li>
<li><b>sortBy</b> (required): represents the property to order for, e.g. id</li>
<li><b>sortOrder</b> (required): represents the sort directions (asc/desc). Default: asc</li>
</p>

<h2>Postman Collection</h2>

<p>The postman collection is in the project root</p>
<code>File: developer-assessment-es.postman_collection.son</code>
