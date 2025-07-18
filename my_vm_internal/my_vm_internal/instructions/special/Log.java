package my_vm_internal.instructions.special;

import my_vm_internal.Context;
import my_vm_internal.instructions.VMInstruction;

public final class Log extends VMInstruction {
    Context ctx;
    long value;

    public Log(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public void execute() {
        System.out.println(this.value);
    }

    @Override
    public void popArgs() {
        this.value = this.ctx.pop();
    }
}
