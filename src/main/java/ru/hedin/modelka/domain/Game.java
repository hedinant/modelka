package ru.hedin.modelka.domain;

import ru.hedin.modelka.service.MapperService;

import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> players;
    private List<Character> characters;
    private List<Model> models;
    private Map<Long, String> modelsData;

    private Map<String, Object> readModelDataById(long id) {
        return MapperService.getInstance().read(modelsData.get(id));
    }

    private void writeModelDataById(long id, Map<String, Object> data) {
        modelsData.put(id, MapperService.getInstance().write(data));
    }
}