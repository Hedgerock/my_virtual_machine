package my.vm.internal;

import my.vm.internal.instructions.VMInstruction;

import java.util.LinkedList;
import java.util.List;

public record Label(
        String name,
        List<VMInstruction> code
) {

    public Label(String name) {
        this(name, new LinkedList<>());
    }

    public void addInstruction(VMInstruction vmInstruction) {
        this.code.add(vmInstruction);
    }
}
