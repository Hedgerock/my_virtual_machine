package my_vm_internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public record Context(
        Stack<StackFrame> stack,
        Map<String, FunctionClass> funTable,
        Map<Long, String> constantTable
) {

    public Context() {
        this(new Stack<>(), new HashMap<>(), new HashMap<>());
    }

    private StackFrame peekStack() {
        return stack.peek();
    }

    public void push(long value) {
        peekStack().push(value);
    }

    public long pop() {
        return peekStack().pop();
    }

    public long top() {
        return peekStack().top();
    }

    public void addFunction(FunctionClass fun) {
        this.funTable.put(fun.name(), fun);
    }

    public void deleteFrame() {
        stack.pop();
    }

    public void executeFrame() {
        stack.peek().execute();
        deleteFrame();
    }

    private void initFrameConnection(FunctionClass currenFunction) {
        StackFrame frame = new StackFrame(currenFunction, new long[0]);
        stack.add(frame);
    }

    public void start() {
        FunctionClass main = funTable.get("main");
        initFrameConnection(main);

        executeFrame();
    }

    public void addConstant(String constant) {
        constantTable.put((long) constantTable.size(), constant);
    }

    public FunctionClass getFunctionById(long id) {
        String value = constantTable.get(id);
        return funTable.get(value);
    }

    private long[] getVariables() {
        return stack.peek().variables();
    }

    public long getVar(long index) {
        return getVariables()[(int) index];
    }

    public void setVar(long index, long value) {
        getVariables()[(int) index] = value;
    }

    public void invoke(long id) {
        FunctionClass executableFunc = getFunctionById(id);
        int totalArguments = executableFunc.argumentCounter();
        long[] argumentValues = new long[totalArguments];

        for (int i = totalArguments - 1; i >= 0; --i) {
            argumentValues[i] = pop();
        }

        StackFrame frame = new StackFrame(executableFunc, argumentValues);
        stack.push(frame);


        executeFrame();
    }
}
