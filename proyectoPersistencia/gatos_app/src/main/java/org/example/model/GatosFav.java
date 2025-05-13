package org.example.model;

import io.github.cdimascio.dotenv.Dotenv;

public class GatosFav {
    String id;
    String image_id;
    Dotenv dotEnv = Dotenv.load();
    String apiKey = dotEnv.get("API_KEY");;
    Imagex image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public Dotenv getDotEnv() {
        return dotEnv;
    }

    public void setDotEnv(Dotenv dotEnv) {
        this.dotEnv = dotEnv;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Imagex getImage() {
        return image;
    }

    public void setImage(Imagex image) {
        this.image = image;
    }
}
