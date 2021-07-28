package com.company.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

      public String getMessage(String message){
          System.out.println("message="+message);
          return message;
      }
}
