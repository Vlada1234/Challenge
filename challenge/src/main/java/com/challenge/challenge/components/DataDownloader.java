package com.challenge.challenge.components;

import io.netty.channel.ChannelOption;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@Component
public class DataDownloader {

    public String downloadDataFromApi(String apiUrl) {

        int bufferSize = Integer.MAX_VALUE;

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.SO_RCVBUF, bufferSize)
                .wiretap(true);

        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

        WebClient webClient = WebClient.builder()
                .clientConnector(connector)
                .build();

         return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class)
                 .block();
    }







}
