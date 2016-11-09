package com.huawei.esdk.fusioncompute.local.model.vm;

/**
 * 执行脚本命令请求信息。
 */
public class CmdexeReq
{
	/**
	 * 【必选】虚拟机中，用户自定义脚本的执行环境：<br>
	 * windows中支持：bat 、vbs、powershell<br>
	 * linux中支持：sh 、python、 perl
	 */
	private String cmdType;

	/**
	 * 【必选】虚拟机中可执行的用户自定义脚本文件名称<br>
	 * 注：该文件由虚拟机所属用户预先放置在虚拟机的执行目录中：<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; Windows：C:\VMTools\ 或 x:\reg\VMTools<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; Linux：/etc/.uvp-monitor<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; windows 虚拟机中，仅支持扩展名为.bat .vbs .psl的脚本文件名<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; linux虚拟机中，仅支持扩展名为.sh .py .pl的脚本文件名<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; 传入参数必须为标准化文件名，子目录格式、相对目录格式、命令连接符等非标准输入无效<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp; 文件名不能出现 “<”、“>”、“\”、“/”、“..”、“&”、"|"、空格“ ”、";"、“$”
	 */
	private String cmdFile;

	/**
	 * 输入脚本的参数，参数中可以使用的字符有：<br>
	 * 数字、字母、“.”、“-”、“:”、“@”、空格“ ”、“_”、“(”、“)”、“[”、“]”、“+”、“^”、“~”、“！”、“””、“#”、“%” 、“’”
	 */
	private String cmdPara;

	/**
	 * 用户自定义脚本文件的sha256摘要值，调用用户需获取到sha256摘要值并作为输入参数，如果输入摘要值与实际摘要值不符合时，执行失败<br>
	 * 注：参数cmdType、 cmdFile、cmdPara、checkValue字符串长度总和不能超过1015个字符
	 */
	private String checkValue;

	//    public CmdexeReq cmdType(String cmdType)
	//    {
	//        this.cmdType = cmdType;
	//        return this;
	//    }
	//    
	//    public CmdexeReq cmdFile(String cmdFile)
	//    {
	//        this.cmdFile = cmdFile;
	//        return this;
	//    }
	//    
	//    public CmdexeReq cmdPara(String cmdPara)
	//    {
	//        this.cmdPara = cmdPara;
	//        return this;
	//    }
	//    
	//    public CmdexeReq checkValue(String checkValue)
	//    {
	//        this.checkValue = checkValue;
	//        return this;
	//    }
	//    
	public String getCmdType()
	{
		return cmdType;
	}

	public void setCmdType(String cmdType)
	{
		this.cmdType = cmdType;
	}

	public String getCmdFile()
	{
		return cmdFile;
	}

	public void setCmdFile(String cmdFile)
	{
		this.cmdFile = cmdFile;
	}

	public String getCmdPara()
	{
		return cmdPara;
	}

	public void setCmdPara(String cmdPara)
	{
		this.cmdPara = cmdPara;
	}

	public String getCheckValue()
	{
		return checkValue;
	}

	public void setCheckValue(String checkValue)
	{
		this.checkValue = checkValue;
	}

}
