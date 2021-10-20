package ru.geekbrains.qa.java2.lesson8.project;

import ru.geekbrains.qa.java2.lesson8.project.entity.WeatherData;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
        "city TEXT NOT NULL,\n" +
        "date_time TEXT NOT NULL,\n" +
        "weather_text TEXT NOT NULL,\n" +
        "temperature REAL NOT NULL,\n" +
        ");";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";
    String selectAllWeather = "SELECT * FROM weather";

    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    private void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {

        createTableIfNotExists();

        try (Connection connection = getConnection();
        PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData() throws IOException {
        List array = new ArrayList();
        try (Connection connection = getConnection()) {
            //connection.createStatement().execute(selectAllWeather);
            ResultSet resultSet = connection.createStatement().executeQuery(selectAllWeather);

            while (resultSet.next()) {
                WeatherData wd = new WeatherData();
                wd.setCity(resultSet.getString(1));
                wd.setLocalDate(resultSet.getString(2));
                wd.setText(resultSet.getString(3));
                wd.setTemperature(resultSet.getDouble(4));
                array.add(wd);
            }
        }
        catch(SQLException exception){
            exception.printStackTrace();
            throw new IOException(exception.getMessage());
        }
        return array;
        //throw new IOException("Not implemented exception");
    }

    public void closeConnection(){
        try(Connection connection = getConnection()){
            connection.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }

    }
}
