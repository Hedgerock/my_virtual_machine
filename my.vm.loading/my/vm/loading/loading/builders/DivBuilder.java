package my.vm.loading.loading.builders;

import my.vm.internal.instructions.ariphmetic.Div;
import my.vm.internal.instructions.VMInstruction;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("div")
public class DivBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Div(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
