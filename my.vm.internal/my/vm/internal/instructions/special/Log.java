package my.vm.internal.instructions.special;

import my.vm.internal.Context;
import my.vm.internal.instructions.VMInstruction;

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
