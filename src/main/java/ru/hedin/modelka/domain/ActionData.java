package ru.hedin.modelka.domain;

public class ActionData {
    private Game game;
    private Character character;
    private Model model;
    private String actionDataJson;
    private String name;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getActionDataJson() {
        return actionDataJson;
    }

    public void setActionDataJson(String actionDataJson) {
        this.actionDataJson = actionDataJson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
