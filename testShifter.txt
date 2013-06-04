import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ReadWriteTextFile{
	public static String getContents(File aFile) {
		
	StringBuilder contents = new StringBuilder();
	contents.append("public class Test{");
	contents.append(System.getProperty("line.separator"));
	
	try {
		BufferedReader input = new BufferedReader(new FileReader(aFile));
		try {
			String line = null; // not declared within while loop
			boolean w = false;
        String start = "BEGIN CUT HERE";
        while (( line = input.readLine()) != null){
        	if(line.contains(start)){
        		w = true;
        	}
        	if(w) {
        		 contents.append(line);
                 contents.append(System.getProperty("line.separator"));
        	}
         
        }
      }
      finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
    
    return contents.toString();
  }

  /**
  * Change the contents of text file in its entirety, overwriting any
  * existing text.
  *
  * This style of implementation throws all exceptions to the caller.
  *
  * @param aFile is an existing file which can be written to.
  * @throws IllegalArgumentException if param does not comply.
  * @throws FileNotFoundException if the file does not exist.
  * @throws IOException if problem encountered during write.
  */
  static public void setContents(File aFile, String aContents)
                                 throws FileNotFoundException, IOException {
    if (aFile == null) {
      throw new IllegalArgumentException("File should not be null.");
    }
    if (!aFile.exists()) {
      throw new FileNotFoundException ("File does not exist: " + aFile);
    }
    if (!aFile.isFile()) {
      throw new IllegalArgumentException("Should not be a directory: " + aFile);
    }
    if (!aFile.canWrite()) {
      throw new IllegalArgumentException("File cannot be written: " + aFile);
    }

    //use buffering
    Writer output = new BufferedWriter(new FileWriter(aFile));
    try {
      //FileWriter always assumes default encoding is OK!
      output.write( aContents );
    }
    finally {
      output.close();
    }
  }

  /** Simple test harness.   */
  public static void main (String... aArguments) throws IOException {
	File readFile = getFile();  
	System.out.println("Going to readFrom: "+readFile.toString());
    //File testFile = new File("D:\\HandwrittenCode\\TCWorkSpace\\TopCoder\\src\\PrimalUnlicensedCreatures.java");
    File testFile2 = new File("D:\\HandwrittenCode\\TCWorkSpace\\TopCoder\\src\\Test.java");
    String contents = getContents(readFile);
    String delContents = getDelContents(readFile);
    //System.out.println("Original file contents: " + contents);
    setContents(testFile2, contents);
    setContents(readFile, delContents);
    //System.out.println("New file contents: " + getContents(testFile));
  }

  	private static String getDelContents(File aFile) {
  	
  		StringBuilder contents = new StringBuilder();
  	   
		try {
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null; // not declared within while loop
				boolean w = false;
				String start = "BEGIN CUT HERE";
				while ((line = input.readLine()) != null) {
					if (line.contains(start)) {
						w = true;
					}
					
					if(!w) {
		        		 contents.append(line);
		                 contents.append(System.getProperty("line.separator"));
		        	}
				}
				contents.append("}");
                contents.append(System.getProperty("line.separator"));
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return contents.toString();
}

	private static File getFile() {
	
    File[] files = new File("D:\\HandwrittenCode\\TCWorkSpace\\TopCoder\\src\\").listFiles();	
	for (File file : files) {
		String fs = file.toString();
		if(fs.endsWith(".java")) {
			if(!fs.endsWith("Test.java")| (!fs.endsWith("ReadWriteTextFile.java"))) {
				System.out.println(file.toString());
				if(isCodeFile(file)){
					return file;
				}
			}
		}
	}
    return null;
}

	private static boolean isCodeFile(File aFile) {
	    try {
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        boolean w = false;
	        String start = "BEGIN CUT HERE";
	        while (( line = input.readLine()) != null){
	        	if(line.contains(start)){
	        		return true;
	        	}
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
		return false;
	}
} 
