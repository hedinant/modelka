package ru.hedin.modelka.service;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.json.JsonParser;
import org.springframework.stereotype.Service;
import ru.hedin.modelka.domain.Action;
import ru.hedin.modelka.domain.ActionData;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionService {

    public List<String> doAction(ActionData actionData) {
        Action action = actionData.getModel().fetchActionForName(actionData.getName());
        // TODO validate action data for contract
        Context context = Context.enter();
        ScriptableObject scope = context.initStandardObjects();
        ScriptableObject.putProperty(scope, "game", Context.javaToJS(actionData.getGame(), scope));
        ScriptableObject.putProperty(scope, "log", context.newArray(scope, 0));
        JsonParser parser = new JsonParser(context, scope);
        ScriptableObject.putProperty(scope, "data", parseJson(actionData, parser));

        Object result = context.evaluateString(scope, action.getScriptJs(), "action", 1, null);

        return ((List<Object>) (List) Context.jsToJava(scope.get("log"), List.class)).stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    private Object parseJson(ActionData actionData, JsonParser parser) {
        try {
            return parser.parseValue(actionData.getActionDataJson());
        } catch (JsonParser.ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
