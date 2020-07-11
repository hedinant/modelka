package ru.hedin.modelka.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.hedin.modelka.service.MapperService;

import java.io.IOException;
import java.util.Map;

public class Character {
    private Player player;
    private long id;

    private String characterModelDataJson;
    // TODO move to better place

    public Map<String, Object> readModelData() {
        return MapperService.getInstance().read(characterModelDataJson);
    }

    public void writeModelData(Map<String, Object> data) {
        characterModelDataJson = MapperService.getInstance().write(data);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
