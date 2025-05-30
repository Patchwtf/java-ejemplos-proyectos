package org.example.model;

import io.github.cdimascio.dotenv.Dotenv;

;

public class Gatos {

    Dotenv dotEnv = Dotenv.load();
    String id;
    String url;
    String apiKey = dotEnv.get("API_KEY");
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
