package gitlet;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
public class Blob {
//    private ArrayList<String> blobs;

    private String commitVersion; //ssid

    private String fileName;

    private String contents;

    public Blob(String name) {
        this.commitVersion =
        this.fileName =
        this.contents = Utils.readContentsAsString(//file);
    }
}
