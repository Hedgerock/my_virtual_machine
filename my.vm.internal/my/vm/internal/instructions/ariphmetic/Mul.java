package my.vm.internal.instructions.ariphmetic;

import my.vm.internal.Context;
import my.vm.internal.instructions.BinaryInstruction;

public final class Mul extends BinaryInstruction {
    public Mul(Context ctx) {
        super(ctx);
    }

    @Override
    protected long calc() {
        return this.lhs * this.rhs;
    }
}
