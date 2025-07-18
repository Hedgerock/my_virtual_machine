package my_vm_internal;

import my_vm_internal.instructions.VMInstruction;

import java.util.LinkedList;
import java.util.List;

public record FunctionClass(
        String name,
        List<VMInstruction> instructions
) {
    public FunctionClass(String name) {
        this(name, new LinkedList<>());
    }

    public void execute() {
        instructions.forEach(VMInstruction::invoke);
    }

    public void addInstruction(VMInstruction instruction) {
        instructions.add(instruction);
    }
}
