package my.vm.loading.loading.builders;

import my.vm.internal.instructions.VMInstruction;
import my.vm.internal.instructions.jumps.Invoke;
import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;

import java.util.Arrays;

@Instruction("invoke")
public final class InvokeBuilder extends InstructionBuilder {

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
