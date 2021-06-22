package mit.edu.tv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class DebeziumConnectorConfig {

    /**
     * Customer Database Connector Configuration
     */
    @Bean
    public io.debezium.config.Configuration customerConnector() throws IOException {

        System.out.println("------------------------------------------------------");
        String absolutePath = System.getProperty("user.dir");
        File f = new File(absolutePath);
        String parent = f.getParent();
        String offsetFile = parent + "/student-offset.dat";
        String historyFile = parent + "/student-history.dat";
        System.out.println(offsetFile);
        System.out.println(historyFile);        
        System.out.println("------------------------------------------------------");         


        return io.debezium.config.Configuration.create()
            .with("name", "customer-mysql-connector")
            .with("connector.class", "io.debezium.connector.mysql.MySqlConnector")
            .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
            .with("offset.storage.file.filename", offsetFile)
            .with("offset.flush.interval.ms", "60000")
            .with("database.hostname", "mysqlserver")
            .with("database.port", 3306)
            .with("database.user", "root")
            .with("database.password", "MyNewPass")
            .with("database.dbname", "customerdb")
            .with("database.include.list", "customerdb")
            .with("include.schema.changes", "false")
            .with("database.allowPublicKeyRetrieval", "true")
            .with("database.server.id", "10181")
            .with("database.server.name", "localhost_customerdb")
            .with("database.history", "io.debezium.relational.history.FileDatabaseHistory")
            .with("database.history.file.filename", historyFile)
            .build();
    }
}

