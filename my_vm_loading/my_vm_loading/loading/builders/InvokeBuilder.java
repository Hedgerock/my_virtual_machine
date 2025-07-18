package my_vm_loading.loading.builders;

import my_vm_internal.instructions.VMInstruction;
import my_vm_internal.instructions.special.Invoke;
import my_vm_loading.loading.InstructionBuilder;
import my_vm_loading.utils.Instruction;

import java.util.Arrays;

@Instruction("invoke")
public class InvokeBuilder extends InstructionBuilder {

    @Override
    protected VMInstruction construct() {
        if (args[0].charAt(0) != '#') {
            throw new IllegalArgumentException("Invalid constant id " + Arrays.toString(args));
        }

        long id = Long.parseLong(args[0].substring(1));
        return new Invoke(ctx, id);
    }

    @Override
    protected int getArgsCount() {
        return 1;
    }
}
