package my_vm_internal.instructions.special.variables;

import my_vm_internal.Context;
import my_vm_internal.instructions.VMInstruction;

public final class Put extends VMInstruction {
    Context ctx;
    long index;
    long value;

    public Put(Context ctx, long index) {
        this.ctx = ctx;
        this.index = index;
    }

    @Override
    public void execute() {
        this.ctx.setVar(index, value);
    }

    @Override
    public void popArgs() {
        this.value = ctx.pop();
    }
}
