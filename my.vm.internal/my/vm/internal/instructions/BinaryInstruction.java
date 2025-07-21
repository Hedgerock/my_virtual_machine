package my.vm.internal.instructions;

import my.vm.internal.Context;
import my.vm.internal.instructions.ariphmetic.Add;
import my.vm.internal.instructions.ariphmetic.Div;
import my.vm.internal.instructions.ariphmetic.Mul;
import my.vm.internal.instructions.ariphmetic.Sub;

public abstract sealed class BinaryInstruction extends VMInstruction permits Add, Div, Mul, Sub {
    protected Context ctx;
    protected long rhs;
    protected long lhs;

    public BinaryInstruction(Context ctx) {
        this.ctx = ctx;
    }

    abstract protected long calc();

    @Override
    public void popArgs() {
        this.rhs = ctx.pop();
        this.lhs = ctx.pop();
    }

    @Override
    public void execute() {
        ctx.push(calc());
    }
}
