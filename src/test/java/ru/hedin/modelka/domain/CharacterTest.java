package ru.hedin.modelka.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CharacterTest {
    @Test
    public void testCharacterDataReadWrite() {
        Map<String, Object> data = new HashMap<>();
        data.put("agencyLevel", 3);
        List<Map<String, Object>> dossiers = new ArrayList<>();
        data.put("dossiers", dossiers);
        Map<String, Object> dossier = new HashMap<>();
        dossier.put("name", "Trump");
        dossier.put("level", 2);
        dossier.put("bitsAsLong", (long) (16 + 32));

        dossiers.add(dossier);

        Character character = new Character();
        character.writeModelData(data);
        Map<String, Object> readModelData = character.readModelData();

        assertEquals(3, readModelData.get("agencyLevel"));

        List<Map<String, Object>> readDossiers = (List<Map<String, Object>>) data.get("dossiers");
        Map<String, Object> readDossier = readDossiers.get(0);
        assertEquals("Trump", readDossier.get("name"));
        assertEquals(2, readDossier.get("level"));
        assertEquals((long) 48, readDossier.get("bitsAsLong"));

    }
}
