package my.vm.internal.instructions.conditional;

import my.vm.internal.Context;
import my.vm.internal.instructions.BinaryInstruction;

public final class LessThan extends BinaryInstruction {
    public LessThan(Context ctx) {
        super(ctx);
    }
    @Override
    protected long calc() {
        return lhs < rhs ? 1 : 0;
    }
}
