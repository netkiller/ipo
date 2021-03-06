package cn.netkiller.ipo.input;

//import java.io.BufferedInputStream;
import java.io.BufferedReader;
//import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.netkiller.ipo.Input;

public class StdinInput implements InputInterface {
	private final static Logger logger = LoggerFactory.getLogger(Input.class);
	// DataInputStream stdin = new DataInputStream(new BufferedInputStream(System.in));
	BufferedReader stdin;
	private boolean nextLine = false;

	public StdinInput() {

	}

	public boolean open() {
		try {
			stdin = new BufferedReader(new InputStreamReader(System.in, "utf-8"), 1024 * 1024 * 1024);
		} catch (UnsupportedEncodingException e) {
			logger.debug(e.getMessage());
		}
		return true;

	}

	public String readLine() {
		try {
			return stdin.readLine();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return null;

	}

	public boolean hasNextLine() {
		// logger.debug(String.valueOf(this.nextLine));
		return this.nextLine;
	}

	public boolean close() {
		try {
			this.stdin.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		return true;
	}

	public Object getDataType() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

}
