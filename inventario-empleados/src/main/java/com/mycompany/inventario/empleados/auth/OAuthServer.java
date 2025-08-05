package com.mycompany.inventario.empleados.auth;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.*;
import java.util.stream.Collectors;

public class OAuthServer {
    public static void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/oauth/callback", new OAuthCallbackHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor OAuth iniciado en http://localhost:8080");
    }

    static class OAuthCallbackHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String code = null;

            if (query != null && query.contains("code=")) {
                code = query.split("code=")[1];
            }

            String response = "Código recibido: " + code;
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

            if (code != null) {
                obtenerAccessToken(code);
            }
        }

        private void obtenerAccessToken(String code) throws IOException {
            String clientId = "Ov23liAFt4IJlODL9Nt6";
            String clientSecret = "dcd25256d3122d6e7d8d1400a864469161ea679";

            URL url = new URL("https://github.com/login/oauth/access_token");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            String params = "client_id=" + clientId +
                            "&client_secret=" + clientSecret +
                            "&code=" + code;

            try (OutputStream os = conn.getOutputStream()) {
                os.write(params.getBytes());
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String result = in.lines().collect(Collectors.joining());
            System.out.println("Access Token Response: " + result);
        }
    }
}