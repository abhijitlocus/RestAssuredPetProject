package route;

public class GoRestRoute {

    //todo : retrieve from env variable
    private static String baseUrl = "https://gorest.co.in/public";
    private static String version = "/v2";

    public static String postUser() {
        return baseUrl + version + "/users";
    }

    public static String getUser(String userId) {
        return baseUrl + version + "/users/" + userId;
    }

}
