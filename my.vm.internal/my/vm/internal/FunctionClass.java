package my.vm.internal;

import java.util.LinkedHashMap;

public record FunctionClass(
        String name,
        int argumentCounter,
        int variablesCounter,
        LinkedHashMap<String, Label> labels
) {
    public FunctionClass(String name, int argumentCounter, int variablesCounter) {
        this(name, argumentCounter, variablesCounter,new LinkedHashMap<>());
    }

    public void addLabel(Label label) {
        labels.put(label.name(), label);
    }
}
