package my_vm_internal.instructions;

import my_vm_internal.instructions.special.Debug;
import my_vm_internal.instructions.special.Invoke;
import my_vm_internal.instructions.special.Load;
import my_vm_internal.instructions.special.Log;
import my_vm_internal.instructions.special.variables.Get;
import my_vm_internal.instructions.special.variables.Put;

public sealed abstract class VMInstruction permits BinaryInstruction, Debug, Invoke, Load, Log, Get, Put {
    protected abstract void execute();
    protected  abstract void popArgs();

    public void invoke() {
        popArgs();
        execute();
    }
}
