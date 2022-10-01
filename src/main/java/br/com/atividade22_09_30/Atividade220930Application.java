package br.com.atividade22_09_30;

import br.com.atividade22_09_30.repository.Contatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class Atividade220930Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Atividade220930Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void run(String... args) throws Exception {

        jdbcTemplate.execute("DROP TABLE contatos IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE contatos(id SERIAL, nome VARCHAR(255), telefone VARCHAR(255), endereco VARCHAR(255))");

        jdbcTemplate.update("INSERT INTO contatos(nome,telefone, endreco) VALUES (?,?,?)", "Edson Angoti Júnior", "123", "Rua X");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone, endereco) VALUES (?,?,?)", "José Joaquim", "123", "Rua Y");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone, endereco) VALUES (?,?,?)", "Maria Carolina", "123", "Rua Z");

        List<Contatos> contatos = jdbcTemplate.query("SELECT * FROM contatos", (rs, rowNum) -> {
            return new Contatos(rs.getLong("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("endereco"));
        });
        System.out.println("Listando contatos");
        for (Contatos contato : contatos) {
            System.out.println(contato.getNome() + " - " + contato.getTelefone());
        }
    }
}

