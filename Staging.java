package gitlet;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import static gitlet.Utils.*;

public class Staging {
    public static final File STAGING_AREA = join(Repository.GITLET_DIR, ".staging");
    private Map<String, File> stagedFiles;

    public Staging() {
        if (!STAGING_AREA.exists()) {
            STAGING_AREA.mkdir();
        }
        stagedFiles = new HashMap<>();
        //using hashmap for stageFiles
    }

    public void add(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist.");
        } else {
            //check if file is already staged for addition
            //add copy of file to staging area
            if (stagedFiles.containsKey(file.getName())) {
                //if staging area contains the file
                File stagedFile = stagedFiles.get(file.getName());
                if (isSameContent(file, stagedFile)) {
                    //if the content is the same as staged content, remove from staging area
                    stagedFiles.remove(file.getName());
                }
            }
            File stagedFile = new File(STAGING_AREA, file.getName());
            stagedFiles.put(file.getName(), stagedFile);
        }
    }

    private boolean isSameContent(File file1, File file2) {
        if (readContents(file1) == readContents(file2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void remove(String filename) {
        return;
    }

    public void rm (String filename) {
        Utils.restrictedDelete(filename);
    }

    public boolean isEmpty() {
        return stagedFiles.isEmpty();
    }

    public void clear() {
        stagedFiles.clear();
    }
}
