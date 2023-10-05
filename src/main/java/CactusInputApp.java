import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;

public class CactusInputApp extends JFrame {
    private final CactusManagementService cactusService;
    private final JTextField idTextField;
    private final JTextField speciesTextField;
    private final JTextField genusTextField;
    private final JTextField familyTextField;
    private final JTextField subSpeciesTextField;
    private final JTextField traitsTextField;
    private final JTextField sizeTextField;
    private DefaultTableModel tableModel;

    public CactusInputApp() {
        // Initialize the table model at the beginning of your constructor
        tableModel = new DefaultTableModel();

        cactusService = new CactusManagementService(tableModel);

        // Set up the main application window
        setTitle("Cactus Input");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(930, 600);

        // Create input fields, labels, and buttons
        JLabel titleLabel = new JLabel("Cactus Inventory");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.white);

        JLabel idLabel = new JLabel("ID Number:");
        idTextField = new JTextField(20);
        idTextField.setBackground(new Color(176, 217, 177));
        idLabel.setForeground(Color.white);

        JLabel speciesLabel = new JLabel("Species:");
        speciesTextField = new JTextField(20);
        speciesTextField.setBackground(new Color(176, 217, 177));
        speciesLabel.setForeground(Color.white);

        JLabel genusLabel = new JLabel("Genus:");
        genusTextField = new JTextField(20);
        genusTextField.setBackground(new Color(176, 217, 177));
        genusLabel.setForeground(Color.white);

        JLabel familyLabel = new JLabel("Family:");
        familyTextField = new JTextField(20);
        familyTextField.setBackground(new Color(176, 217, 177));
        familyLabel.setForeground(Color.white);

        JLabel subSpeciesLabel = new JLabel("Subspecies:");
        subSpeciesTextField = new JTextField(20);
        subSpeciesTextField.setBackground(new Color(176, 217, 177));
        subSpeciesLabel.setForeground(Color.white);

        JLabel traitsLabel = new JLabel("Traits:");
        traitsTextField = new JTextField(20);
        traitsTextField.setBackground(new Color(176, 217, 177));
        traitsLabel.setForeground(Color.white);

        JLabel sizeLabel = new JLabel("Size (cm):");
        sizeTextField = new JTextField(20);
        sizeTextField.setBackground(new Color(176, 217, 177));
        sizeLabel.setForeground(Color.white);

        // Add padding to labels and text fields
        idLabel.setBorder(new EmptyBorder(0,0,5,0));
        speciesLabel.setBorder(new EmptyBorder(0, 0, 5, 0));
        genusLabel.setBorder(new EmptyBorder(0, 0, 5, 0));
        familyLabel.setBorder(new EmptyBorder(0, 0, 5, 0));
        subSpeciesLabel.setBorder(new EmptyBorder(0, 0, 5, 0));
        traitsLabel.setBorder(new EmptyBorder(0, 0, 5, 0));
        sizeLabel.setBorder(new EmptyBorder(0, 0, 5, 0));

