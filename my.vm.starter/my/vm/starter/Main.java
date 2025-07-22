package my.vm.starter;

import my.vm.compiler.Preprocessor;
import my.vm.internal.Context;
import my.vm.starter.loader.ByteCodeLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {

    private static String getCode(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found " + fileName);
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) throw new IllegalArgumentException("No arguments found " + Arrays.toString(args));

        String test = getCode(args[0]);
        Preprocessor cp = new Preprocessor().setCode(test);
        String constantTable = cp.getConstantTable();

        Context ctx = new Context();
        new ByteCodeLoader().setCode(constantTable).setCtx(ctx).parse();

        ctx.start();
    }

}