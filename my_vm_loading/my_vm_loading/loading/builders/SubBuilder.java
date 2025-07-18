package my_vm_loading.loading.builders;

import my_vm_internal.instructions.ariphmetic.Sub;
import my_vm_internal.instructions.VMInstruction;
import my_vm_loading.loading.InstructionBuilder;
import my_vm_loading.utils.Instruction;

@Instruction("sub")
public class SubBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Sub(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
