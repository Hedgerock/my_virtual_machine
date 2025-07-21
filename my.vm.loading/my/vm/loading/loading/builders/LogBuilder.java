package my.vm.loading.loading.builders;

import my.vm.internal.instructions.special.Log;
import my.vm.internal.instructions.VMInstruction;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("log")
public class LogBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Log(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
