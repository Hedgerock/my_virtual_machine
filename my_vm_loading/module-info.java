module my.vm.loading {
    requires my.vm.internal;

    exports my_vm_loading.loading;
    exports my_vm_loading.utils;
    exports my_vm_loading.loading.builders;

    provides my_vm_loading.loading.InstructionBuilder with
            my_vm_loading.loading.builders.InvokeBuilder,
            my_vm_loading.loading.builders.AddBuilder,
            my_vm_loading.loading.builders.LogBuilder,
            my_vm_loading.loading.builders.LoadBuilder,
            my_vm_loading.loading.builders.SubBuilder,
            my_vm_loading.loading.builders.DebugBuilder,
            my_vm_loading.loading.builders.DivBuilder,
            my_vm_loading.loading.builders.MulBuilder;
}