/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springexample.controllers;

import com.springexample.models.Message;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utilizador
 */

@CrossOrigin(maxAge = 3600)
@RestController
public class MessageController {
 
  private static String sender_ws = "";
  private static String message_ws = "";

  @Autowired
  public MessageController() {
  }
  
  @RequestMapping(value = "/helloworld", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)  
  public @ResponseBody ResponseEntity<String> helloWorld(@RequestBody Message message) throws URISyntaxException {
    sender_ws = message.getSender();
    message_ws = message.getMessage().replaceAll("\n", "<br />");
    message_ws = message_ws.replaceAll("\"","''");
    
    String return_msg_ws = "Hello " + sender_ws + "! <br />Your message is:<br /> " + message_ws ;
    // System.out.println(return_msg_ws);      
    // String jsonResult = "{\"success\":true, \"payload\":\"" + return_msg_ws + "\"}";
    String jsonResult = "{ \"status\": \"success\", \"data\": \"" + return_msg_ws + "\" , \"message\": null }";
    System.out.println(jsonResult);
    return new ResponseEntity<>(jsonResult, HttpStatus.OK);
  }
  
}
