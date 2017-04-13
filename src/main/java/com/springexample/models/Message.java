/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springexample.models;

import java.io.Serializable;

/**
 *
 * @author utilizador
 */
public class Message implements Serializable {
  
  private String sender;
  private String message;

  public Message() {
  }

  public Message(String sender, String message) {
    this.sender = sender;
    this.message = message;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }    
  
}
