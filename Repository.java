package gitlet;

import javassist.Loader;

import java.io.File;
import java.text.SimpleDateFormat;

import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {

    private String HEAD = "master";

    public Commit currentCommit;

    public Staging staging;
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */

    public Repository() {
        currentCommit = null;
        staging = new Staging();
    }
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: fill in the rest of this class. */
    public void init() {
        if (!GITLET_DIR.exists()) {
            GITLET_DIR.mkdir();
        } else {
            System.out.println("A Gitlet version-control system already exists in the current directory.");
        }
        Commit newCommit = new Commit();;
        Utils.sha1(newCommit);
        //main branch
    }
    public void commit(String message) {
        if (staging.isEmpty()) {
            System.out.println("No changes added to the commit.");
        }
        if (message.isEmpty() || message.isBlank()) {
            System.out.println("Please enter a commit message.");
        }
        else {
            Commit newCommit = new Commit(message);
            //set the parent later
            staging.clear();
            currentCommit = newCommit;
        }
    }

    public void log() {
        Commit current = this.currentCommit;
        while (current != null) {
            System.out.println("===");
            System.out.println("commit" + current.hash);
            System.out.println("Date" + current.timestamp);
            System.out.println(current.message);
            System.out.println();
            if (current.parent != null) { //2 parent commits
                System.out.println("Merged development into main.");
            }
            else {
                break;
            }
        }
    }
    public void restore() {

    }

    public File getFile() {
        return
    }
}
