package my.vm.loading.loading;

import my.vm.internal.Context;
import my.vm.internal.instructions.VMInstruction;
import my.vm.loading.loading.builders.*;
import my.vm.loading.utils.Instruction;

import java.util.Arrays;

public sealed abstract class InstructionBuilder permits AddBuilder, DebugBuilder, DivBuilder, GetBuilder, InvokeBuilder, JmpBuilder, JmpfBuilder, LoadBuilder, LogBuilder, LtBuilder, MulBuilder, PutBuilder, RetBuilder, SubBuilder
{
    protected Context ctx;
    protected String[] args;
    protected int line;

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

    public InstructionBuilder setLine(int line) {
        this.line = line;
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
        return construct()
                .setName(this.getClass().getAnnotation(Instruction.class).value())
                .setLine(this.line);
    }


}
