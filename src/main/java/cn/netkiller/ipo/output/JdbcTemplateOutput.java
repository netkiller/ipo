package cn.netkiller.ipo.output;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.netkiller.ipo.util.SqlUtil;
import cn.netkiller.ipo.util.SqlUtil.SQL;

public class JdbcTemplateOutput implements OutputInterface {

	private final static Logger logger = LoggerFactory.getLogger(JdbcTemplateOutput.class);
	private String table;

	private Map<String, String> map = new LinkedHashMap<String, String>();

	private JdbcTemplate outputJdbcTemplate;

	private String method = SQL.INSERT;
	private int insertId;

	public JdbcTemplateOutput(JdbcTemplate outputJdbcTemplate, String table) {
		this.outputJdbcTemplate = outputJdbcTemplate;
		this.table = table;

		// logger.debug("Output table {}", table);
	}

	public JdbcTemplateOutput(JdbcTemplate outputJdbcTemplate, String table, String method) {
		this.outputJdbcTemplate = outputJdbcTemplate;
		this.table = table;
		this.method = method;
		// logger.debug("Output table {}", table);
	}

	public JdbcTemplateOutput(JdbcTemplate outputJdbcTemplate, String table, Map<String, String> map) {
		this.outputJdbcTemplate = outputJdbcTemplate;
		this.table = table;
		this.map = map;
	}

	@Override
	public boolean open() {
		return true;

	}

	@Override
	public boolean write(Object output) {

		@SuppressWarnings("unchecked")
		Map<String, Object> tmp = (Map<String, Object>) output;
		// logger.debug("Output Map {}", tmp.toString());
		String sql = "";
		try {

			if (map != null && !map.isEmpty()) {
				List<String> valuesList = new ArrayList<String>();
				for (String value : map.values()) {
					if (tmp.containsKey(value)) {
						valuesList.add((String) tmp.get(value));
					} else {
						valuesList.add("");
					}
				}
				String fields = StringUtils.join(map.keySet(), "`,`");
				String values = StringUtils.join(valuesList, "\",\"");
				sql = String.format("%s INTO `%s`(`%s`) value(\"%s\")", this.method, this.table, fields, values);
			} else {

				sql = SqlUtil.join(this.method, this.table, tmp);
			}

			logger.debug("Output SQL {};", sql);
			this.insertId = outputJdbcTemplate.update(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return false;

	}

	@Override
	public boolean close() {
		return true;

	}

	public int getId() {
		return this.insertId;
	}

}
