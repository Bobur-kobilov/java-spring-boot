package com.example.card.test;

import com.example.card.service.CardService;
import com.example.card.service.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CardServiceTest {
  
  private CardService cardService;
  
  @BeforeEach
  void setUp() {
    cardService = new CardServiceImpl();
  }
  
  @Test
  void testSayHello() {
    String result = cardService.sayHello();
    assertEquals("Hello from CardServiceImpl", result);
  }
}
