package com.ifood.service;

import com.ifood.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IngredientService {
    @Autowired(required = true)
    IngredientRepository ingredientRepository;
}
