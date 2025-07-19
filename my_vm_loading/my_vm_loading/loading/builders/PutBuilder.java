package my_vm_loading.loading.builders;

import my_vm_internal.instructions.VMInstruction;
import my_vm_internal.instructions.special.variables.Put;
import my_vm_loading.loading.InstructionBuilder;
import my_vm_loading.utils.Instruction;

@Instruction("put")
public class PutBuilder extends InstructionBuilder {
    @Override
    protected VMInstruction construct() {
        return new Put(ctx, Long.parseLong(args[0]));
    }

    @Override
    protected int getArgsCount() {
        return 1;
    }
}
