package main.problems;

import java.util.*;

public class Problem588 {


    public static class FileSystem {
        public HashMap<String, String> fileData = new HashMap<>(); //Public Because UT is a pain
        public HashMap<String, ArrayList<String>> dirs = new HashMap<>();
        String FILE_DIV = "/";

        public FileSystem() {
            dirs.put(FILE_DIV, new ArrayList<>());
        }

        public List<String> ls(String path) {
            if(fileData.containsKey(path)) {
                return Arrays.asList(new String[]{getFileName(path)}.clone());
            }

            Collections.sort(getDir(path));
            return getDir(path);
        }

        public void mkdir(String path) {
            if(dirs.containsKey(path))
                return;

            String prevDir = FILE_DIV;
            String fullDir = FILE_DIV;
            ArrayList<String> parentDir;
            for(String curDir : path.split(FILE_DIV)) {
                if(!curDir.equals("")) {
                    fullDir = prevDir + curDir + FILE_DIV;
                    parentDir = getDir(prevDir);
                    if(!parentDir.contains(curDir)) {
                        parentDir.add(curDir);
                        Collections.sort(parentDir);
                    }
                    if(!dirs.containsKey(fullDir)) {
                        dirs.put(fullDir, new ArrayList<>());
                    }

                    prevDir = fullDir;
                }
            }
        }

        public void addContentToFile(String filePath, String content) {
            int parDirStart = filePath.lastIndexOf(FILE_DIV);
            String parDir = "";
            String fileName = filePath.substring(1, filePath.length());
            //Executes when Parents is not root
            if(parDirStart != 0) {
                fileName  = filePath.substring(parDirStart + 1, filePath.length());
                parDir = filePath.substring(0, parDirStart + 1);
            }

            mkdir(parDir);
            if(!getDir(parDir).contains(fileName))
                getDir(parDir).add(fileName);
            fileData.put(filePath, fileData.getOrDefault(filePath, "") + content);
        }

        public String readContentFromFile(String filePath) {
            return fileData.get(filePath);
        }

        public ArrayList<String> getDir(String path) {
            if(path.length() == 0 || path.charAt(path.length() - 1) != '/')
                path = path + "/";

            return dirs.get(path);
        }

        public String getFileName(String filePath) {
            int parDirStart = filePath.lastIndexOf(FILE_DIV);
            String parDir = "";
            String fileName = filePath.substring(1, filePath.length());
            //Executes when Parents is not root
            if(parDirStart != 0) {
                fileName  = filePath.substring(parDirStart + 1, filePath.length());
                parDir = filePath.substring(0, parDirStart + 1);
            }

            return fileName;
        }
    }
}
