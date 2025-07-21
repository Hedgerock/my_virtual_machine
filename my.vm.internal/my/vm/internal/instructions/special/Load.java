package my.vm.internal.instructions.special;

import my.vm.internal.Context;
import my.vm.internal.instructions.VMInstruction;

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
