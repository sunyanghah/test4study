package test.study.java.mianshiti2024;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author sun yang
 * @date 2024/3/11
 */
public class Test0311_2 {

    public static void main(String[] args) throws Exception{

        System.out.println(getVersionNumber(new File("E:\\谷歌浏览器下载文件夹\\metaspace-1.0.1001.18-std.alpha-x86.exe")));

    }

    private static String getVersionNumber(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            // Read the DOS header to find the offset of the PE header
            raf.seek(0x3C);
            int peHeaderOffset = raf.read() & 0xFF | ((raf.read() & 0xFF) << 8);

            // Read the PE signature and check if it's valid
            raf.seek(peHeaderOffset);
            int peSignature = raf.readInt();
            if (peSignature != 0x00004550) {
                throw new IOException("Not a valid PE file.");
            }

            // Read the PE header to find the offset of the version information
            raf.skipBytes(20);
            short numberOfSections = Short.reverseBytes(raf.readShort());
            raf.skipBytes(12 + 14 * numberOfSections);

            int versionInfoOffset = Integer.reverseBytes(raf.readInt());

            // Read the version information from the resource section
            raf.seek(versionInfoOffset + 48); // Offset to the version information
            short length = Short.reverseBytes(raf.readShort());
            short valueLength = Short.reverseBytes(raf.readShort());

            // Skip fixed version info header
            raf.skipBytes(6);

            // Read the version number
            StringBuilder versionNumber = new StringBuilder();
            for (int i = 0; i < valueLength / 2; i++) {
                char c = (char) Short.reverseBytes(raf.readShort());
                if (c != 0) {
                    versionNumber.append(c);
                }
            }

            return versionNumber.toString();
        }
    }

}
