package my.vm.loading.loading.builders;

import my.vm.internal.instructions.VMInstruction;
import my.vm.internal.instructions.special.Ret;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("ret")
public final class RetBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Ret(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
