package my.vm.internal.instructions.ariphmetic;

import my.vm.internal.Context;
import my.vm.internal.instructions.BinaryInstruction;

public final class Sub extends BinaryInstruction {

    public Sub(Context ctx) {
        super(ctx);
    }

    @Override
    protected long calc() {
        return this.lhs - this.rhs;
    }
}
