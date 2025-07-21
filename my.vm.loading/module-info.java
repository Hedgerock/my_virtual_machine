import my.vm.loading.loading.builders.*;
import my.vm.loading.loading.InstructionBuilder;

module my.vm.loading {
    requires my.vm.internal;

    exports my.vm.loading.utils;
    exports my.vm.loading.loading.builders;
    exports my.vm.loading.loading;

    provides InstructionBuilder with
            InvokeBuilder,
            AddBuilder,
            LogBuilder,
            LoadBuilder,
            SubBuilder,
            DebugBuilder,
            DivBuilder,
            MulBuilder,
            PutBuilder,
            GetBuilder;
}