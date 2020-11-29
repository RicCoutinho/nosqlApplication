package controller;

import model.Veiculo;
import repository.RepositorioVeiculos;

import java.util.List;

public class VeiculosController {

    private RepositorioVeiculos repositorio;

    public VeiculosController(RepositorioVeiculos repositorio) {
        this.repositorio = repositorio;
    }

    public boolean salvar(Veiculo veiculo) {
        if(veiculo.getId() == null) {
            System.out.println("VAI INSERIR");
            return this.criar(veiculo);
        } else {
            return this.atualizar(veiculo);
        }
    }

    private boolean criar(Veiculo veiculo) {
        try {
            repositorio.salvar(veiculo);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    private boolean atualizar(Veiculo veiculo) {
        try {
            repositorio.atualizar(veiculo);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public void deletar(Veiculo veiculo) {
        repositorio.deletar(veiculo);
    }

    public List<Veiculo> recuperar() {
        try {
            return repositorio.recuperarVeiculos();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
