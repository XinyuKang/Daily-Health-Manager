package API;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExerciseParser {
    private String instructions;

    /**
     * Prints library parsed from JSON data to console
     * @param jsonData  string containing JSON data
     * @throws JSONException when jsonData cannot be parsed as a JSONArray
     */
    public void parseExercise(String jsonData,String exerciseName) throws JSONException {
        //  JSONArray library = new JSONArray(jsonData);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray library = jsonObject.getJSONArray("results");

        for (int index = 0; index < library.length(); index++) {
            JSONObject exercise = library.getJSONObject(index);
            parseE(exercise, exerciseName);

        }
    }

    private void parseE(JSONObject exercise, String exerciseName) throws JSONException {
        if (exercise.getString("name").equals(exerciseName)){
            instructions = exercise.getString("description");
        }
    }

    public String getInstructions(){
        return instructions;
    }
}
