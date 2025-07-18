package my_vm_loading.loading.builders;

import my_vm_internal.instructions.ariphmetic.Mul;
import my_vm_internal.instructions.VMInstruction;
import my_vm_loading.loading.InstructionBuilder;
import my_vm_loading.utils.Instruction;

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
