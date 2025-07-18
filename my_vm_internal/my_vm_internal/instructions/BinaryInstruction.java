package my_vm_internal.instructions;

import my_vm_internal.Context;
import my_vm_internal.instructions.ariphmetic.Add;
import my_vm_internal.instructions.ariphmetic.Div;
import my_vm_internal.instructions.ariphmetic.Mul;
import my_vm_internal.instructions.ariphmetic.Sub;

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
