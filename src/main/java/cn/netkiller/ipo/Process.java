package cn.netkiller.ipo;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.netkiller.ipo.process.ProcessInterface;

import java.util.ArrayList;

/**
 *
 * @author netkiller
 */
public class Process implements ProcessInterface {
	private final static Logger logger = LoggerFactory.getLogger(Process.class);
	private final List<ProcessInterface> processes = new ArrayList<ProcessInterface>();

	public Process() {
	}

	public Process(ProcessInterface processInterface) {
		this.processes.add((ProcessInterface) processInterface);
	}

	public Process add(ProcessInterface processInterface) {
		this.processes.add(processInterface);
		return this;
	}

	public Object run(Object row) {

		for (ProcessInterface process : this.processes) {
			// logger.debug("{} source: {}", process.getClass().getName(), row.toString());
			row = process.run(row);
			if (row == null) {
				break;
			}
			// logger.debug("{} target: {}", process.getClass().getName(), row.toString());
			logger.debug("{} {}", process.getClass().getName(), row.toString());
		}

		return row;
	}

	public boolean open() {
		for (ProcessInterface process : this.processes) {
			logger.debug("Open {}", process.getClass().getName());
			process.open();
		}
		return false;
	}

	public boolean close() {
		for (ProcessInterface process : this.processes) {
			process.close();
			logger.debug("Close {}", process.getClass().getName());
		}
		return false;
	}

	public void list() {
		this.processes.forEach((process) -> {
			System.out.println(process.getClass().getName());
		});
	}
}
