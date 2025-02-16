public class StringBufferVSStringBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000; 
        StringBuffer stringBuffer = new StringBuffer();
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }
        long endTime = System.nanoTime();
        long bufferTime = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + bufferTime + " ns");
        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }
        endTime = System.nanoTime();
        long builderTime = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + builderTime + " ns");
        System.out.println("StringBuilder is " + (double) bufferTime / builderTime + " times faster than StringBuffer.");
    }
}
