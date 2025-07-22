package my.vm.loading.loading.builders;

import my.vm.internal.instructions.VMInstruction;
import my.vm.internal.instructions.special.variables.Put;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("put")
public final class PutBuilder extends InstructionBuilder {
    @Override
    protected VMInstruction construct() {
        return new Put(ctx, Long.parseLong(args[0]));
    }

    @Override
    protected int getArgsCount() {
        return 1;
    }
}
