package my_vm_starter;

import my_vm_compiler.Compiler;
import my_vm_internal.Context;
import my_vm_starter.loader.ByteCodeLoader;

public class Main {

    static String test = """
            fun main 0 1
                ld 7
                put 0
                ld 5
                invoke echo
                ld 8
                get 0
                add
                log
            
            fun echo 1 1
                get 0
                log
            """;

    public static void main(String[] args) {
        Compiler cp = new Compiler().setCode(test);
        String constantTable = cp.getConstantTable();

        Context ctx = new Context();
        new ByteCodeLoader().setCode(constantTable).setCtx(ctx).parse();

        ctx.start();
    }

}