package my.vm.internal.instructions;

import my.vm.internal.instructions.special.Debug;
import my.vm.internal.instructions.special.Invoke;
import my.vm.internal.instructions.special.Load;
import my.vm.internal.instructions.special.Log;
import my.vm.internal.instructions.special.variables.Get;
import my.vm.internal.instructions.special.variables.Put;

public sealed abstract class VMInstruction permits BinaryInstruction, Debug, Invoke, Load, Log, Get, Put {
    protected int line;
    protected String name;

    protected abstract void execute();
    protected abstract void popArgs();

    public VMInstruction setLine(int line) {
        this.line = line;

        return this;
    }

    public VMInstruction setName(String name) {
        this.name = name;
        return this;
    }

    public void invoke() {
        popArgs();
        execute();
    }

    @Override
    public String toString() {
        return String.format("%s:%d", name, this.line);
    }
}