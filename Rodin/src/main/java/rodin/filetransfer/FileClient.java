package rodin.filetransfer;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileClient {
	
	private static final Logger logger = LoggerFactory.getLogger(FileClient.class);
	private Socket s;
    private String echo;
    
	public FileClient(String host, int port) throws UnknownHostException, IOException {

		s = new Socket(host, port);
//		saveFile(s);
		sendFile();

	}        
	private void sendFile() {
		logger.debug("sendfile");
	}

	private void saveFile(Socket clientSock) throws IOException {
        InputStream in = clientSock.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());
        
        FileOutputStream fos = new FileOutputStream("testfile.png");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        echo = br.readLine();
        System.out.println("echo : "+ echo);
        
        //for origin image save
		byte[] buffer = new byte[4096];
		
		int filesize = Integer.parseInt(echo); // Send file size in separate msg
        System.out.println("filesize : "+ filesize);
		int len = in.read(buffer);
		
		while(len != -1) {
			System.out.println("read " + len + " bytes.");
            fos.write(buffer,0,len);
            len = in.read(buffer);
		}
		
		fos.close();
		dis.close();
	}
}