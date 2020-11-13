package ru.hedin.modelka.domain;

public class Action {
    private Model model;
    private String name;

    private String contractJson;
    private String scriptJs;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractJson() {
        return contractJson;
    }

    public void setContractJson(String contractJson) {
        this.contractJson = contractJson;
    }

    public String getScriptJs() {
        return scriptJs;
    }

    public void setScriptJs(String scriptJs) {
        this.scriptJs = scriptJs;
    }
}
