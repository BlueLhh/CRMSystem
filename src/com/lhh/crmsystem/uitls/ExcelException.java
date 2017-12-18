package com.lhh.crmsystem.uitls;

/**
 * 创建错误类
 * 
 * @author 46512
 *
 */
public class ExcelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 构造函数1
	public ExcelException() {

	}

	// 构造函数2
	public ExcelException(String message) {

		super(message);
	}

	// 构造函数3
	public ExcelException(Throwable cause) {

		super(cause);
	}

	// 构造函数4
	public ExcelException(String message, Throwable cause) {

		super(message, cause);
	}

}
