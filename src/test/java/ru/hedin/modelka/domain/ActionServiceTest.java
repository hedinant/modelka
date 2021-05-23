package ru.hedin.modelka.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import ru.hedin.modelka.service.ActionService;

public class ActionServiceTest {
    private ActionService actionService = new ActionService();

    @Test
    public void testAction() {
        ActionData data = new ActionData();
        data.setActionDataJson("{\"test\":42}");

        Game game = new Game();
        data.setGame(game);


        Action action = new Action();
        action.setName("test");
        action.setScriptJs("log.push('test - '+data.test)");

        Model model = new Model();
        model.getActions().add(action);
        data.setModel(model);

        data.setName("test");

        List<String> log = actionService.doAction(data);

        Assert.assertEquals(1, log.size());
        Assert.assertEquals("test - 42", log.get(0));
    }
}