        idTextField.setBorder(BorderFactory.createCompoundBorder(
                idTextField.getBorder(),
                BorderFactory.createEmptyBorder(5,5,5,5)));
        speciesTextField.setBorder(BorderFactory.createCompoundBorder(
                speciesTextField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        genusTextField.setBorder(BorderFactory.createCompoundBorder(
                genusTextField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        familyTextField.setBorder(BorderFactory.createCompoundBorder(
                familyTextField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        subSpeciesTextField.setBorder(BorderFactory.createCompoundBorder(
                subSpeciesTextField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        traitsTextField.setBorder(BorderFactory.createCompoundBorder(
                traitsTextField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        sizeTextField.setBorder(BorderFactory.createCompoundBorder(
                sizeTextField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // Create a panel to hold the input components
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        inputPanel.setBackground(new Color(121, 172, 120));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        inputPanel.add(titleLabel, gbc);

        gbc.gridy++;
        inputPanel.add(idLabel, gbc);
        gbc.gridx++;
        inputPanel.add(idTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(speciesLabel, gbc);
        gbc.gridx++;
        inputPanel.add(speciesTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(genusLabel, gbc);
        gbc.gridx++;
        inputPanel.add(genusTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(familyLabel, gbc);
        gbc.gridx++;
        inputPanel.add(familyTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(subSpeciesLabel, gbc);
        gbc.gridx++;
        inputPanel.add(subSpeciesTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(traitsLabel, gbc);
        gbc.gridx++;
        inputPanel.add(traitsTextField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(sizeLabel, gbc);
        gbc.gridx++;
        inputPanel.add(sizeTextField, gbc);

        // Create and add the "Add" button
        JButton addButton = new JButton("Add");
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Span 2 columns
        inputPanel.add(addButton, gbc);

        // Create a button to generate a random ID
        JButton generateIdButton = new JButton("Generate Random ID");
        gbc.gridy++;
        inputPanel.add(generateIdButton, gbc);

        // Add an action listener to the "Generate Random ID" button
        generateIdButton.addActionListener(e -> {
            // Generate a unique ID using UUID and populate the ID text field
            clearInputFields();
            String randomId = generateUniqueId();
            idTextField.setText(randomId);
        });

        // Create and add the "Delete" button
        JButton deleteButton = new JButton("Delete");
        gbc.gridy++;
        inputPanel.add(deleteButton, gbc);

        // Create and add the "Update" button
        JButton updateButton = new JButton("Update");
        gbc.gridy++;
        inputPanel.add(updateButton, gbc);

        // Add an action listener to the "Submit" button
        addButton.addActionListener(e -> {
            // Retrieve data from input fields
            String cactusID = idTextField.getText();
            String species = speciesTextField.getText();
            String genus = genusTextField.getText();
            String family = familyTextField.getText();
            String subspecies = subSpeciesTextField.getText();
            String traits = traitsTextField.getText();
            String sizeCm = sizeTextField.getText();

            // Create a new Cactus object with the input data
            Cactus cactus = new Cactus(species, genus, family, subspecies, traits, sizeCm, cactusID);

            // Add the cactus to the service
            cactusService.addCactus(cactus);

            // Optionally, provide feedback to the user
            JOptionPane.showMessageDialog(this, "Cactus added successfully!");
            cactusService.displayAllCactiInTable(tableModel);
            clearInputFields();
        });

        // Add action listeners to the "Delete" and "Update" buttons
        deleteButton.addActionListener(e -> {
            String cactusID = idTextField.getText();
            if (!cactusID.isEmpty()) {
                cactusService.deleteCactus(cactusID);
                JOptionPane.showMessageDialog(this, "Cactus deleted successfully!");
                cactusService.displayAllCactiInTable(tableModel);
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a Cactus ID to delete.");
            }
        });

        updateButton.addActionListener(e -> {
            String cactusID = idTextField.getText();
            if (!cactusID.isEmpty()) {
                String fieldToUpdate = JOptionPane.showInputDialog(this, "Enter the field to update (species, genus, family, subspecies, traits, sizeCm):");
                if (fieldToUpdate != null) {
                    String updatedValue = JOptionPane.showInputDialog(this, "Enter the updated value:");
                    if (updatedValue != null) {
                        try {
                            cactusService.updateCactus(cactusID, fieldToUpdate, updatedValue);
                            JOptionPane.showMessageDialog(this, "Cactus updated successfully!");
                            cactusService.displayAllCactiInTable(tableModel);
                            clearInputFields();
                        } catch (IllegalArgumentException ex) {
                            JOptionPane.showMessageDialog(this, "Invalid field name or value. Update failed.");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a Cactus ID to update.");
            }
        });

        // Create a panel for the table
        JPanel tablePanel = new JPanel(new BorderLayout());

        // Create a table with a default table model
        tableModel = new DefaultTableModel();
        JTable cactusTable = new JTable(tableModel);

        // Add columns to the table model
        tableModel.addColumn("ID");
        tableModel.addColumn("Species");
        tableModel.addColumn("Genus");
        tableModel.addColumn("Family");
        tableModel.addColumn("Subspecies");
        tableModel.addColumn("Traits");
        tableModel.addColumn("Size (cm)");

        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(cactusTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Create a main panel using BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Add the input panel to the main panel on the left
        mainPanel.add(inputPanel, BorderLayout.WEST);

        // Add the table panel to the main panel on the right
        mainPanel.add(tablePanel, BorderLayout.EAST);

        // Add the main panel to the frame's content pane
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private void clearInputFields() {

        idTextField.setText("");
        speciesTextField.setText("");
        genusTextField.setText("");
        familyTextField.setText("");
        subSpeciesTextField.setText("");
        traitsTextField.setText("");
        sizeTextField.setText("");
    }

    private String generateUniqueId() {
        // Generate a unique ID using UUID (Universally Unique Identifier)
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CactusInputApp app = new CactusInputApp();
            app.setVisible(true);
        });
    }
}