package my_vm_starter;

import my_vm_compiler.Compiler;
import my_vm_internal.Context;
import my_vm_starter.loader.ByteCodeLoader;

public class Main {

    static String test = """
            fun main
                ld 7
                ld 5
                add
                deb
                ld 2
                sub
                log
                invoke echo
            
            fun echo
                ld 5
                deb
                deb
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