package evg.savkov.Task13;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;


import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.net.*;

public class Task13 {
    private static HttpURLConnection connection;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Что ищем?: ");
        String key = scanner.nextLine();
        scanner.close();
        String query = generateQuery(key);
        URL url = new URL(query);

        connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(10000);
        connection.setConnectTimeout(15000);
        connection.setRequestMethod("Получить");
        connection.setDoInput(true);
        connection.connect();

        InputStream input = connection.getInputStream();
        String contentAsString = new String(input.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(contentAsString);

        Gson gson = new Gson();
        ResponseDTO result = gson.fromJson(contentAsString, ResponseDTO.class);
        System.out.println();

        List<SearchDTO> searchList = result.getQuery().getSearch();
        List<String> output = new ArrayList<>();

        for (SearchDTO s : searchList) {
            output.add(s.getSnippet());
        }
        System.out.println("Результат:");


        for (String ans :
                output) {
            Document doc = Jsoup.parse(ans);
            System.out.println(doc.text());
            System.out.println();
        }
    }

    private static String generateQuery(String key) {
        return String.format("https://ru.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exsentences=10&explaintext=1&formatversion=2&titles=",
                URLEncoder.encode(key, StandardCharsets.UTF_8));
    }

    class ResponseDTO {
        @SerializedName("вопрос")
        private QueryDTO query;

        public QueryDTO getQuery() {
            return query;
        }
    }

    class QueryDTO {
        @SerializedName("поиск")
        private List<SearchDTO> search;

        public List<SearchDTO> getSearch() {
            return search;
        }
    }

    class SearchDTO {
        @SerializedName("сведения")
        private String snippet;

        public String getSnippet() {
            return snippet;
        }
    }

}
