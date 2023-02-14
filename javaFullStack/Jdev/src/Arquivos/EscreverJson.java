package Arquivos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreverJson {
    public static void main(String[] args) throws IOException {

        Usuario usuario1 = new Usuario();
        usuario1.setLogin("user");
        usuario1.setSenha("user");
        usuario1.setCpf("865.975.932-32");

        Usuario usuario2 = new Usuario();
        usuario2.setLogin("user2");
        usuario2.setSenha("user2");
        usuario2.setCpf("234.231.342-35");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonUser = gson.toJson(usuarios);

        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter("/home/jeffeson/Documentos/Code/java/javaFullStack/Jdev/src/Arquivos/data/arquivo.json");

        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();


    }
}
