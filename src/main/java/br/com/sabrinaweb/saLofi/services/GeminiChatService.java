package br.com.sabrinaweb.saLofi.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class GeminiChatService {

    private final ChatClient client;

    public GeminiChatService(ChatClient.Builder clientBuilder){
        this.client = clientBuilder.build();
    }

    public String chat(String message) {

        return this.client.prompt()
                .user(message)
                .call()
                .content();
    }
}
