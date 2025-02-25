package Day24.AdvanceProblems;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CsvEncryptDecrypt {
    private static final String ALGORITHM = "AES";
    public static String encrypt(String data, String secretKey) throws Exception {
        SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }
    public static String decrypt(String encryptedData, String secretKey) throws Exception {
        SecretKey key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }
    public static String generateSecretKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
    public static void writeCsv(String filePath, List<String[]> data, String secretKey) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (String[] record : data) {
                String[] encryptedRecord = new String[record.length];
                encryptedRecord[0] = record[0]; // Assuming the first field is not sensitive
                encryptedRecord[1] = encrypt(record[1], secretKey); // Encrypt salary
                encryptedRecord[2] = encrypt(record[2], secretKey); // Encrypt email
                writer.writeNext(encryptedRecord);
            }
        }
    }
    public static List<String[]> readCsv(String filePath, String secretKey) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> decryptedData = new ArrayList<>();
            List<String[]> allData = reader.readAll();
            for (String[] record : allData) {
                String[] decryptedRecord = new String[record.length];
                decryptedRecord[0] = record[0]; // Assuming the first field is not sensitive
                decryptedRecord[1] = decrypt(record[1], secretKey); // Decrypt salary
                decryptedRecord[2] = decrypt(record[2], secretKey); // Decrypt email
                decryptedData.add(decryptedRecord);
            }
            return decryptedData;
        }
    }
    public static void main(String[] args) throws Exception {
        String filePath = "data.csv";
        String secretKey = generateSecretKey();
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"John Doe", "50000", "john@example.com"});
        data.add(new String[]{"Jane Smith", "60000", "jane@example.com"});
        writeCsv(filePath, data, secretKey);
        List<String[]> decryptedData = readCsv(filePath, secretKey);
        for (String[] record : decryptedData) {
            System.out.println("Name: " + record[0] + ", Salary: " + record[1] + ", Email: " + record[2]);
        }
    }
}
