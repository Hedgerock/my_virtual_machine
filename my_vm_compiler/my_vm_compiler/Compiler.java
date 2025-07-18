package my_vm_compiler;

import java.util.*;

public class Compiler {
    private static final String CONSTANT_TABLE_KEY_WORD = "invoke";

    private static final int CONSTANT_TABLE_KEY_WORD_SIZE = CONSTANT_TABLE_KEY_WORD.length();
    private static final int CONSTANT_TABLE_KEY_WORD_SIZE_INDEX_VALUE = CONSTANT_TABLE_KEY_WORD_SIZE + 1;

    String code;

    private final List<String> constants = new LinkedList<>();
    private final Set<String> added = new HashSet<>();

    public String getConstantTable() {
        code.lines()
                .map(String::trim)
                .filter(this::initFilterChain)
                .map(s -> s.substring(CONSTANT_TABLE_KEY_WORD_SIZE_INDEX_VALUE))
                .forEach(constants::add);

        initConstantIndexing();

        StringJoiner sj = new StringJoiner(
                "\n",
                "% " + constants.size() + "\n",
                "\n%\n"
        );

        constants.forEach(sj::add);

        return sj + code;
    }

    private void initConstantIndexing() {
        int i = 0;

        for (String currentConstant: constants) {
            code = code.replace(
                    String.format("%s %s", CONSTANT_TABLE_KEY_WORD, currentConstant),
                    String.format("%s #%d", CONSTANT_TABLE_KEY_WORD, i++)
            );
        }
    }

    private String getTarget(String s) {
        return s.substring(0, CONSTANT_TABLE_KEY_WORD_SIZE);
    }

    private boolean initFilterChain(String s) {

        return !s.isEmpty()
                && s.length() > CONSTANT_TABLE_KEY_WORD_SIZE_INDEX_VALUE
                && CONSTANT_TABLE_KEY_WORD.equals(getTarget(s))
                && added.add(s);
    }

    public Compiler setCode(String code) {
        this.code = code;
        return this;
    }
}
