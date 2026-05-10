package ui.rowsSettings;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A row in the settings panel with a checkbox.
 * Lets you toggle boolean settings.
 */
public class CheckBoxRow extends SettingRowPanel {
    /**
     * Creates a checkbox row.
     * @param displayName the label text
     * @param currentValue the initial checkbox state
     * @param valueReference the reference to update when checkbox changes
     */
    public CheckBoxRow(String displayName, boolean currentValue, AtomicBoolean valueReference) {
        super(displayName);

        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(currentValue);
        add(checkBox, BorderLayout.EAST);

        checkBox.addActionListener(e -> valueReference.set(checkBox.isSelected()));
    }
}
