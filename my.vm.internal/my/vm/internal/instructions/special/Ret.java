package my.vm.internal.instructions.special;

import my.vm.internal.Context;
import my.vm.internal.instructions.VMInstruction;

public final class Ret extends VMInstruction {
    private final Context ctx;

    public Ret(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void execute() {
        ctx.stack().peek().clearStack();
        ctx.returnFuncResult();
    }

    @Override
    protected void popArgs() {
    }
}
