//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.ServerAddress;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.MongoCollection;
//import org.bson.Document;
//import java.util.Arrays;
//import com.mongodb.Block;
//import com.mongodb.client.MongoCursor;
//import static com.mongodb.client.model.Filters.*;
//import com.mongodb.client.result.DeleteResult;
//import static com.mongodb.client.model.Updates.*;
//import com.mongodb.client.result.UpdateResult;
//import java.util.ArrayList;
//import java.util.List;
//import org.bson.Document;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		AlunoVO alunoVO = new AlunoVO();
		AlunoDao alunoDao = new AlunoDao();
//		MongoClient mongoClient = new MongoClient( "localhost" );
//		MongoDatabase database = mongoClient.getDatabase("unisal");
		Scanner in = new Scanner(System.in);
		byte op = 0;
		do{
			System.out.println("--------MENU--------");
			System.out.println("Seleciona uma Opção:");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Consultar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Deletar");
			System.out.println("0 - Sair");
			op = in.nextByte();
			switch (op) {
			case 1:
				System.out.println("Digite o RA do aluno:");
				alunoVO.setRa(in.next());
				System.out.println("Digite o nome do aluno:");
				alunoVO.setNome(in.next());
				System.out.println("Digite o nome do curso:");
				alunoVO.setCurso(in.next());
				System.out.println("Digite o semestre:");
				alunoVO.setSemestre(in.nextInt());
				System.out.println(alunoDao.Cadastrar(alunoVO));
				break;
			case 2:
				System.out.println("Digite o RA do Aluno:");
				System.out.println(alunoDao.Consultar(in.next()));
				break;
			case 3:
				System.out.println("Digite o RA do aluno que deseja atualizar:");
				alunoVO.setRa(in.next());
				System.out.println("Digite o nome do aluno:");
				alunoVO.setNome(in.next());
				System.out.println("Digite o nome do curso:");
				alunoVO.setCurso(in.next());
				System.out.println("Digite o semestre:");
				alunoVO.setSemestre(in.nextInt());
				System.out.println(alunoDao.Atualizar(alunoVO));
				break;
			case 4:
				System.out.println("Digite o RA do Aluno");
				System.out.println(alunoDao.Excluir(in.next()));
				break;
			default:
				break;
			} ;
			
		}while(op != 0);
		
		
		//MongoCollection<Document> collection = database.getCollection("nada");

//		Document doc = new Document("nome", "Marcos").append("curso", "Ciência da Computação");
//		collection.insertOne(doc);
//		System.out.println("Linhas inseridas: "+ collection.count());
//		
//		Document myDoc = collection.find().first();
//		System.out.println(myDoc.toJson());
//		
//		MongoCursor<Document> cursor = collection.find().iterator();
//		try {
//		    while (cursor.hasNext()) {
//		        System.out.println(cursor.next().toJson());
//		    }
//		} finally {
//		    cursor.close();
//		}
		
//		for (Document cur : collection.find()) {
//		    System.out.println(cur.toJson());
//		}
		
//		Block<Document> printBlock = new Block<Document>() {
//		     public void apply(final Document document) {
//		         System.out.println(document.toJson());
//		     }
//		};
		
//		Block<Document> printBlock = new Block<Document>() {
//		     public void apply(final Document document) {
//		         System.out.println(document.toJson());
//		     }
//		};
//
//		collection.find(gt("id", 50)).forEach(printBlock);
//		collection.find(and(gt("i", 50), lte("i", 100))).forEach(printBlock);

//		UpdateResult updateResult = collection.updateMany(lt("i", 100), inc("i", 100));
//		System.out.println(updateResult.getModifiedCount());
		in.close();
//		mongoClient.close();
	}

}
