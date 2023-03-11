package testData;

public class TmdbApiTestData {
    private String apiKey = "bdf9faae90623f793a48b4d75c6a634d";

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String formatted(String a){

        String b = String.format("{%s}",a);

        return b;

    }


}
