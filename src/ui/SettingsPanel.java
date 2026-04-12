package ui;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    //can switch panels with card layout, so we need reference to main panel
    private JPanel mainPanel;

    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JPanel sidePanelEast;
    private JPanel sidePanelWest;
    private JPanel midlePanel;
    private JPanel buttonsPanel;
    private JButton buttonBack;
    private JButton buttonReset;
    private JButton buttonApply;

    private JPanel container;

    public SettingsPanel(JPanel mainPanel) {
        this.setLayout(new BorderLayout());
        this.add(contentPane, BorderLayout.CENTER);

        for (int i = 1; i <= 20; i++) {
            addRowPanel("Row " + i);
        }
    }

    private void createUIComponents() {
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(container);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        //TODO: add event to buttons
         buttonReset = JButtonFactory.createSettingsButton("Reset", e -> {

        });
        buttonApply = JButtonFactory.createSettingsButton("Apply", e -> {

        });
        buttonBack= JButtonFactory.createSettingsButton("Back", e -> {

        });

    }

    public void addRowPanel(String text) {
        JPanel row = new JPanel(new BorderLayout());
        row.setPreferredSize(new Dimension(0, 50));
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        row.setBorder(BorderFactory.createEtchedBorder());

        row.add(new JLabel(text, SwingConstants.CENTER), BorderLayout.CENTER);

        Component[] components = container.getComponents();
        if (components.length > 0 && components[components.length - 1] instanceof Box.Filler) {
            container.remove(components.length - 1);
        }

        container.add(row);
        container.add(Box.createVerticalGlue());

        container.revalidate();
        container.repaint();
    }
}
