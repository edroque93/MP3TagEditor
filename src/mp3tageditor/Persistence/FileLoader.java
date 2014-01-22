package mp3tageditor.Persistence;

import mp3tageditor.Model.ID3;

public interface FileLoader {
    
    public ID3 load(String path);

}
