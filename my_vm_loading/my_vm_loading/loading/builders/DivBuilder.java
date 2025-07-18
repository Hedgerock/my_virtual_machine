package my_vm_loading.loading.builders;

import my_vm_internal.instructions.ariphmetic.Div;
import my_vm_internal.instructions.VMInstruction;
import my_vm_loading.loading.InstructionBuilder;
import my_vm_loading.utils.Instruction;

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
