package com.example.callapi;




import org.glassfish.jersey.client.ClientConfig;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static java.lang.System.out;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String statusCode = request.getParameter("statusCode");


        if (statusCode == null || !statusCode.matches("\\d{3}")) {
            response.setContentType("application/json");
            out.print("{\"error\": \"Invalid status code\"}");
            return;
        }

        String apiUrl = "https://http.cat/" + statusCode;

        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(apiUrl);
            Response apiResponse = target.request().get();

            if (apiResponse.getStatus() == 200) {
                InputStream inputStream = apiResponse.readEntity(InputStream.class);
                OutputStream outputStream = response.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
            } else {
                response.setContentType("application/json");
                out.print("{\"error\": \"Image not found for status code \"}");
            }
        } catch (Exception e) {
            response.setContentType("application/json");
            out.print("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    public void destroy() {
    }
}
