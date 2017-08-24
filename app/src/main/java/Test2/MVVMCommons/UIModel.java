package Test2.MVVMCommons;

import java.util.HashMap;

public class UIModel {

    protected HashMap<String, String> model;

    public UIModel(String modelData) throws InvalidModelException {
        this.interpretModel(modelData);
    }

    public UIModel(HashMap<String, String> model) {
        this.model = model;
    }

    protected void interpretModel(String modelData) throws InvalidModelException{
        model = new HashMap<>();
        String[] data = modelData.split("<");
        for (String entry : data) {
            if(!entry.equals("")) {
                try {
                    String key = entry.substring(0, entry.indexOf(" "));
                    String value = entry.substring(entry.indexOf(" value='") + 8, entry.indexOf("'>"));
                    model.put(key, value);
                } catch (Exception e) {
                    throw new InvalidModelException("Invalid model format: " + modelData);
                }
            }
        }
    }

    public UIModel copy(KeyValuePair<String, String>... modifiedValues) {
        HashMap<String, String> copyHashMap = new HashMap<>(model);
        for (KeyValuePair<String, String> pair : modifiedValues) {
            copyHashMap.put(pair.getKey(), pair.getValue());
        }

        return new UIModel(copyHashMap);
    }

    public String get(String key) {
        return model.get(key);
    }
}

