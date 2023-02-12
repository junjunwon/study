package generateGoogleDriveLink;

public class GenerateGoogleFiles {

    private String resultPrefix = "{\"image\" : \"https://drive.google.com/uc?export=view&id=";
    private String getResult;
    private String resultSurfix = "\"}";


    public void make(String input) {
        // example : https://drive.google.com/file/d/1U-X_EnrCiw_GgIdeQ3oyCT372K7kWWEE/view?usp=share_link
        getResult = input.split("/")[5];
        System.out.println(resultPrefix+getResult+resultSurfix+",");
    }
}
