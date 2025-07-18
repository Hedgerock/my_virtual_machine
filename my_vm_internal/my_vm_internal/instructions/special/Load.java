package my_vm_internal.instructions.special;

import my_vm_internal.Context;
import my_vm_internal.instructions.VMInstruction;

public final class Load extends VMInstruction {
    Context ctx;
    long value;

    public Load(Context ctx, long value) {
        this.ctx = ctx;
        this.value = value;
    }

    @Override
    public void execute() {
        this.ctx.push(value);
    }

    @Override
    public void popArgs() {}
}
