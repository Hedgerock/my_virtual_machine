package my.vm.loading.loading.builders;

import my.vm.internal.instructions.ariphmetic.Mul;
import my.vm.internal.instructions.VMInstruction;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

@Instruction("mul")
public class MulBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Mul(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
