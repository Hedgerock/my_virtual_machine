package my_vm_internal;

import java.util.Stack;

public record StackFrame(
        Stack<Long> stack,
        FunctionClass fun,
        long[] variables
) {
    public StackFrame(FunctionClass fun, long[] variables) {
        this(new Stack<>(), fun, new long[fun.variablesCounter()]);
        System.arraycopy(variables, 0, this.variables, 0, variables.length);
    }

    public void push(long value) {
        stack.push(value);
    }

    public void execute() {
        fun.execute();
    }

    public long pop() {
        return stack.pop();
    }

    public long top() {
        return stack.peek();
    }
}
