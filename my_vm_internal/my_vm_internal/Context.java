package my_vm_internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public record Context(
        Stack<Long> stack,
        Map<String, FunctionClass> funTable,
        Map<Long, String> constantTable
) {

    public Context() {
        this(new Stack<>(), new HashMap<>(), new HashMap<>());
    }

    public void push(long value) {
        stack.push(value);
    }

    public long pop() {
        return stack.pop();
    }

    public long top() {
        return stack.peek();
    }

    public void addFunction(FunctionClass fun) {
        this.funTable.put(fun.name(), fun);
    }

    public void start() {
        funTable.get("main").execute();
    }

    public void addConstant(String constant) {
        constantTable.put((long) constantTable.size(), constant);
    }

    public FunctionClass getFunctionById(long id) {
        String value = constantTable.get(id);
        return funTable.get(value);
    }
}
