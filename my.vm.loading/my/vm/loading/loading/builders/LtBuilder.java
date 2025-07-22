package my.vm.loading.loading.builders;

import my.vm.internal.instructions.VMInstruction;
import my.vm.internal.instructions.conditional.LessThan;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("lt")
public final class LtBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new LessThan(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
