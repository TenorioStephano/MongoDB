import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import com.mongodb.client.model.Filters.*;

import java.util.Arrays;

import com.mongodb.Block;
import com.mongodb.client.MongoCursor;

import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.result.DeleteResult;

import static com.mongodb.client.model.Updates.*;

import com.mongodb.client.result.UpdateResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.bson.Document;


public class AlunoDao {
	MongoClient mongoClient = new MongoClient( "localhost" );
	MongoDatabase database = mongoClient.getDatabase("unisal");
	MongoCollection<Document> collection = database.getCollection("aluno");
	
	public String Cadastrar(AlunoVO alunoVO){
		Long cont = collection.count();
		try {
			Document doc = new Document("Ra",alunoVO.getRa()).append("Nome", alunoVO.getNome()).append("Curso", alunoVO.getCurso()).append("Semestre", alunoVO.getSemestre());
			collection.insertOne(doc);
			return cont == collection.count()? "Erro no cadastro!" : "Cadastro Efetuado com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String Consultar(String ra){
		Document myDoc = collection.find(eq("Ra", ra)).first();
		return myDoc.toJson();
	}
	
	public String Atualizar(AlunoVO alunovo){
		try {
			collection.updateOne(eq("Ra", alunovo.getRa()), new Document("$set", new Document("Nome", alunovo.getNome()).append("Curso", alunovo.getCurso()).append("Semestre", alunovo.getSemestre())));
			return "Atualização efetuado com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String Excluir(String ra){
		Long cont = collection.count();
		collection.deleteOne(eq("Ra", ra));
		return cont == collection.count()? "Erro na exclusão" : "Exclusão efetuada com sucesso!";
	}
}
