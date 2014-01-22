package mp3tageditor;

import mp3tageditor.Model.ByteHolder;
import mp3tageditor.Model.ID3;
import mp3tageditor.Persistence.FileLoader;
import mp3tageditor.Persistence.SaveFile;

/**
 * @author Quique
 */
public class MP3TagChanger {

    public static void main(String[] args) {
        new MP3TagChanger().execute();
    }

    private void execute() {      
        ID3 test = FileLoader.load("F:\\test.mp3");
        System.out.println(test);
        System.out.println("");
        test.setYear(new ByteHolder(new byte[] {'2','0','1','4'}));
        SaveFile.save("F:\\test.mp3", test);
        test = FileLoader.load("F:\\test.mp3");
        System.out.println(test);
    }
    
}
