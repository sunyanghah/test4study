package test.study.java.mianshiti2022;

import java.util.HashMap;
import java.util.Map;

/**
 * 前转数据对象基类
 * @author luyu
 *
 */
public class NotifyData implements  INotifyData{

	private static final long serialVersionUID = 2015070212000001L;
	/**
	 * 消息对象数据信息
	 */
	private Map<String, Object> notifyData;

	public NotifyData() {
		notifyData = new HashMap<String, Object>();
	}

	public NotifyData(int initialCapacity) {
		super();
        if (initialCapacity < 0){
        	throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
		notifyData = new HashMap<String, Object>(initialCapacity);
	}

	@Override
	public Object get(String key) {
		return notifyData.get(key);
	}

	@Override
	public void set(String key, Object value) {
		if (value != null){
			notifyData.put(key, value);
		}
	}

	@Override
	public Map<String, Object> getDataMap() {
		return notifyData;
	}
}
