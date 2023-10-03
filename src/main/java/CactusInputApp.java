import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.util.UUID;

public class CactusInputApp extends JFrame {
    private CactusManagementService cactusService;

    public CactusInputApp() {
        cactusService = new CactusManagementService();

        // Set up the main application window
        setTitle("Cactus Input");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);

        // Create input fields, labels, and buttons
        JLabel titleLabel = new JLabel("Cactus Inventory");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel idLabel = new JLabel("ID Number:");
        JTextField idTextField = new JTextField(20);

        JLabel speciesLabel = new JLabel("Species:");
        JTextField speciesTextField = new JTextField(20);

        JLabel genusLabel = new JLabel("Genus:");
        JTextField genusTextField = new JTextField(20);

        JLabel familyLabel = new JLabel("Family:");
        JTextField familyTextField = new JTextField(20);

        JLabel subSpeciesLabel = new JLabel("Subspecies:");
        JTextField subSpeciesTextField = new JTextField(20);

        JLabel traitsLabel = new JLabel("Traits:");
        JTextField traitsTextField = new JTextField(20);

        JLabel sizeLabel = new JLabel("Size (cm):");
        JTextField sizeTextField = new JTextField(20);

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

        // Create and add the "Submit" button
        JButton submitButton = new JButton("Submit");
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Span 2 columns
        inputPanel.add(submitButton, gbc);

        // Add an action listener to the "Submit" button
        submitButton.addActionListener(e -> {
            // Retrieve data from input fields
            String species = speciesTextField.getText();
            String genus = genusTextField.getText();
            String family = familyTextField.getText();
            String subspecies = subSpeciesTextField.getText();
            String traits = traitsTextField.getText();
            String sizeCm = sizeTextField.getText();

            // Create a new Cactus object with the input data
            Cactus cactus = new Cactus(species, genus, family, subspecies, traits, sizeCm, generateUniqueId());

            // Add the cactus to the service
            cactusService.addCactus(cactus);

            // Optionally, provide feedback to the user
            JOptionPane.showMessageDialog(this, "Cactus added successfully!");
        });

        // Add the input panel to the frame's content pane
        getContentPane().add(inputPanel, BorderLayout.CENTER);


    }

    private String generateUniqueId() {
        // Generate a unique ID using UUID (Universally Unique Identifier)
        // The chances of collision are extremely low with UUIDs.
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CactusInputApp app = new CactusInputApp();
            app.setVisible(true);
        });
    }
}