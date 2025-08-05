package com.mycompany.inventario.empleados.auth;

import java.awt.Desktop;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import org.json.JSONObject;

public class GitHubAuthService {
    private final String clientId = "Ov23liAFt4IJlODL9Nt6";
    private final String clientSecret = "dcd25256d3122d6e70d81d400a864469161ea679"; 
    private final String redirectUri = "http://localhost:8080/oauth/callback";

    public void iniciarLogin() throws Exception {
        String authUrl = "https://github.com/login/oauth/authorize" +
                         "?client_id=" + clientId +
                         "&redirect_uri=" + redirectUri +
                         "&scope=read:user";
        Desktop.getDesktop().browse(new URI(authUrl));
    }

    public String obtenerAccessToken(String code) throws Exception {
        String tokenUrl = "https://github.com/login/oauth/access_token";
        String body = "client_id=" + clientId +
                      "&client_secret=" + clientSecret +
                      "&code=" + code +
                      "&redirect_uri=" + redirectUri;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(tokenUrl))
            .header("Accept", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        return json.getString("access_token");
    }

    public JSONObject obtenerDatosUsuario(String accessToken) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/user"))
            .header("Authorization", "Bearer " + accessToken)
            .header("Accept", "application/json")
            .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
        return new JSONObject(response.body());
    }
}