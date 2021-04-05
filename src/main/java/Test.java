
public class Test {
    private static String InputPath = System.getProperty("user.dir") + "\\booleanfile.json";
    private static String OutputPath = System.getProperty("user.dir") + "\\booleanfile.xml";

    public static void main(String s[]) {

        XMLJSONConverterI xmljsonConverterI = new XMLJSONCovnerterImpl();
        System.out.println(InputPath);
        xmljsonConverterI.convertJSONtoXML(InputPath, OutputPath);

    }
}
