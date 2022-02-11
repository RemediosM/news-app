package com.kodolamacz.newsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class NewsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsAppApplication.class, args).close();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


	@Autowired
	UserInput userInput;

	@Bean
	public String run(RestTemplate restTemplate) {
		String filePath = userInput.filePath();
		String apiKey = userInput.apiKey();
			try {
				News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=pl&category=business&apiKey=" + apiKey, News.class);
				FileOutputStream fos = new FileOutputStream(filePath);
				if (news == null) {
					System.out.println("Nie udało się pobrać wiadomości lub nie ma żadnych wiadomości");
					return "null news";
				}
				String text = news.toString();
				byte[] mybytes = text.getBytes();
				fos.write(mybytes);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (HttpClientErrorException  e){
				System.out.println("Prawdopodobnie błędny klucz api.");
				run(restTemplate);
			}
			return "OK";
	}

}
