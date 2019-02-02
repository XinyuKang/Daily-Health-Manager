package API;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ParseAPI {
    public ExerciseParser exParser;

    public void parse(String exerciseName) throws MalformedURLException, IOException {

        try {
            String theURL = "https://wger.de/api/v2/exercise/?format=json&name=" + URLEncoder.encode(exerciseName, "UTF-8");
            URL url = new URL(theURL);

            InputStream is = url.openStream();
            String jsonData =  readSource(is);
            exParser = new ExerciseParser();
            exParser.parseExercise(jsonData,exerciseName);
        } catch (IOException e) {
            System.out.println("Error reading file...");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error parsing JSON data");
            e.printStackTrace();
        }
    }

    public ExerciseParser getExParser() {
        return exParser;
    }

    /**
     * Read source data from input stream as string
     *
     * @param is  input stream connected to source data
     * @return  source data as string
     * @throws IOException  when error occurs reading data from file
     */
    private String readSource(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();

        return sb.toString();
    }
}
