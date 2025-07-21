package my.vm.internal.exceptions;

import my.vm.internal.StackFrame;

public class ArgumentNotFoundException extends RuntimeException {
  private static final String TEMPLATE_OF_STACK_TRACE = "at %s.%s";

  public ArgumentNotFoundException(StackFrame stackFrame) {
    super(String.format("Argument in stack is not found!\n" + TEMPLATE_OF_STACK_TRACE,
            stackFrame.fun().name(), stackFrame.currentInstruction()));
  }

  public ArgumentNotFoundException(ArgumentNotFoundException e, StackFrame stackFrame) {
    super(
            String.format("%s\n", e.getMessage()) +
            String.format(TEMPLATE_OF_STACK_TRACE, stackFrame.fun().name(), stackFrame.currentInstruction())
    );
  }
}
