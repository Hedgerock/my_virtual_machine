package my.vm.compiler;

import java.util.List;

public class Compiler {
    private Function currentFunction;
    private String code;
    private List<String> listAfterCompileMethod; //TODO mb rename

    private Function parseFuncDeclaration(String funcDeclaration) {
        String[] decls = funcDeclaration.split("\\(");

        var funName = decls[0].trim();
        Function fun = new Function(funName);

        String args = decls[1].split("\\)")[0].trim();

        int startIdx = 0;

        for (int i = 0; i < args.length(); ++i) {
            if (args.charAt(i) == ',') {
                String argName = args.substring(startIdx, i).trim();
                fun.addVar(argName);
                startIdx = i;
            } else {
                //Do nothing
            }
        }

        String lastArg = args.substring(startIdx).trim();

        if (!lastArg.isEmpty()) {
            fun.addVar(lastArg);
        }

        return new Function(fun, fun.variables().size());
    }

    public List<String> compile() {
        this.code.lines()
                .forEach( line -> {
                    // TODO some magic
                });

        return listAfterCompileMethod;
    }
}
