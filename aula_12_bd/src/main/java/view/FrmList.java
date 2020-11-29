package view;

import controller.VeiculosController;
import model.Veiculo;
import repository.RepositorioVeiculos;

import javax.swing.*;
import java.util.List;

public class FrmList {
    private JList<Veiculo> list1;
    private JPanel panel1;

    public FrmList(VeiculosController veiculosController, List<Veiculo> veiculos) {
        DefaultListModel<Veiculo> defaultListModel = new DefaultListModel<>();
        veiculos.forEach(defaultListModel::addElement);
        list1.setModel(defaultListModel);
        list1.addListSelectionListener(listSelectionEvent -> {
            if (!listSelectionEvent.getValueIsAdjusting()) {
                new EditForm(veiculosController, list1.getModel().getElementAt(listSelectionEvent.getFirstIndex())).show();
            }
        });
    }

    public void show() {
        JFrame frame = new JFrame();
        frame.setContentPane(this.panel1);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(400, 420);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Lista de veículos");
        frame.setVisible(true);
    }
}
