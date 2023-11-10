module com.codegen.codegen {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.codegen.codegen to javafx.fxml;
    exports com.codegen.codegen;
}