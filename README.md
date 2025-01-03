This project is a simple example of using a REST API with a Java Servlet. In this project, an HTTP request is made to an external API (https://http.cat/) and an image corresponding to the given HTTP status code is retrieved and displayed to the user.

Features:

Use of Jersey Client to make requests to a REST API.
Processing the API response (image) and sending it to the user.
If an error occurs or no image is available for the given status code, a JSON error message is returned to the user.

How to Use:

Open the project in your development environment (such as IntelliJ IDEA or Eclipse).
Ensure that the necessary libraries (Jersey Client) are included in your project configuration files (e.g., pom.xml for Maven or build.gradle for Gradle).
Deploy the project on a WebLogic server and start the server.



Responses:

If the status code is valid (e.g., 404 or 500), the corresponding image from the external API will be fetched and displayed.
If the status code is invalid or an error occurs while processing the request, a JSON error message will be returned, such as:
json
Copy code
{"error": "Invalid status code"}


Project Structure:

HelloServlet.java: The servlet code that processes the requests and interacts with the REST API to fetch the image.
web.xml: The configuration for the web application.
Dependencies: Jersey Client (for interacting with the REST API).


Prerequisites:

Java 8 or higher.
WebLogic or any similar Servlet container.
Internet access to use the external API.


Notes:

HTTP status codes like 404, 500, etc. are available at https://http.cat/{statusCode}. This API returns images corresponding to HTTP error codes.
If the HTTP status code provided does not have an image, a JSON error message will be returned.
