package my_vm_internal.instructions.special;

import my_vm_internal.Context;
import my_vm_internal.instructions.VMInstruction;

public final class Invoke extends VMInstruction {
    private final Context ctx;
    private final long id;

    public Invoke(Context ctx, long id) {
        this.ctx = ctx;
        this.id = id;
    }

    @Override
    protected void execute() {
        ctx.invoke(id);
    }

    @Override
    protected void popArgs() {}
}
