package ru.hedin.modelka.domain;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private long id;
    private List<Action> actions = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public Action fetchActionForName(String name) {
        return actions.stream()
                .filter(action -> action.getName().equals(name))
                .findFirst().orElseThrow(() -> new RuntimeException("action not found " + name));
    }
}
