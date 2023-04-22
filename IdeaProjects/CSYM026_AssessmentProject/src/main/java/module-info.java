module grp.work {
    requires javafx.controls;
    requires javafx.fxml;


    opens grp.work to javafx.fxml;
    exports grp.work;
    exports grp.work.model;
    opens grp.work.model to javafx.fxml;
}