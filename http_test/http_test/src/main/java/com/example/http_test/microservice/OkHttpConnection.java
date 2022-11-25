package com.example.http_test.microservice;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class OkHttpConnection {

	public String getJson() {
		//Создаем ссылку, куда нам необходимо обратиться
		String url1 = "http:localhost:8080/api/v1/controller/newProject";
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url(url1)
				.build();
		Call call = client.newCall(request);
		Response response;
		{
			try {
				response = call.execute();
				System.out.println(response.code());
				return response.body().string();

			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
