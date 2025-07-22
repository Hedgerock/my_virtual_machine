package my.vm.starter.loader;

import my.vm.internal.Context;
import my.vm.internal.FunctionClass;
import my.vm.internal.Label;
import my.vm.internal.instructions.VMInstruction;
import my.vm.loading.utils.exceptions.LoaderError;

import java.util.Arrays;

public class ByteCodeLoader {
    protected static final String FUN_TITLE = "fun";
    protected static final String COMMENT_TITLE = ";";
    protected static final String LABEL_TITLE = "lbl";

    protected String code;
    protected Context ctx;
    protected FunctionClass functionClass = null;
    private Label label = null;
    protected int ctSize;
    private boolean isFirstIteration = true;
    private int line;

    public ByteCodeLoader() {}

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

    public void executeInstructionForFunTitle(String[] instructions) {
        String name = instructions[1];

        validateLabel(instructions, 4);

        if (functionClass != null) {
            ctx.addFunction(functionClass);
        }

        this.line = 1;

        int argc = Integer.parseInt(instructions[2]);
        int varc = Integer.parseInt(instructions[3]);

        functionClass = new FunctionClass(name, argc, varc);
    }
    public void executeInstructionForComments(String[] instruction) {
        this.line++;
    }

    public void executeDefault(String[] instruction) {
        VMInstruction instr = InstructionBuilderResolver
                .resolve(instruction[0])
                .setCtx(ctx)
                .setArgs(Arrays.copyOfRange(instruction, 1, instruction.length))
                .setLine(this.line++)
                .build();

        label.addInstruction(instr);
    }

    private void validateLabel(String[] instructions, int size) {
        if (instructions.length != size) {
            throw new LoaderError("Invalid label " + Arrays.toString(instructions));
        }
    }

    public void executeInstructionForLabel(String[] instructions) {
        validateLabel(instructions, 2);

        label = new Label(instructions[1]);

        functionClass.addLabel(label);
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
            case LABEL_TITLE -> executeInstructionForLabel(instruction);
            default -> executeDefault(instruction);
        }
    }
}
