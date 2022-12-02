package test.study.java.mianshiti2022;

import java.util.ArrayList;
import java.util.List;


/**
 * 通知消息数据对象
 * <p>负责定义各种消息对象的类型值以及消息数据对象各种行为</p>
 * @author luyu
 * @version 1.0 2015-6-26
 */
public class NotifyDataContainer {

	/**
	 * 自动生成序列号
	 */
	private static final long serialVersionUID = 5313937598358123935L;

	private List<NotifyData> dataList;

	private int type;


	public NotifyDataContainer(int type){
		dataList = new ArrayList<NotifyData>();
		this.type = type;
	}

	public NotifyDataContainer(int initialCapacity, int type){
		super();
        if (initialCapacity < 0){
        	throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
        dataList = new ArrayList<NotifyData>(initialCapacity);
        this.type = type;
	}

	public List<NotifyData> getDataList() {
		return dataList;
	}

	public void setDataList(List<NotifyData> dataList) {
		this.dataList = dataList;
	}

	public int getType() {
		return type;
	}

	public void addElement(NotifyData element){
		this.dataList.add(element);
	}

	@Override
	public String toString() {
		return "NotifyDataContainer [dataList=" + dataList + ", type=" + type+ "]";
	}
}
