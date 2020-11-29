package view;

import controller.VeiculosController;
import model.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrmMain {
    private JPanel PnMain;
    private JTextField txtPlaca;
    private JButton btnSalvar;
    private JButton btnListar;
    private JLabel lblPlaca;

    private final VeiculosController controller;

    public FrmMain(VeiculosController controller) {
        this.controller = controller;

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listar();
            }
        });
    }

    private Veiculo criar() {
        return new Veiculo(txtPlaca.getText());
    }

    private void salvar() {
        try {
            if (this.controller.salvar(criar())) {
                JOptionPane.showMessageDialog(null, "Veículo salvo com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao salvar veículo");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao salvar veículo");
        }
    }

    private void listar() {

        List<Veiculo> veiculos = this.controller.recuperar();

        if(veiculos == null) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar lista de veículos");
            return;
        }

        new FrmList(this.controller, veiculos).show();
    }

    public JPanel getPnMain() {
        return PnMain;
    }
}
