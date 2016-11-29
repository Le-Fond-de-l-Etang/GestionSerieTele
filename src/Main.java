import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.print.DocFlavor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	/*private static Map<Integer,Actor> listActors = new HashMap<>();
	private static Map<Integer,Serie> listSeries = new HashMap<>();*/
	private static String functions[] = {"getOneActor","getActorByName","getActorBySerieId",};
	private static int indexMenu=0;
	private static List<Actor> listActors = new ArrayList<>();
	private static List<Serie> listSeries = new ArrayList<>();


	public static void main(String[] args)  {

		System.out.println("selectionner la fonction");

		afficherFonction();

		Scanner keyboard = new Scanner(System.in);
		System.out.println("entrez un numero entre 0 et 2 ");
		indexMenu = keyboard.nextInt();


		populateLists();
		String function;
		int i;
		String s;

		switch(indexMenu){
			case 1:
				System.out.println("Entrez l'id d'un acteur");
				 i =keyboard.nextInt();
				getOneActor(i);
				break;
			case 2:
				System.out.println("Entrez un nom d'acteur");
				s =keyboard.next();
				getActorByName(s);
				break;
			case 3:
				System.out.println("Entrez l'id d'une serie");
				i =keyboard.nextInt();
				getActorBySerieId(i);
				break;
			case 4:
				System.out.println("Entrez un genre");
				s =keyboard.next();
				getSerieByGenre(s);
				break;
			default:
				System.out.close();
				break;
		}


		//getOneActor(78333);
		//getActorBySerieId(73871);
		//getActorByName("phil");

		//sortSerieByRa1ting();

	}


	public static void afficherFonction(){
		for(int i=0; i <functions.length;i++){
			System.out.println(i+1+". "+functions[i]);
		}
	}

	public static void getOneActor(int id){
		listActors
				.stream()
				.filter(s -> s.getId()== id)
				.sorted()
				.forEach(System.out::println);
	}
	public static void getActorBySerieId(int serieId){
		listActors
				.stream()
				.filter(s -> s.getSerieId()== serieId)


				//.map(s->s.toString())

				.forEach(System.out::println);
	}
	public static void getActorByName(String name){
		listActors
				.stream()
				.filter(s -> s.getName().contains(name))

				.forEach(System.out::println);
	}

	public static void getseriebyid(int index){
		listSeries
				.stream()
				.filter(s -> s.getId()== index)

				//.map(s->s.toString())

				.forEach(System.out::println);
	}
	public static void sortSerieByRating(){
		listSeries
				.stream()
				.map(s->s.getSiteRating())

				.sorted()

				.forEach(System.out::println);
	}
	public static void getSerieByGenre(String genre){

		listSeries.stream()
				.filter(s-> s.isInGenre(genre))
				.forEach(System.out::println);
	}

	private static void populateLists(){

		try {
			JSONObject jsonObject=new JSONObject(jsonDeserialiser.readfile());
			JSONObject j = new JSONObject();
			JSONArray actors = jsonObject.optJSONArray("actors");
			JSONArray series = jsonObject.optJSONArray("series");





			for(int i=0;i<series.length();i++){
				JSONObject serie = series.getJSONObject(i);
				Serie serie1 =jsonDeserialiser.getSerieFromJson(serie);
				//listSeries.put(serie1.getId(),serie1);
				listSeries.add(serie1);


			}


			for(int i=0; i<actors.length();i++){
				JSONObject actor = actors.getJSONObject(i);
				Actor actor1 = jsonDeserialiser.getActorFromjson(actor);
				//listActors.put(actor1.getId(),actor1);
				listActors.add(actor1);

			}




		}
		catch (JSONException je){

		}
	}

}
