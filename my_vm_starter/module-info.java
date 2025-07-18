module my.vm.starter {
    requires my.vm.internal;
    requires my.vm.compiler;
    requires my.vm.loading;

    exports my_vm_starter;
    exports my_vm_starter.loader;
}