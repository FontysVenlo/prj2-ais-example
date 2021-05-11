module businesslogic_module {   
    requires transitive businessentities_api_module;
    requires transitive persistence_module;
    
    exports businesslogic;
}
