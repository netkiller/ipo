package cn.netkiller.ipo.output;

public class ElasticsearchOutput implements OutputInterface {

	private String index; 
	private String type;
	
	public ElasticsearchOutput() {
	}
	public ElasticsearchOutput(String index, String type) {
		this.index = index;
		this.type = type;
	}
	@Override
	public void open() {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(String output) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
