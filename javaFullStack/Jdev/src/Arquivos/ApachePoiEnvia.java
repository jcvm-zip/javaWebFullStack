package Arquivos;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ApachePoiEnvia {
    public static void main(String[] args) throws FileNotFoundException {

        FileReader fileReader = new FileReader("/home/jeffeson/Documentos/Code/java/javaFullStack/Jdev/src/Arquivos/data/arquivo.json");

        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

        List<Usuario> usuarioList = new ArrayList<Usuario>();


        for (JsonElement jsonElement : jsonArray) {
            Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
            usuarioList.add(usuario);

        }
        System.out.println("leitura do Json: " + usuarioList);



    }
}
