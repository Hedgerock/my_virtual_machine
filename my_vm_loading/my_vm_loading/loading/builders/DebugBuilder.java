package my_vm_loading.loading.builders;

import my_vm_internal.instructions.special.Debug;
import my_vm_internal.instructions.VMInstruction;
import my_vm_loading.loading.InstructionBuilder;
import my_vm_loading.utils.Instruction;

@Instruction("deb")
public class DebugBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Debug(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
