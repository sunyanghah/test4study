package test.study.java.mianshiti2022;

import java.io.Serializable;

/**
 * 描述由通知类型和通知内容组成的通知信息。
 * <p>通过通知类型，可以确定通知内容具体的类型，进而从其中获取通知信息。</p>
 * <p>通知信息可能在同一个进程内发布，也可能在多个不同的进程之间进行发布。</p>
 * @author James Gao
 * @since 1.3 2008-3-6
 */
public class Notification implements Serializable {

	/**
	 * 固化类版本标识，对类功能或结构进行修改时，应更新该标识。
	 */
	private static final long serialVersionUID = 2007042400001L;

	/**
	 * 通知类型。
	 */
	protected String type;

	/**
	 * 得到通知的内容。
	 */
	protected Serializable content;

	/**
	 * 新建通知信息对象。
	 * @param type 通知类型。
	 * @param content 通知的具体内容。
	 */
	public Notification(String type, Serializable content) {
		this.type = type;
		this.content = content;
	}

	/**
	 * 得到通知的内容。
	 * <p>通过通知类型，可以确定通知内容具体的类型，进而从其中获取通知信息。</p>
	 * @return 通知内容。
	 */
	public Serializable getContent() {
		return content;
	}

	/**
	 * 得到通知的类型。
	 * @return 通知类型。
	 */
	public String getType() {
		return type;
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() {
		StringBuffer retVal = new StringBuffer();
		retVal.append("Notification[type=").append(type);
		retVal.append(", content=").append(content).append("]");
		return retVal.toString();
	}

}
