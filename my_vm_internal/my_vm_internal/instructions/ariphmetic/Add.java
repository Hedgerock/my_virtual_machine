package my_vm_internal.instructions.ariphmetic;

import my_vm_internal.Context;
import my_vm_internal.instructions.BinaryInstruction;

public final class Add extends BinaryInstruction {

    public Add(Context ctx) {
        super(ctx);
    }

    @Override
    protected long calc() {
        return this.lhs + this.rhs;
    }
}
