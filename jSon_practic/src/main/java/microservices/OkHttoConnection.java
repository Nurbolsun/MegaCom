package microservices;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class OkHttoConnection {

    public String getJson() {
        String url1 = "http://10.244.53.211:8080/api/v1/person/get";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url1)
                .build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            System.out.println(response.code());
//            System.out.println(response.body().string());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return url1;
    }
}
