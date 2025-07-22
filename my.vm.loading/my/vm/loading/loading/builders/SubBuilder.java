package my.vm.loading.loading.builders;

import my.vm.internal.instructions.ariphmetic.Sub;
import my.vm.internal.instructions.VMInstruction;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("sub")
public final class SubBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Sub(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
