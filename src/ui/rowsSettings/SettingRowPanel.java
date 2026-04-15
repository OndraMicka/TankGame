package ui.rowsSettings;

import javax.swing.*;
import java.awt.*;

public abstract class SettingRowPanel extends JPanel {

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
