package test.study.java.mianshiti2022;

import java.io.Serializable;
import java.util.Map;

public interface INotifyData extends Serializable {

	/**
	 * 根据key获取对应属性值
	 * @param key
	 * @return
	 */
	public Object get(String key);

	/**
	 * 设置属性值
	 * @param key
	 * @param value
	 */
	public void set(String key, Object value);

	/**
	 * 获取data map
	 * @return
	 */
	public Map<String, Object> getDataMap();

}
