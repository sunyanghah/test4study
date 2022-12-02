package test.study.java.mianshiti2022;

import java.io.Serializable;
import java.util.List;

/**
 * 通知消息数据对象
 * <p>负责定义各种消息对象的类型值以及消息数据对象各种行为</p>
 * @author luyu
 * @version 1.0 2015-6-26
 */
public interface INotifyDataContainer extends Serializable {

	/**
	 * 返回消息数据对象类型
	 * @return
	 */
	public int getType();

	void addElement(INotifyData element);

	List<INotifyData> getDataList();


}
