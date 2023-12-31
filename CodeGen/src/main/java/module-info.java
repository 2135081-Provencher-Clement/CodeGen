module com.codegen.codegen {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires kotlinx.serialization.core;
    requires kotlinx.serialization.json;

    opens com.codegen.codegen to javafx.fxml;
    exports com.codegen.codegen;
    exports com.codegen.codegen.serializerPersonnalisee.composants;
    exports com.codegen.codegen.serializerPersonnalisee.fichiersCode;
    exports com.codegen.codegen.serializerPersonnalisee.projet;
}