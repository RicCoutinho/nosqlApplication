package view;

import controller.VeiculosController;
import model.Veiculo;
import repository.RepositorioVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditForm {
    private JTextField textField1;
    private JPanel jPanel;
    private JButton salvarButton;
    private JButton deletarButton;
    private Veiculo veiculo;
    private VeiculosController veiculosController;

    private JFrame jFrame;

    public EditForm(VeiculosController veiculosController, Veiculo veiculo) {
        this.veiculo = veiculo;
        this.veiculosController = veiculosController;
        this.textField1.setText(veiculo.getPlaca());

        this.salvarButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                veiculo.setPlaca(textField1.getText());
                 veiculosController.salvar(veiculo);
            }
        });

        this.deletarButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                veiculosController.deletar(veiculo);
                EditForm.this.jFrame.setVisible(false);
                EditForm.this.jFrame.dispose();
            }
        });
    }

    public void show() {
        this.jFrame = new JFrame();
        this.jFrame.setContentPane(this.jPanel);
        this.jFrame.pack();
        this.jFrame.setResizable(false);
        this.jFrame.setSize(400, 420);
        this.jFrame.setLocationRelativeTo(null);
        this.jFrame.setTitle("Lista de veículos");
        this.jFrame.setVisible(true);
    }
}
