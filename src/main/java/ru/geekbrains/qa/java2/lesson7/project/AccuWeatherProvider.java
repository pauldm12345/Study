package ru.geekbrains.qa.java2.lesson7.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.qa.java2.lesson7.project.enums.Periods;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            currentWeather(cityKey);
        }
        else if(periods.equals(Periods.FIVE_DAYS)){
            fiveDayWeather(cityKey);
        }
    }


    void currentWeather(String cityKey)throws IOException{

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                .addPathSegment(API_VERSION)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String line = response.body().string();

        readWithSerialization(line);

        // TODO: Сделать в рамках д/з вывод более приятным для пользователя.
        //  Создать класс WeatherResponse, десериализовать ответ сервера в экземпляр класса
        //  Вывести пользователю только текущую температуру в C и сообщение (weather text)

    }

    void readWithSerialization(String jsonString){

            try {
                ObjectMapper objectMapper = new ObjectMapper();

                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // <- указание поведения при обнаружении неизвестных полей

                //WeatherResponse myResponse = objectMapper.readValue(jsonString, WeatherResponse.class);
                List<WeatherResponse> myResponse = objectMapper.readValue(jsonString, new TypeReference<List<WeatherResponse>>(){});
                for(WeatherResponse response : myResponse)
                    System.out.println(response.toString());
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }



    void readWithoutSerialization(String jsonString){
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper
                    .readTree(jsonString);
            JsonNode weatherText = node.at("/Headline/Text");
            System.out.println("Headline for 5 days: " + weatherText.asText());

            JsonNode n = node.get("DailyForecasts");
            Iterator<JsonNode> it = n.iterator();
            while( it.hasNext()) {
                JsonNode n1 = it.next();
                String dateText=n1.at("/Date").asText();
                dateText= dateText.substring(0,dateText.indexOf("T"));
                String minValue =n1.at("/Temperature/Minimum/Value").asText();
                String minUnit =n1.at("/Temperature/Minimum/Unit").asText();
                String maxValue =n1.at("/Temperature/Maximum/Value").asText();
                String maxUnit =n1.at("/Temperature/Maximum/Unit").asText();
                System.out.println("На дату " +  dateText + " температура составляет от " +
                        minValue + minUnit + " до " + maxValue + maxUnit);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    void fiveDayWeather(String cityKey)throws IOException{

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST_ENDPOINT)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String line = response.body().string();
        readWithoutSerialization(line);


    }
    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
            .scheme("http")
            .host(BASE_HOST)
            .addPathSegment("locations")
            .addPathSegment(API_VERSION)
            .addPathSegment("cities")
            .addPathSegment("autocomplete")
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("q", selectedCity)
            .build();

        Request request = new Request.Builder()
            .addHeader("accept", "application/json")
            .url(detectLocationURL)
            .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }

/*    void read(String jsonString){
        try {

            ObjectMapper objectMapper = new ObjectMapper();


            JsonNode node = objectMapper
                    .readTree(jsonString);



            int size = node.size();

            for(int i = 0; i < size; i++) {
                JsonNode n = node.get(i);

                JsonNode weatherText = n.at("/WeatherText");
                JsonNode temperatureText = n.at("/Temperature/Metric/Value");
                JsonNode unitText = n.at("/Temperature/Metric/Unit");

                System.out.println(weatherText.asText());
                System.out.println(temperatureText.asText() + unitText.asText());

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
*/
}
