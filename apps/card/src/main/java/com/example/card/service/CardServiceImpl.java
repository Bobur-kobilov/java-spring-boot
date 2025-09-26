package com.example.card.service;

import org.springframework.stereotype.Service; // or @Component

@Service // or @Component
public class CardServiceImpl implements CardService{
    public String sayHello () {
      return "Hello from CardServiceImpl";
  }  
}
