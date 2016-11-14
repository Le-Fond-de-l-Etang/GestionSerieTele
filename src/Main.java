import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class Main {

	/*private static Map<Integer,Actor> listActors = new HashMap<>();
	private static Map<Integer,Serie> listSeries = new HashMap<>();*/

	private static List<Actor> listActors = new ArrayList<>();
	private static List<Serie> listSeries = new ArrayList<>();

	public static void main(String[] args) {
		populateLists();


		getOneActor(78333);


		/*Set<Map.Entry<Integer, Actor>> setHm = listActors.entrySet();
		Iterator<Map.Entry<Integer, Actor>> it = setHm.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Actor> e = it.next();
			System.out.println(e.getKey() + " : " + e.getValue());
		}*/



	}

	public static void getOneActor(int id){
		listActors
				.stream()
				.filter(s -> s.getId()==id)
				.sorted()
				.forEach(System.out::println);
	}


	private static void populateLists(){

		try {
			JSONObject jsonObject=new JSONObject(jsonDeserialiser.readfile());

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
