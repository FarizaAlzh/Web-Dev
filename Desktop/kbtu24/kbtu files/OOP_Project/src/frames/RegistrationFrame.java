package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import classes.Courses;

public class RegistrationFrame extends JFrame {
	 Courses Calculus = new Courses("Calculus", 6, "Site");
     Courses English = new Courses("English", 12, "Site");
     Courses data_base = new Courses("Data Base", 5, "Site");
     Courses electrical_foundations = new Courses("Electrical Foundations", 6, "Site");
     Courses PhysicsI = new Courses("Physics I", 9, "Site");
     Courses PhysicsII = new Courses("Physics II", 9, "Site");
     Courses Phe = new Courses("Physical Education", 10, "Site");
    public int full_credit;
	public RegistrationFrame() {
		 SwingUtilities.invokeLater(() -> {
	            Object[][] data = {
	                {Calculus.get_course_name(), Calculus.get_credit(), Calculus.get_department(), false},
	                {English.get_course_name(), English.get_credit(), English.get_department(), false},
	                {data_base.get_course_name(), data_base.get_credit(), data_base.get_department(), false},
	                {electrical_foundations.get_course_name(), electrical_foundations.get_credit(), electrical_foundations.get_department(), false},
	                {PhysicsI.get_course_name(), PhysicsI.get_credit(), PhysicsI.get_department(), false},
	                {PhysicsII.get_course_name(), PhysicsII.get_credit(), PhysicsII.get_department(), false},
	                {Phe.get_course_name(), Phe.get_credit(), Phe.get_department(), false},
	            };

	            String[] columnNames = {"Course Name", "Credits", "Department", "Choose"};
	            DefaultTableModel model = new DefaultTableModel(data, columnNames) {
	                public Class<?> getColumnClass(int columnIndex) {
	                    return columnIndex == 3 ? Boolean.class : Object.class;
	                }
	                public boolean isCellEditable(int row, int column) {
	                    return column == 3;
	                }
	            };

	            JTable tablerg = new JTable(model);
	            tablerg.setRowHeight(25);
	            model.addTableModelListener(e -> {
	                if (e.getType() == TableModelEvent.UPDATE) {
	                    int row = e.getFirstRow();
	                    int column = e.getColumn();
	                    if (column == 3) {
	                        boolean isSelected = (Boolean) model.getValueAt(row, column);
	                        if (isSelected) {
	                            int credits = (int) model.getValueAt(row, 1);
	                            full_credit = full_credit+credits;
	                            System.out.println("Selected credits for now "+ full_credit);
	                        } else {
	                        	int credits = (int) model.getValueAt(row, 1);
	                        	full_credit = full_credit-credits;
	                            System.out.println("Checkbox unchecked for row " + row);
	                        }
	                    }
	                }
	            });
	            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            this.add(new JScrollPane(tablerg));
	            this.setResizable(false);
	            this.setBounds(300,500,800,300);
	            this.setLocationRelativeTo(null);
	            this.setVisible(true);
	        });
		 
		
	}
}
