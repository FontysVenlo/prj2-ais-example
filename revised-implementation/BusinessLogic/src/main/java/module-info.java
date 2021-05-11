module businesslogic_module {   
    requires transitive businessentities_module;
    requires transitive nl.fontys.sebivenlo.genericmapper;
    requires transitive nl.fontys.sebivenlo.genericdao;
    exports businesslogic;
}
