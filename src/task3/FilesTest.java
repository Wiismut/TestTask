package task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FilesTest {
    public static void main(String[] args) throws Exception {

        String path1 = args[0];
        String path2 = args[1];
        String path3 = args[2];

        JSONParser parser = new JSONParser();
        JSONObject valuesObject = (JSONObject) parser.parse(new FileReader(path1));
        JSONObject testsObject = (JSONObject) parser.parse(new FileReader(path2));

        JSONArray values = (JSONArray) valuesObject.get("values");
        JSONArray tests = (JSONArray) testsObject.get("tests");
        HashMap<Long, String> valuesMap = new HashMap<>();
        for (Object i : values) {
            JSONObject obj = (JSONObject) i;
            valuesMap.put((Long) obj.get("id"), (String) obj.get("value"));
        }
        for (Object test : tests) {
            data((JSONObject) test, valuesMap);
        }
        FileWriter fileWriter = new FileWriter(path3);
        fileWriter.write(testsObject.toJSONString());
        fileWriter.close();
    }
static void data(JSONObject testsObject, HashMap<Long, String> valuesMap){
        if (testsObject.containsKey("id")){
            Long id = (Long) testsObject.get("id");
            if(valuesMap.containsKey(id)){
                testsObject.put("value", valuesMap.get(id));
            }
        }
        if(testsObject.containsKey("values")){
            JSONArray item = (JSONArray) testsObject.get("values");
            for(Object i : item){
                data( (JSONObject) i, valuesMap);
            }
        }
}

}
