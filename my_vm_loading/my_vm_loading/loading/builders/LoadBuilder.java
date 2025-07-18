package my_vm_loading.loading.builders;

import my_vm_internal.instructions.special.Load;
import my_vm_internal.instructions.VMInstruction;
import my_vm_loading.loading.InstructionBuilder;
import my_vm_loading.utils.Instruction;

@Instruction("ld")
public class LoadBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        long value = Long.parseLong(this.args[0]);
        return new Load(this.ctx, value);
    }

    @Override
    protected int getArgsCount() {
        return 1;
    }
}
