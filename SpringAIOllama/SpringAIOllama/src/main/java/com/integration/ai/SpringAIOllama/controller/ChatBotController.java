package com.integration.ai.SpringAIOllama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatBotController {

    ChatClient chatClient;

    public ChatBotController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping
    ResponseEntity<String> getChatResponseFromOllama(@RequestParam(value = "q") String query) {
        String content = this.chatClient.prompt(query).call().content();
        return ResponseEntity.ok(content);
    }
}
