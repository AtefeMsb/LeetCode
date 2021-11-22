// Trie node
class File {
    HashMap < String, File > children;
    boolean isfile;
    String content;
    
    public File(boolean isfile) {
        this.children = new HashMap< >();
        this.isfile = isfile;
        this.content = "";
    }
}

public class FileSystem {
  
    File root;
    
    public FileSystem() {
        root = new File(false);
    }

    public List<String> ls(String path) {
        File cur = root;
        
        List <String> files = new ArrayList<>();
        if (!path.equals("/")) {
            
            // the first sub directry is empty
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                cur = cur.children.get(d[i]);
            }
            
            // If path is a file path, returns a list that only contains this file's name.
            if (cur.isfile) {
                files.add(d[d.length - 1]);
                return files;
            }
        }
        
        // If path is a directory path, returns the list of file and directory names in this directory.
        List<String> res_files = new ArrayList<>(cur.children.keySet());
        Collections.sort(res_files);
        return res_files;
    }

    public void mkdir(String path) {
        File cur = root;
        
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!cur.children.containsKey(d[i])) {
                cur.children.put(d[i], new File(false));
            }
            
            cur = cur.children.get(d[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File cur = root;
        
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            cur = cur.children.get(d[i]);
        }
        
        // If filePath does not exist, creates that file containing given content. 
        if (!cur.children.containsKey(d[d.length - 1])) {
           cur.children.put(d[d.length - 1], new File(false)); 
        }
          
        // If filePath already exists, appends the given content to original content.
        cur = cur.children.get(d[d.length - 1]);
        cur.isfile = true;
        cur.content = cur.content + content;
    }

    public String readContentFromFile(String filePath) {
        File cur = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            cur = cur.children.get(d[i]);
        }
        return cur.children.get(d[d.length - 1]).content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */