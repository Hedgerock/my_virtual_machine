package my.vm.loading.loading.builders;

import my.vm.internal.instructions.VMInstruction;
import my.vm.internal.instructions.special.variables.Get;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("get")
public class GetBuilder extends InstructionBuilder {
    @Override
    protected VMInstruction construct() {
        return new Get(ctx, Long.parseLong(args[0]));
    }

    @Override
    protected int getArgsCount() {
        return 1;
    }
}
