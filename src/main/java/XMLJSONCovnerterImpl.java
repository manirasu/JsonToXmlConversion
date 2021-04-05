import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.charset.Charset;

public class XMLJSONCovnerterImpl implements XMLJSONConverterI {
    public void convertJSONtoXML(String inputFile, String outputFile) {
       String json = null;
        try {
            json = readFile(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String xml = convert(json);

        try {
            writeFile(outputFile, xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String readFile(String InputPath) throws FileNotFoundException, IOException
    {

        StringBuilder sb = new StringBuilder();
        InputStream in = new FileInputStream(InputPath);
        Charset encoding = Charset.defaultCharset();

        Reader reader = new InputStreamReader(in, encoding);

        int r = 0;
        while ((r = reader.read()) != -1)//Note! use read() rather than readLine()
        //Can process much larger files with read()
        {
            char ch = (char) r;
            sb.append(ch);
        }

        in.close();
        reader.close();

        return sb.toString();
    }

    public static String convert(String json) throws JSONException
    {
        JSONObject obj = new JSONObject(json);

        //converting json to xml
        String xml = XML.toString(obj);
        return xml;

    }

    public static void writeFile(String filepath, String output) throws FileNotFoundException, IOException
    {
        FileWriter ofstream = new FileWriter(filepath);
        try (BufferedWriter out = new BufferedWriter(ofstream)) {
            out.write(output);
        }
    }
}
