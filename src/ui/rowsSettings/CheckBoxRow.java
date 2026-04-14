package ui.rowsSettings;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CheckBoxRow extends SettingRowPanel {
    public CheckBoxRow(String displayName, boolean currentValue, AtomicBoolean valueReference) {
        super(displayName);

        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(currentValue);
        add(checkBox, BorderLayout.EAST);

        checkBox.addActionListener(e -> valueReference.set(checkBox.isSelected()));
    }
}
