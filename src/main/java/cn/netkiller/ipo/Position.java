package cn.netkiller.ipo;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.netkiller.ipo.position.FilePosition;
import cn.netkiller.ipo.position.PositionInterface;

public class Position {
	private final static Logger logger = LoggerFactory.getLogger(Position.class);
	private PositionInterface position;
	private String key;

	public Position(FilePosition filePosition, String key) {
		this.position = filePosition;
		this.key = key;
	}

	public void set(Map<String, Object> map) {
		String current = String.valueOf(map.get(this.key));
		logger.debug("Current position: <{}> {}", this.key, current);
		this.position.set(current);

	}

	public String get() {
		return this.position.get();
	}
}
