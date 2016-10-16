import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.io.*;
import java.nio.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Charset charset = Charset.defaultCharset();
        System.out.println(readAsString(System.in, charset));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int c;
        StringBuilder s = new StringBuilder();
        while((c = inputStream.read()) != -1) {
            s.append((char) c);
        }
        return new String(s.toString().getBytes(), charset);
        //return s.toString();
    }

    public static String readAsString2(InputStream inputStream, Charset charset) throws IOException {
        byte c;
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        while((c = (byte) inputStream.read()) != -1){
            bytes.add(c);
        }
        Byte[] arr = bytes.toArray(new Byte[bytes.size()]);
        byte[] arrByte = new byte[bytes.size()];
        for(int i = 0; i < bytes.size(); i++){
            arrByte[i] = arr[i].byteValue();
        }
        return new String(arrByte, charset);
    }
}