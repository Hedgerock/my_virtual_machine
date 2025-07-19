package my_vm_internal.instructions.special.variables;

import my_vm_internal.Context;
import my_vm_internal.instructions.VMInstruction;

public final class Get extends VMInstruction {
    Context ctx;
    long index;

    public Get(Context ctx, long index) {
        this.ctx = ctx;
        this.index = index;
    }

    @Override
    public void execute() {
        this.ctx.push(ctx.getVar(index));
    }

    @Override
    public void popArgs() {}
}
