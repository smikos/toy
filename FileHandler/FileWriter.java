package FileHandler;

public class FileWriter implements Writable{
    @Override
    public boolean save(String s, String path) {
        try(java.io.FileWriter writer = new java.io.FileWriter(path)) {
            writer.write(s);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
