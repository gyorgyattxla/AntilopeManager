package com.antilope.antilopeManager.services;

import com.antilope.antilopeManager.models.RestaurantCard;
import com.antilope.antilopeManager.repositories.RestaurantCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantCardServiceTest {

    private RestaurantCardRepository restaurantCardRepository;
    private RestaurantCardService restaurantCardService;

    @BeforeEach
    void setUp() {
        restaurantCardRepository = mock(RestaurantCardRepository.class);
        restaurantCardService = new RestaurantCardService();
        // Use reflection to inject the mock, since the field is not final and has @Autowired
        var field = RestaurantCardService.class.getDeclaredFields()[0];
        field.setAccessible(true);
        try {
            field.set(restaurantCardService, restaurantCardRepository);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetAllCards() {
        // Arrange
        RestaurantCard card1 = new RestaurantCard();
        RestaurantCard card2 = new RestaurantCard();
        List<RestaurantCard> cards = Arrays.asList(card1, card2);
        when(restaurantCardRepository.findAll()).thenReturn(cards);

        // Act
        List<RestaurantCard> result = restaurantCardService.getAllCards();

        // Assert
        assertEquals(cards, result);
        verify(restaurantCardRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        RestaurantCard card = new RestaurantCard();
        when(restaurantCardRepository.findById(1L)).thenReturn(Optional.of(card));

        // Act
        RestaurantCard result = restaurantCardService.findById(1L);

        // Assert
        assertEquals(card, result);
        verify(restaurantCardRepository, times(1)).findById(1L);
    }

    @Test
    void testFindById_ThrowsWhenNotFound() {
        // Arrange
        when(restaurantCardRepository.findById(2L)).thenReturn(Optional.empty());

        // Act + Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            restaurantCardService.findById(2L);
        });

        assertEquals("Restaurant not found", exception.getMessage());
        verify(restaurantCardRepository, times(1)).findById(2L);
    }

    @Test
    void testSaveCard() {
        // Arrange
        RestaurantCard card = new RestaurantCard();

        // Act
        restaurantCardService.saveCard(card);

        // Assert
        verify(restaurantCardRepository, times(1)).save(card);
    }

    @Test
    void testDeleteCard() {
        // Arrange
        RestaurantCard card = new RestaurantCard();

        // Act
        restaurantCardService.deleteCard(card);

        // Assert
        verify(restaurantCardRepository, times(1)).delete(card);
    }
}
