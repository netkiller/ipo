/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.netkiller.ipo.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author netkiller
 */
public class FileInput implements InputInterface {

	private final static Logger logger = LoggerFactory.getLogger(FileInput.class);
	private File file;
	private FileInputStream fileInputStream;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;

	private String filename;

	public FileInput(String filename) {
		this.filename = filename;
		logger.info(filename);
	}

	public boolean open() {

		try {
			file = new File(this.filename);
			fileInputStream = new FileInputStream(file);
			inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			bufferedReader = new BufferedReader(inputStreamReader);

		} catch (FileNotFoundException ex) {
			logger.error(ex.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public String read() {
		String str;
		str = bufferedReader.toString();

		return str;
	}

	public String readLine() {
		try {
			return bufferedReader.readLine();
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	public boolean close() {
		try {
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
		return true;

	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	// @Override
	// public void open() {
	// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	// }
}
