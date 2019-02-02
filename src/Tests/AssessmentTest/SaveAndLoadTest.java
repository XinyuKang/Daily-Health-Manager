//package Tests.AssessmentTest;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SaveAndLoadTest {
//    private List<String> lines;
//    private PrintWriter writer;
//
//    @BeforeEach
//    public void setUp() throws IOException {
//        lines = Files.readAllLines(Paths.get("TextForTest.txt"));
//        writer = new PrintWriter("TextForTest.txt","UTF-8");
//    }
//
//    @Test
//    public void testSaveAndLoadReader() throws IOException {
//        for (String line: lines){
//            assertEquals("19 1.5 36 16 18.17 70",line);
//        }
//    }
//
//    @Test
//    public void testSaveAndLoadWriterAdd(){
//        lines.add("30 1.73 60 21 20 80");
//        for (String line: lines){
//            writer.println(line);
//        }
//        writer.close();
//        assertEquals("19 1.5 36 16 18.17 70",lines.get(0));
//        assertEquals("30 1.73 60 21 20 80",lines.get(1));
//    }
//
//    @Test
//    public void testSaveAndLoadWriterRemove(){
//        lines.add("30 1.73 60 21 20 80");
//        lines.add("29 1.56 56 22 19 90");
//        for (String line: lines){
//            writer.println(line);
//        }
//        writer.close();
//        lines.remove(1);
//        for (String line: lines){
//            writer.println(line);
//        }
//        writer.close();
//        assertEquals("19 1.5 36 16 18.17 70",lines.get(0));
//        assertEquals("29 1.56 56 22 19 90",lines.get(1));
//    }
//}
