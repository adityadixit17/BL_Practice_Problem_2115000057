import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
class FileProcessorTest {
FileProcessor f=new FileProcessor();
@Test
void testWriteAndReadFile(@TempDir Path tempDir) throws IOException {
File tempFile=tempDir.resolve("testfile.txt").toFile();
String content="Hello, World!";
f.writeToFile(tempFile.getAbsolutePath(),content);
String readContent=f.readFromFile(tempFile.getAbsolutePath());
assertEquals(content,readContent);
}
@Test
void testFileExistsAfterWriting(@TempDir Path tempDir) throws IOException {
File tempFile=tempDir.resolve("testfile.txt").toFile();
f.writeToFile(tempFile.getAbsolutePath(),"Sample Content");
assertTrue(tempFile.exists());
}
@Test
void testReadNonExistentFileThrowsException() {
assertThrows(IOException.class,()->f.readFromFile("nonexistent.txt"));
}
}
