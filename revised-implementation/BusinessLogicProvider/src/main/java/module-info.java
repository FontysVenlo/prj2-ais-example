module businesslogicprovider_module {
    requires transitive businessentities_module;
    requires transitive businesslogic_module;
    requires transitive nl.fontys.sebivenlo.genericdao;
//    requires nl.fontys.sebivenlo.genericmapper;
        requires org.postgresql.jdbc;

    requires nl.fontys.sebivenlo.sebiannotations;
    exports businesslogicprovider;
}
