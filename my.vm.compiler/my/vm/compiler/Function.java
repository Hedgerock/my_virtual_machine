package my.vm.compiler;

import java.util.HashMap;
import java.util.Map;

public record Function(
        String name,
        int argc,
        Map<String, Integer> variables
) {

    public Function(String name) {
        this(name, 0, new HashMap<>());
    }

    public Function(Function fun, int argc) {
        this(fun.name, argc, fun.variables);
    }

    public int addVar(String varName) {
        if (variables.containsKey(varName)) {
            return getVariable(varName);
        }

        variables.put(varName, variables.size() - 1);

        return getVariable(varName);
    }

    public int getVariable(String varName) {
        return variables.getOrDefault(varName, -1);
    }

}

