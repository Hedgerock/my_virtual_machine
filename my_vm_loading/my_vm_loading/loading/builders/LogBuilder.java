package my_vm_loading.loading.builders;

import my_vm_internal.instructions.special.Log;
import my_vm_internal.instructions.VMInstruction;
import my_vm_loading.loading.InstructionBuilder;
import my_vm_loading.utils.Instruction;

@Instruction("log")
public class LogBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        return new Log(ctx);
    }

    @Override
    protected int getArgsCount() {
        return 0;
    }
}
