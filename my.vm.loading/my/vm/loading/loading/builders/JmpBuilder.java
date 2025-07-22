package my.vm.loading.loading.builders;

import my.vm.internal.instructions.VMInstruction;
import my.vm.internal.instructions.jumps.Jmp;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("jmp")
public final class JmpBuilder extends InstructionBuilder {
    @Override
    protected VMInstruction construct() {
        return new Jmp(ctx, args[0]);
    }

    @Override
    protected int getArgsCount() {
        return 1;
    }
}
