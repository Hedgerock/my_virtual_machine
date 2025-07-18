package my_vm_starter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PackageScanner {
    private final String packageName;

    public PackageScanner(String packageName) {
        this.packageName = packageName;
    }

    public<T> List<Class<? extends T>> findImplementation(Class<T> tClass) {
        List<Class<? extends T>> classes = new ArrayList<>();

        String path = "my_vm_loading/" + this.packageName.replace(".", "/");
        File dir = new File(path);

        if (!dir.exists()) throw new IllegalArgumentException(this.packageName + " not found");

        for (File file: Objects.requireNonNull(dir.listFiles())) {
            String fileName = file.getName();

            if (fileName.endsWith(".java")) {
                try {
                    String className = this.packageName + "." + fileName.replace(".java", "");
                    Class<?> value = Class.forName(className);

                    if (tClass.isAssignableFrom(value)) {
                        classes.add((Class<? extends T>) value);
                    }

                } catch (Exception e) {
                    throw new IllegalArgumentException("Class not found " + e);
                }
            }
        }

        return classes;
    }

}
