package com.mycompany.inventario.empleados.auth;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class CallbackServer {

    public static void main(String[] args) throws IOException {
        // 1. Iniciar el servidor local en el puerto 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/oauth/callback", new CallbackHandler());
        server.setExecutor(null); // Usa el executor por defecto
        server.start();
        System.out.println("✅ Servidor escuchando en http://localhost:8080/oauth/callback");

        // 2. Abrir automáticamente el navegador con la URL de GitHub
        try {
            GitHubAuthService auth = new GitHubAuthService();
            auth.iniciarLogin(); // Este método abre el navegador con la URL de autorización
        } catch (Exception e) {
            System.err.println("❌ Error al iniciar el login con GitHub:");
            e.printStackTrace();
        }
    }

    // Clase interna que maneja el callback
    private static class CallbackHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String code = null;

            // Extraer el parámetro 'code' de la URL
            if (query != null && query.contains("code=")) {
                for (String param : query.split("&")) {
                    if (param.startsWith("code=")) {
                        code = param.substring("code=".length());
                        break;
                    }
                }
            }

            // Respuesta al navegador
            String response = "✅ Callback recibido. Puedes cerrar esta ventana.";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }

            // Si se recibió el código, continuar con el flujo OAuth
            if (code != null) {
                try {
                    GitHubAuthService auth = new GitHubAuthService();
                    String accessToken = auth.obtenerAccessToken(code);
                    JSONObject userData = auth.obtenerDatosUsuario(accessToken);

                    // Mostrar los datos del usuario en consola
                    System.out.println("🔑 Token de acceso: " + accessToken);
                    System.out.println("👤 Datos del usuario:");
                    System.out.println(userData.toString(2)); // Formateado con indentación
                } catch (Exception e) {
                    System.err.println("❌ Error al procesar el token o los datos del usuario:");
                    e.printStackTrace();
                }
            } else {
                System.err.println("⚠️ No se recibió el parámetro 'code' en el callback.");
            }
        }
    }
}