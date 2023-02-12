import generateGoogleDriveLink.GenerateGoogleFiles;
import generateQuery.CreateQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        CreateQuery query = new CreateQuery();
//        query.createProductOptionQuery();

        GenerateGoogleFiles googleFiles = new GenerateGoogleFiles();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputList = br.readLine().split(",");
        for (String input : inputList) {
            googleFiles.make(input);
        }
//        BufferedReader br;
//        while (true) {
//            br = new BufferedReader(new InputStreamReader(System.in));
//            String input = br.readLine();
//            googleFiles.make(input);
//        }

    }
}

