package ru.hedin.modelka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class MapperService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private static MapperService instance = new MapperService();

    private MapperService() {
    }

    public static MapperService getInstance() {
        return instance;
    }

    public Map<String, Object> read(String raw) {
        try {
            return objectMapper.readValue(raw, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String write(Map<String, Object> data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
