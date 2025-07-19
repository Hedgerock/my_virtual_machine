package my_vm_starter.loader;

import my_vm_internal.Context;
import my_vm_internal.FunctionClass;
import my_vm_internal.instructions.VMInstruction;

import java.util.Arrays;

public class ByteCodeLoader {
    private static final String FUN_TITLE = "fun";
    private static final String COMMENT_TITLE = ";";

    String code;
    Context ctx;
    private FunctionClass functionClass = null;
    private boolean isFirstIteration = true;
    private int ctSize;


    public ByteCodeLoader setCode(String code) {
        this.code = code;

        return this;
    }

    public ByteCodeLoader setCtx(Context ctx) {
        this.ctx = ctx;

        return this;
    }

    public void parse() {

        this.code.lines()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(s -> s.split(" "))
                .forEach(this::initInstruction);

        ctx.addFunction(functionClass);
    }

    private void initInstruction(String[] instruction) {
        if (isFirstIteration) {
            ctSize = Integer.parseInt(instruction[1]);
            isFirstIteration = false;

            return;
        }

        if (ctSize-- >= 0) {
            ctx.addConstant(instruction[0]);
            return;
        }

        switch (instruction[0]) {
            case FUN_TITLE -> executeInstructionForFunTitle(instruction);
            case COMMENT_TITLE -> executeInstructionForComments(instruction);
            default -> executeDefault(instruction);
        }
    }

    private void executeInstructionForFunTitle(String[] instruction) {
        String name = instruction[1];

        if (functionClass != null) {
            ctx.addFunction(functionClass);
        }

        int argc = Integer.parseInt(instruction[2]);
        int varc = Integer.parseInt(instruction[3]);

        functionClass = new FunctionClass(name, argc, varc);
    }

    private void executeInstructionForComments(String[] instruction) {/* TODO add case for ;*/}

    private void executeDefault(String[] instruction) {
        VMInstruction instr = InstructionBuilderResolver
                .resolve(instruction[0])
                .setCtx(ctx)
                .setArgs(Arrays.copyOfRange(instruction, 1, instruction.length))
                .build();

        functionClass.addInstruction(instr);
    }
}
