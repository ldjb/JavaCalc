import javax.swing.*;
public class CalcGUI extends JFrame {

	public CalcGUI() {
		initComponents();
	}

	private void initComponents() {

		TextField = new JTextField();
		Button = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Java Calculator");
		setResizable(false);

		TextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		TextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TextFieldActionPerformed(evt);
			}
		});

		Button.setText("Calculate");
		Button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		Button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ButtonActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(
						  GroupLayout.Alignment.CENTER)
					.addComponent(Button)
					.addComponent(TextField, GroupLayout.DEFAULT_SIZE,
								  388, Short.MAX_VALUE))
				.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(TextField, GroupLayout.PREFERRED_SIZE,
							  GroupLayout.DEFAULT_SIZE,
							  GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(Button)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
	}

	private void TextFieldActionPerformed(java.awt.event.ActionEvent evt) {
		TextField.setText(CalcIO.process(TextField.getText()));
		TextField.requestFocus();
		TextField.selectAll();
	}

	private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {
		TextField.setText(CalcIO.process(TextField.getText()));
		TextField.requestFocus();
		TextField.selectAll();
	}

	public static void initAll() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CalcGUI().setVisible(true);
			}
		});
	}

	private JButton Button;
	private JTextField TextField;

}