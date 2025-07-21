package my.vm.loading.loading.builders;

import my.vm.internal.instructions.ariphmetic.Add;
import my.vm.internal.instructions.VMInstruction;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("add")
public class AddBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Add(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
