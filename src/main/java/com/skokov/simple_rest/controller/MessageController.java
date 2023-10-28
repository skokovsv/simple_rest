package com.skokov.simple_rest.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.skokov.simple_rest.domain.Message;
import com.skokov.simple_rest.domain.Views;
import com.skokov.simple_rest.exceptions.NotFoundException;
import com.skokov.simple_rest.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageRepo messageRepo;

//    @Autowired
//    public MessageController(MessageRepo messageRepo){
//        this.messageRepo = messageRepo;
//    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list(){
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message getOne(@PathVariable("id") Message message){
        return message;
    }



    @PostMapping
    public Message create(@RequestBody Message message){
        message.setCreationDate(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message update(
            @PathVariable Message messageFromDb,
            @RequestBody Message message){
            BeanUtils.copyProperties(message,messageFromDb,"id");
            return messageRepo.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message){
        messageRepo.delete(message);
    }
}
