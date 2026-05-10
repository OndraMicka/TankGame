package ui.rowsSettings;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class for a settings row.
 * Used as a base for different types of setting rows (checkbox, text field...).
 * Provides common styling and layout for all setting rows.
 */
public abstract class SettingRowPanel extends JPanel {

    /**
     * Creates a setting row with a label on the left.
     * @param displayName the label text to show
     */
    public SettingRowPanel(String displayName) {
        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(0, 50));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(new Color(48,48,48));

        JLabel text = new JLabel(displayName);
        text.setForeground(new Color(189, 189, 189));
        add(text, BorderLayout.WEST);
        setVisible(true);
    }

}
