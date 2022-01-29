import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonEditor {


  private static final String filePath = "/Users/hao/Desktop/BetterDAO/sample/metadata/1.json";

  public static void main(String[] args) {

    String nftName = "BetterDAO";
    int fileNum = 3;
    String baseUri = "https://ipfs.io/ipfs/QmQrDcnjhCqJspw9rEdtHNfvDRcRSkYyuSBamnqZuqjdBr/";
    String outputPath = "/Users/hao/Desktop/BetterDAO/sample/metadata/";

    for (int i = 1; i <= fileNum; i++){
      try {
        // read the json file
        FileReader reader = new FileReader(filePath);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

        jsonObject.put("image",baseUri + i + ".webp");
        jsonObject.put("name",nftName + " #" +i);
        jsonObject.remove("external_url");
        jsonObject.remove("properties");
        jsonObject.remove("compiler");


        FileWriter file = new FileWriter(outputPath + i + ".json");
        //We can write any JSONArray or JSONObject instance to the file
        String x = jsonObject.toJSONString().replaceAll("\\\\","");
        file.write(x);
        file.flush();


      } catch (FileNotFoundException ex) {
        ex.printStackTrace();
      } catch (IOException ex) {
        ex.printStackTrace();
      } catch (ParseException ex) {
        ex.printStackTrace();
      } catch (NullPointerException ex) {
        ex.printStackTrace();
      }
    }



  }

}