package repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class RepositorioVeiculos {

    private MongoCollection<Veiculo> veiculoMongoCollection;

    public RepositorioVeiculos(MongoClient client) {
        this.veiculoMongoCollection = client.getDatabase("ccomp_db")
                .getCollection("vehicles", Veiculo.class);
    }

    public void salvar(Veiculo veiculo) {
        veiculoMongoCollection.insertOne(veiculo);
    }

    public List<Veiculo> recuperarVeiculos() {
        return veiculoMongoCollection.find(Veiculo.class).into(new ArrayList<>());
    }

    public void atualizar(Veiculo veiculo) {
        veiculoMongoCollection.updateOne(eq("_id", veiculo.getId()), set("placa", veiculo.getPlaca()));
    }

    public void deletar(Veiculo veiculo) {
        veiculoMongoCollection.deleteOne(eq("_id", veiculo.getId()));
    }
}

