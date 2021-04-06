package com;

public class JsonToXmlConversion {
    private static String InputPath = null;
    private static String TempPath = System.getProperty("user.dir") + "\\temp.xml";
    private static String OutputPath = null;
    public static void main(String args[]) {
        if(args.length < 1)
            return;
        if(args[0] != null && args[0] != "") {
            InputPath = args[0];
        }else{
            System.out.println("Please provide json file path");
            return;
        }
        if(args.length >= 2) {
            if(args[1] != null && args[1] != "") {
                OutputPath = args[1];
            }
        }else{
            OutputPath = TempPath;
        }

        for( int i= 2; i < args.length; i++) {
                System.out.println("Skipping --> not convert to xml " + args[i]);
        }

        XMLJSONConverterI xmljsonConverterI = new XMLJSONCovnerterImpl();

        xmljsonConverterI.convertJSONtoXML(InputPath, OutputPath);

    }
}
