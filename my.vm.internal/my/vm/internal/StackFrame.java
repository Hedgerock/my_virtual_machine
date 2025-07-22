package my.vm.internal;

import my.vm.internal.instructions.VMInstruction;
import my.vm.internal.exceptions.ArgumentNotFoundException;

import java.util.Stack;

public class StackFrame {
    private final Stack<Long> stack;
    private final FunctionClass fun;
    private VMInstruction currInstruction;
    private final long[] variables;
    private final Stack<Label> labelStack;

    private StackFrame(Stack<Long> stack, FunctionClass fun, long[] variables) {
        this.stack = stack;
        this.fun = fun;
        this.variables = variables;
        this.labelStack = new Stack<>();
        this.labelStack.push(fun.labels().values().iterator().next());
    }

    public StackFrame(FunctionClass fun, long[] variables) {
        this(new Stack<>(), fun, new long[fun.variablesCounter()]);
        System.arraycopy(
                variables,
                0,
                this.variables,
                0,
                variables.length
        );
    }

    public Stack<Long> stack() {
        return stack;
    }

    public FunctionClass fun() {
        return fun;
    }

    public VMInstruction currentInstruction() {
        return currInstruction;
    }

    public long[] variables() {
        return variables;
    }

    public void push(long value) {
        stack.push(value);
    }

    public void execute() {
        TOP:
        while (!this.labelStack.isEmpty()) {
            Label label = this.labelStack.peek();

            for (VMInstruction vmInstruction: label.code()) {
                this.currInstruction = vmInstruction;

                if (labelStack.isEmpty()) break TOP;

                vmInstruction.invoke();
            }

            if (labelStack.isEmpty()) break;

            this.labelStack.pop();
        }
    }

    public void newLabel(Label label) {
        this.labelStack.push(label);
    }

    public void clearStack() {
        this.labelStack.clear();
    }

    public long pop() {
        if (stack.isEmpty()) {
            throw new ArgumentNotFoundException(this);
        }

        return stack.pop();
    }

    public long top() {
        return stack.peek();
    }
}
