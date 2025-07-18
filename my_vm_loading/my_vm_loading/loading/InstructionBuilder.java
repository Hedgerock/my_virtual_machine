package my_vm_loading.loading;

import my_vm_internal.Context;
import my_vm_internal.instructions.VMInstruction;

import java.util.Arrays;

public abstract class InstructionBuilder {
    protected Context ctx;
    protected String[] args;

    protected abstract VMInstruction construct();
    protected abstract int getArgsCount();

    public InstructionBuilder setArgs(String... args) {
        this.args = args;
        return this;
    }

     public InstructionBuilder setCtx(Context ctx) {
         this.ctx = ctx;

         return this;
     }

    public VMInstruction build() {
        if (args.length != getArgsCount()) {
            throw new IllegalStateException(
                    String.format("[%s]: Invalid arg count: %s",
                            this.getClass().getName(),
                            Arrays.toString(args)
                    ));
        }
        return construct();
    }


}
