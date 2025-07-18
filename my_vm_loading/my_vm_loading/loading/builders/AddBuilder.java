package my_vm_loading.loading.builders;

import my_vm_internal.instructions.ariphmetic.Add;
import my_vm_internal.instructions.VMInstruction;
import my_vm_loading.loading.InstructionBuilder;
import my_vm_loading.utils.Instruction;

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
