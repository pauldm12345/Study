package ru.geekbrains.qa.java2.lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;


import java.io.IOException;

public class HomeWork6App {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";

    private static final String SAINT_PETERSBURG_KEY = "2-295212_25_AL";
    private static final String API_KEY = "RrA45YM6KzU6AToUHxArtlD2SWZtNGnE";

    public static void main(String[] args) {

        try {

            OkHttpClient client = new OkHttpClient();

            // Сегментированное построение URL
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST_TYPE)
                    .addPathSegment(FORECAST_PERIOD)
                    .addPathSegment(SAINT_PETERSBURG_KEY)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .addQueryParameter("metric", "true")
                    .build();

            System.out.println(url.toString());

            // При необходимости указать заголовки
            Request requesthttp = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String jsonResponse = client.newCall(requesthttp).execute().body().string();

            System.out.println(jsonResponse);
        }
        catch(IOException e){

            e.printStackTrace();
        }
    }
}
