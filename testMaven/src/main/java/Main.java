import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //Создаем ссылку, куда нам необходимо обратиться
        String url1 = "http://10.244.53.125:8080/api/v1/controller/";

        //создаем клиента
        OkHttpClient client = new OkHttpClient();

        //создаем запрос , который будем отправлять
        Request request = new Request.Builder()
                .url(url1)
                .build();

        //создаем call (все из библиотеки http)
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
