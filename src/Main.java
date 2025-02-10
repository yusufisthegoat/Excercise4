/* Yusuf Ibrahim 2/9/25 CSCI 1660 Excercise 4 */
import java.util.*;

public class Main {
    static List<String> cities = new ArrayList<>();
    static Map<String, List<Double>> cityTemperatures = new HashMap<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        getUserCity();
        getUserTemp();
        calculateAverages();
    }

    static void getUserCity() {
        System.out.println("Enter your cities (type 'END' to finish):");
        String city = input.nextLine();

        while (!city.equalsIgnoreCase("END")) {
            cities.add(city);
            city = input.nextLine();
        }
    }

    static void getUserTemp() {
        for (String city : cities) {
            System.out.println("Enter the average daily temperature for the next 5 days for " + city + ":");
            List<Double> temperatures = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                System.out.println("Day " + (i + 1) + ":");
                double temp = input.nextDouble();
                temperatures.add(temp);
            }
            input.nextLine();
            cityTemperatures.put(city, temperatures);
        }
    }



    static void calculateAverages() {
        System.out.println("\nAverage Temperatures for each city:");
        for (Map.Entry<String, List<Double>> entry : cityTemperatures.entrySet()) {
            String city = entry.getKey();
            List<Double> temps = entry.getValue();
            double sum = 0.0;

            for (double temp : temps) {
                sum += temp;
            }

            double average = sum / temps.size();
            System.out.println("City: " + city + " -> Average Temperature: " + average);
        }
    }
}
