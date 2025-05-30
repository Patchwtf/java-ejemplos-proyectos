package org.example.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.example.model.Gatos;
import org.example.model.GatosFav;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class GatoService {
    public static void verGatos() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search").get().build();
        Response response = client.newCall(request).execute();
        String elJson = response.body().string();

        //Cortar corchetes
        elJson = elJson.substring(1, elJson.length()-1);

        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);

        //Redimensionar imagen
        Image image = null;
        try{
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);
            ImageIcon fondoGato = new ImageIcon(image);

            if(fondoGato.getIconHeight() > 600) {
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }
            String menu = "Opciones: "
                    + "1. Ver otra imagen\n"
                    + "2. Favorito\n"
                    + "3. Volver al menú\n";

            ArrayList<String> botones = new ArrayList<>();
            botones.add("Ver otra imagen");
            botones.add("Favorito");
            botones.add("volver");
            String id_gato = String.valueOf(gatos.getId());

            String opcion = JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones.toArray(), botones.get(0)).toString();
            int seleccion = -1;
            seleccion = botones.indexOf(opcion);

            switch (seleccion) {
                case 0:
                    verGatos();
                    break;
                case 1:
                    favoritoGato(gatos);
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void favoritoGato(Gatos gato){
        try{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\":\"" + gato.getId() + "\"\r\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("x-api-key", gato.getApiKey())
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void verFavoritos() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/favourites")
                .get().addHeader("x-api-key", new Gatos().getApiKey())
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()){
            String elJson = response.body().string();
            GatosFav[] gatosFavArray = new Gson().fromJson(elJson, GatosFav[].class);
            if(gatosFavArray.length > 0) {
                int indice = new Random().nextInt(gatosFavArray.length);
                GatosFav gatoFav = gatosFavArray[indice];

                //Redimensionar imagen
                Image image = null;
                try{
                    URL url = new URL(gatoFav.getImage().getUrl());
                    image = ImageIO.read(url);
                    ImageIcon fondoGato = new ImageIcon(image);

                    if(fondoGato.getIconHeight() > 600) {
                        Image fondo = fondoGato.getImage();
                        Image modificada = fondo.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
                        fondoGato = new ImageIcon(modificada);
                    }
                    String menu = "Opciones: "
                            + "1. Ver otro favorito\n"
                            + "2. Eliminar de favoritos\n"
                            + "3. Volver al menú\n";

                    ArrayList<String> botones = new ArrayList<>();
                    botones.add("Ver otro favorito");
                    botones.add("Favorito favorito");
                    botones.add("volver");
                    String id_gato = String.valueOf(gatoFav.getId());

                    String opcion = JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones.toArray(), botones.get(0)).toString();
                    int seleccion = -1;
                    seleccion = botones.indexOf(opcion);

                    switch (seleccion) {
                        case 0:
                            verFavoritos();
                            break;
                        case 1:
                            eliminarFavorito(gatoFav);
                            break;
                        default:
                            break;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminarFavorito(GatosFav gatoFav) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites/" + gatoFav.getId())
                .method("DELETE", body)
                .addHeader("x-api-key", gatoFav.getApiKey())
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
