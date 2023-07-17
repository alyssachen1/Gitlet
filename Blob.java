package gitlet;
import java.io.Serializable;
import java.io.File;

public class Blob implements Serializable {
//    private ArrayList<String> blobs;

    private final File source;

    private final byte[] content;

    private final String id;

    private final File file;

    private String contents;

    public Blob(File source) {
        this.source = source;
        this.content = Utils.readContents(source);
        String filePath = source.getPath();
        this.id = Utils.sha1(filePath, this.content);
        this.file = getFile(this.id);
    }

    public File getFile (String id) {
        String dirName = id.substring(1, 2);
        String fileName = id.substring(2);
        return Utils.join(Repository.GITLET_DIR, dirName, fileName);
    }

    public static void saveObjectFile(File file, Serializable object) {
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        Utils.writeObject(file, object);
    }

    public String getId() {
        return this.id;
    }

}
