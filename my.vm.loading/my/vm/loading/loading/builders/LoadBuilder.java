package my.vm.loading.loading.builders;

import my.vm.internal.instructions.special.Load;
import my.vm.internal.instructions.VMInstruction;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("ld")
public final class LoadBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        long value = Long.parseLong(this.args[0]);
        return new Load(this.ctx, value);
    }

    @Override
    protected int getArgsCount() {
        return 1;
    }
}
