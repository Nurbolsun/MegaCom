import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String url1 = "https://jsonplaceholder.typicode.com/posts";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url1)
                .build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            System.out.println(response.code());
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
