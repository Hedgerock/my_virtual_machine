package my_vm_internal.instructions.special;

import my_vm_internal.Context;
import my_vm_internal.instructions.VMInstruction;

public final class Debug extends VMInstruction {
    Context ctx;
    long value;

    public Debug(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public void execute() {
        System.out.println(this.value);
    }

    @Override
    public void popArgs() {
        this.value = this.ctx.top();
    }
}
