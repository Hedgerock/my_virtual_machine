package my.vm.internal;

import my.vm.internal.instructions.VMInstruction;

import java.util.LinkedList;
import java.util.List;

public record FunctionClass(
        String name,
        int argumentCounter,
        int variablesCounter,
        List<VMInstruction> instructions
) {
    public FunctionClass(String name, int argumentCounter, int variablesCounter) {
        this(name, argumentCounter, variablesCounter,new LinkedList<>());
    }

    public void addInstruction(VMInstruction instruction) {
        instructions.add(instruction);
    }
}
