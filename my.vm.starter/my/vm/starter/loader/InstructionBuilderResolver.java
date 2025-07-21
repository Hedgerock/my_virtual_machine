package my.vm.starter.loader;

import my.vm.loading.loading.InstructionBuilder;
import my.vm.loading.utils.Instruction;
import my.vm.starter.PackageScanner;

import java.util.HashMap;
import java.util.Map;

public final class InstructionBuilderResolver {
    static Map<String, InstructionBuilder> builders = new HashMap<>();

    static {
        PackageScanner packageScanner = new PackageScanner("my.vm.loading.loading.builders");
        packageScanner.findImplementation(InstructionBuilder.class)
                .forEach(InstructionBuilderResolver::initializeBuilders);

    }

    private static void initializeBuilders(Class<? extends InstructionBuilder> clazz) {
        if (clazz.isAnnotationPresent(Instruction.class)) {
            String name = clazz.getDeclaredAnnotation(Instruction.class).value();

            try {
                builders.put(name, clazz.getDeclaredConstructor().newInstance());
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static InstructionBuilder resolve(String instructionName) {
        if (builders.containsKey(instructionName)) {
            return builders.get(instructionName);
        }

        throw new IllegalArgumentException("Instruction not found " + instructionName);
    }

}
