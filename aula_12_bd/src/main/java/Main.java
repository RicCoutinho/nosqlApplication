import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import controller.VeiculosController;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import repository.RepositorioVeiculos;
import view.FrmMain;

import javax.swing.*;
import java.sql.SQLException;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main {

    private static MongoClient obterConexao() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://root:root@localhost:27017/?authSource=admin&authMechanism=SCRAM-SHA-256"))
                .codecRegistry(pojoCodecRegistry)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        RepositorioVeiculos repositorioVeiculos = new RepositorioVeiculos(obterConexao());
        VeiculosController controller = new VeiculosController(repositorioVeiculos);

        JFrame frame = new JFrame();
        frame.setContentPane(new FrmMain(controller).getPnMain());
        frame.pack();
        frame.setResizable(false);
        frame.setSize(400, 420);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Cadastro de Veículos");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}