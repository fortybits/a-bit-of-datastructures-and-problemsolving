package org.deliveroo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


public class APIIntegrationTask {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.next();
        int cost = Integer.parseInt(scanner.next().trim());
        String result = APIIntegrationTask.bestRestaurant(city, cost);
        System.out.println(result);
    }

    /*
     * Complete the 'bestRestaurant' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING city
     *  2. INTEGER cost
     * API URL: https://jsonmock.hackerrank.com/api/food_outlets?city={city}&page={page}
     */
    public static String bestRestaurant(String city, int cost) {
        List<FoodOutlet> allFoodOutletsInPrice = findAllFoodOutletsInPrice(city);
        Optional<FoodOutlet> bestPossible = allFoodOutletsInPrice
                .stream()
                .filter(foodOutlet -> foodOutlet.getEstimatedCost() <= cost)
                .min(new OutletComparator()); // findFirst with criteria

        return bestPossible.map(FoodOutlet::getName).orElseThrow();
    }

    static List<FoodOutlet> findAllFoodOutletsInPrice(String city) {
        List<FoodOutlet> outletsInCity = new ArrayList<>();
        Number totalPages = Long.MAX_VALUE;
        for (long page = 1; page <= totalPages.longValue(); page++) {
            // Create a new HttpClient
            try {
                HttpClient client = HttpClient.newHttpClient();
                String uri = String.format("https://jsonmock.hackerrank.com/api/food_outlets?city=%s&page=%s", city, page);
                // Create a new HttpRequest for the specific URL
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(uri))
                        .GET() // Explicitly set the GET method
                        .build();

                // Send the request and get the response
                HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
                Response response = parseJsonResponse(httpResponse.body());
                totalPages = response.getTotalPages();
                outletsInCity.addAll(response.getFoodOutlets());
            } catch (Exception e) {
            }
        }
        return outletsInCity;
    }

    static Response parseJsonResponse(String responseBody) {
        Response response = new Response();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
            JSONArray data = (JSONArray) jsonObject.get("data");
            response.setTotalPages((Long) jsonObject.get("total_pages"));
            response.setTotal((Long) jsonObject.get("total"));
            response.setPage((Long) jsonObject.get("page"));
            response.setPerPage((Long) jsonObject.get("per_page"));

            List<FoodOutlet> outlets = new ArrayList<>();
            for (Object obj : data) {
                FoodOutlet outlet = getFoodOutlet((JSONObject) obj);
                outlets.add(outlet);
            }
            response.setFoodOutlets(outlets);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    private static FoodOutlet getFoodOutlet(JSONObject outletJson) {
        FoodOutlet outlet = new FoodOutlet();
        outlet.setId((Long) outletJson.get("id"));
        outlet.setCity((String) outletJson.get("city"));
        outlet.setName((String) outletJson.get("name"));
        outlet.setEstimatedCost((Long) outletJson.get("estimated_cost"));

        JSONObject rating = (JSONObject) outletJson.get("user_rating");
        // Learning: Number as a parent class is supported to map JSON attribute via the library
        Number averageRating = (Number) rating.get("average_rating");
        // Double outletRating = averageRating instanceof Double ? (Double) averageRating : ((Long) averageRating).doubleValue();
        Long votes = (Long) rating.get("votes");
        UserRating userRating = new UserRating();
        userRating.setAverageRating(averageRating);
        userRating.setVotes(votes);
        outlet.setUserRating(userRating);
        return outlet;
    }

    static class Response {
        Number page;
        Number perPage;
        Number total;
        Number totalPages;
        List<FoodOutlet> foodOutlets;

        public Number getPage() {
            return page;
        }

        public void setPage(Long page) {
            this.page = page;
        }

        public Number getPerPage() {
            return perPage;
        }

        public void setPerPage(Long perPage) {
            this.perPage = perPage;
        }

        public Number getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public Number getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Long totalPages) {
            this.totalPages = totalPages;
        }

        public List<FoodOutlet> getFoodOutlets() {
            return foodOutlets;
        }

        public void setFoodOutlets(List<FoodOutlet> foodOutlets) {
            this.foodOutlets = foodOutlets;
        }
    }

    static class FoodOutlet {
        Long id;
        String name;
        String city;
        Long estimatedCost;
        UserRating userRating;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Long getEstimatedCost() {
            return estimatedCost;
        }

        public void setEstimatedCost(Long estimatedCost) {
            this.estimatedCost = estimatedCost;
        }

        public UserRating getUserRating() {
            return userRating;
        }

        public void setUserRating(UserRating userRating) {
            this.userRating = userRating;
        }
    }

    static class UserRating {
        Number averageRating;
        Number votes;

        public Number getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(Number averageRating) {
            this.averageRating = averageRating;
        }

        public Number getVotes() {
            return votes;
        }

        public void setVotes(Long votes) {
            this.votes = votes;
        }
    }

    static class OutletComparator implements Comparator<FoodOutlet> {
        @Override
        public int compare(FoodOutlet o1, FoodOutlet o2) {
            int ratingComparison = Double.compare(o2.getUserRating().getAverageRating().doubleValue(),
                    o1.getUserRating().getAverageRating().doubleValue());
            if (ratingComparison == 0) {
                return o1.getEstimatedCost().compareTo(o2.getEstimatedCost());
            } else {
                return ratingComparison;
            }
        }
    }
}