package my.vm.internal.instructions.jumps;

import my.vm.internal.Context;
import my.vm.internal.Label;
import my.vm.internal.instructions.VMInstruction;

public final class Jmp extends VMInstruction {
    private final Context ctx;
    private final String label;

    public Jmp(Context ctx, String label) {
        this.ctx = ctx;
        this.label = label;
    }

    @Override
    protected void execute() {
        Label newLabel = ctx.getLabel(label);

        ctx.stack().peek().newLabel(newLabel);
        ctx.stack().peek().execute();

    }

    @Override
    protected void popArgs() {
        //Ignore
    }
}
