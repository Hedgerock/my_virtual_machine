package my.vm.loading.loading.builders;

import my.vm.internal.instructions.special.Debug;
import my.vm.internal.instructions.VMInstruction;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("deb")
public final class DebugBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Debug(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
