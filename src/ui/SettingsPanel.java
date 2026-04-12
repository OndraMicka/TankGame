package ui;

import ui.rowsSettings.KeyButtonRow;
import ui.rowsSettings.SettingRowPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

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

    private JPanel container; //panel in scrollPane

    public SettingsPanel(JPanel mainPanel) {
        this.setLayout(new BorderLayout());
        this.add(contentPane, BorderLayout.CENTER);


        container.add(new KeyButtonRow("Move Up", KeyEvent.VK_W));
        container.add(Box.createVerticalGlue());

        container.revalidate();
        container.repaint();

        //text field for names.
        //button for key.
        //checkbox for color mode.
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
}
