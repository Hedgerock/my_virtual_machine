package my.vm.loading.loading.builders;

import my.vm.internal.instructions.VMInstruction;
import my.vm.internal.instructions.jumps.Jmpf;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("jmpf")
public final class JmpfBuilder extends InstructionBuilder {
    @Override
    protected VMInstruction construct() {
        return new Jmpf(ctx, args[0]);
    }

    @Override
    protected int getArgsCount() {
        return 1;
    }
}
