## .gitlet
    - working
    - staging
        -files
        -file names
        -methods: add/remove
        -store it persistently
    - commit
    -repository
        

### commit class
    - data struc: linked list
    instance attributes: 
    - String timestamp
    - String log message
    - SHA-1 ID
    - file (blob) references of its files
    - parent references

### staging class
    -file
    -hashmap of staged files
    -add method

### repository class
    - head/master pointer
    - staging addition/removal
    - branching (have a map)
    - init()
            1. main branch
            2. timestamp
            3. constant runtime
            4. no files
            5. commit message "initial commit"
            6. failure case: "A Gitlet version-control system already exists in the current directory."
    -add(fileName)
            1. add copy of file to staging area
            2. can overwrite previous entry if updating contents
            3. failure case: "File does not exist."
    -commit(message)
            1. functionality: tracking saved files
            2. main will point to new commit
            3. (happens in the staging????)
            4. constant runtime
            5. failure cases: 
    -restore
    -log

### serialization & persistence
    1) command 1
    2) command 2
    3) command 3

### git objects
    1) blobs
    2) tree
    3) commits 
    - all represented by SHA-1 ID