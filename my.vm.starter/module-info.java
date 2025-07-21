module my.vm.starter {
    requires my.vm.internal;
    requires my.vm.compiler;
    requires my.vm.loading;

    exports my.vm.starter;
    exports my.vm.starter.loader;
}