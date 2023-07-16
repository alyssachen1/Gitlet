//package gitlet;
//
//// TODO: any imports you need here
//
//import java.util.Date; // TODO: You'll likely use this in this class
//import java.util.HashMap;
//
///** Represents a gitlet commit object.
// *  TODO: It's a good idea to give a description here of what else this Class
// *  does at a high level.
// *
// *  @author TODO
// */
//public class Commit {
//    /**
//     * TODO: add instance variables here.
//     *
//     * List all instance variables of the Commit class here with a useful
//     * comment above them describing what that variable represents and how that
//     * variable is used. We've provided one example for `message`.
//     */
//
//    private Date timeStamp;
//
//    /** The message of this Commit. */
//    private String message = "initial commit";
//    private static Commit recent_commit;
//    public Commit next_commit;
//    private static HashMap <String,Commit> commit_tracker = new HashMap<String,Commit>();
//
//    public Commit(){
//        this.timeStamp = firstTimeStamp();
//        this.message = "initial commit";
//        commit_tracker.put("00:00:00 UTC, Thursday, 1 January 1970", this);
//        recent_commit = this;
//    }
//    public Commit(String message){
//        this.timeStamp = timeStamp();
//        this.message = message;
//        commit_tracker.put("Replace this",this);
//        recent_commit.next_commit = this;
//        recent_commit = this;
//
//    }
//
//
//
//    public Date firstTimeStamp() {
//        Date timestamp = new Date(1970, 1, 1, 0, 0, 0);
//        return timestamp;
//    }
//
//    public Date timeStamp() {
//        Date timestamp = new Date();
//        return timestamp;
//    }
//
//    private String generateId(Commit commit) {
//        // Generates unique ID for the commit using SHA-1 hash
//        //tbh idk if i need this method bc of line 39/40 in init
//        return Utils.sha1(commit);
//}
//
//}

package gitlet;
import java.io.Serializable;
import java.util.Date;
import java.util.Formatter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

// TODO: any imports you need here

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /**
     * The message of this Commit.
     */
    public static String hash;
    public String message;
    public Date timestamp;
    public Commit nextCommit;
    public static Commit recentCommit;
    private HashMap<String, String> commit_tracker = new HashMap<String, String>();



    public List<Commit> parent;


    public Commit() {
        //initial commit
        this.timestamp = firstTimeStamp();
        this.message = "initial commit";
        commit_tracker.put("00:00:00 UTC, Thursday, 1 January 1970", this);
        recentCommit = this;
        this.parent = null;
        this.hash = generateId();
    }

    public Commit(String message) {
        //later commits
        this.message = message;
        this.timestamp = timeStamp();
        this.parent = parent;
        commit_tracker.put("Replace this",this);
        recentCommit.nextCommit = this;
        recentCommit = this;
        this.hash = generateId();
    }


    public Date firstTimeStamp() {
        Date timestamp = new Date(1970, 1, 1, 0, 0, 0);
        return timestamp;
    }

    public Date timeStamp() {
        Date timestamp = new Date();
        return timestamp;
    }

    private String generateId() {
        // Generates unique ID for the commit using SHA-1 hash
        byte[] commitObj = Utils.serialize(this);
        return Utils.sha1(commitObj);
        /* TODO: fill in the rest of this class. */
    }

    public boolean restoreFile(String wantedfilepath){

        String blobID = commit_tracker.get(wantedfilepath);

        if (blobID == null) {
            return false;
        }

        Blob.fromFile(blobId).writeContentToSource();
        return true;

    }
}
