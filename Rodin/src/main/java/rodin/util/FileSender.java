package rodin.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSender extends Thread {

	private static final Logger logger = LoggerFactory.getLogger(FileSender.class);
	private Socket socket;
	private String filename;
	private FileInputStream fis;
	private OutputStream os;
	private InputStream is;
	private BufferedOutputStream bos;
	private BufferedInputStream bis;
	private int fileSize;
	private String result;
	
	public FileSender(Socket socket, String filestr) {
		logger.debug("-- File Sender Start --");
		this.socket = socket;
		this.filename = filestr;
		
		try {
			this.os = socket.getOutputStream();
			bos = new BufferedOutputStream(os);
			this.is = socket.getInputStream();
			bis = new BufferedInputStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			logger.debug("-- File Sender End --");
		}
	}
	
	public boolean sendFileSize(String fileName) throws IOException {
		File imageFile = new File(fileName);
		fileSize = (int) imageFile.length() * 100;
		fis = new FileInputStream(imageFile);
		bos.write(Integer.toString(fileSize).getBytes());
		bos.flush();
		logger.debug("send file size : " + fileSize);
		return true;
	}
	
	public void sendImage(int fileSize) throws IOException {
		byte[] data = new byte[(int) (fileSize)];
		bos.write(data, 0, fis.read(data));
		logger.debug("send image ...");
		bos.flush();
		fis.close();
	}
	
	public String receiveData(int buffer_size) throws IOException {
		byte[] tmp = new byte[buffer_size];
		int zz = bis.read(tmp);
		logger.debug("server : " + new String(tmp, 0, zz));
		return new String(tmp, 0, zz);
	}
	
	public String getResult() {
		logger.debug("-- Result --");
		return result;
	}
	
	public void close() {
		logger.debug("-- Close Socket Thread --");
		try {
			bos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		logger.debug("-- Run Thread --");
		// super.run();
		try {
			sendFileSize(filename);
			receiveData(100);
			sendImage(fileSize);
			result = receiveData(100);
			// logger.debug("result: " + result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
}
