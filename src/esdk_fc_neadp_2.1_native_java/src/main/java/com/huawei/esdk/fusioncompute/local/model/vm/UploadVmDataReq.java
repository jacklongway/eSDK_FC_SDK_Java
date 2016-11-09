package com.huawei.esdk.fusioncompute.local.model.vm;

/**
 * 给虚拟机传入自定义数据请求信息。
 */
public class UploadVmDataReq
{
	/**
	 * 虚拟机自定义数据，长度 [0,1024]。
	 */
	private String vmData;

	/**
	 * 自定义数据存放的文件名，长度[1,64]<br>
	 * 注：建议脚本文件存放目录地址如下：<br>
	 * Windows虚拟机：暂不支持自定义路径及扩展名<br>
	 * Linux虚拟机：/etc/.uvp-monitor，仅支持扩展名为.sh .py .pl的脚本文件名
	 */
	private String fileName;

	//    public UploadVmDataReq vmData(String vmData)
	//    {
	//        this.vmData = vmData;
	//        return this;
	//    }
	//    
	//    public UploadVmDataReq fileName(String fileName)
	//    {
	//        this.fileName = fileName;
	//        return this;
	//    }

	public String getVmData()
	{
		return vmData;
	}

	public void setVmData(String vmData)
	{
		this.vmData = vmData;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

}
