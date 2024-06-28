package com.alamin.testdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}

class DDosAttack{
	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(50);
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(new URI("http://192.168.1.104:9192/test"))
				.build();
		for (int i = 0; i < 10000; i++) {
			service.submit(() -> {
				try {
					var res = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString()).body();
					System.out.println(res);
				}catch (Exception e){
					e.printStackTrace();
				}

			});
		}
	}
}