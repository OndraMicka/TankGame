package ui.rowsSettings;

import javax.swing.*;
import java.awt.*;

public class LabelRow extends SettingRowPanel {

    public LabelRow(String displayName) {
        super(displayName);

        this.removeAll();
        this.setLayout(new BorderLayout());
        Label label = new Label(displayName);
        label.setAlignment(Label.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBackground(new Color(42, 66, 31));
        label.setForeground(new Color(189, 189, 189));
        this.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2));
        this.add(label, BorderLayout.CENTER);
    }
}
