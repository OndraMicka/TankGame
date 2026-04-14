package ui.rowsSettings;

import core.MyReferenceString;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * created by github copilot
 */
public class TextFieldRow extends SettingRowPanel {
    public TextFieldRow(String displayName, MyReferenceString valueReference) {
        super(displayName);

        JTextField textField = new JTextField(valueReference.toString());
        add(textField, BorderLayout.EAST);

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateValue();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateValue();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateValue();
            }

            private void updateValue() {
                valueReference.setValue(textField.getText());
            }
        });
    }
}
