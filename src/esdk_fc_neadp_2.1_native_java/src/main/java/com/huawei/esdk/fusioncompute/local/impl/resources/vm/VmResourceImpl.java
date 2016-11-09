/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.fusioncompute.local.impl.resources.vm;

import java.util.List;

import org.restlet.data.Method;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.esdk.fusioncompute.local.impl.SDKClient;
import com.huawei.esdk.fusioncompute.local.impl.bean.vm.CreateVmSnapshotReq;
import com.huawei.esdk.fusioncompute.local.impl.bean.vm.MigrateVMReq;
import com.huawei.esdk.fusioncompute.local.impl.bean.vm.MigrateVMVolReq;
import com.huawei.esdk.fusioncompute.local.impl.bean.vm.QueryVMsResp;
import com.huawei.esdk.fusioncompute.local.impl.bean.vm.QueryVmCustomizationsResp;
import com.huawei.esdk.fusioncompute.local.impl.bean.vm.RebootVMReq;
import com.huawei.esdk.fusioncompute.local.impl.bean.vm.StopVMReq;
import com.huawei.esdk.fusioncompute.local.impl.constant.ESDKURL;
import com.huawei.esdk.fusioncompute.local.impl.constant.NativeConstant;
import com.huawei.esdk.fusioncompute.local.impl.utils.ClientProvider;
import com.huawei.esdk.fusioncompute.local.impl.utils.EsdkVRMException;
import com.huawei.esdk.fusioncompute.local.impl.utils.StringUtils;
import com.huawei.esdk.fusioncompute.local.impl.utils.URLUtils;
import com.huawei.esdk.fusioncompute.local.model.ClientProviderBean;
import com.huawei.esdk.fusioncompute.local.model.FCSDKResponse;
import com.huawei.esdk.fusioncompute.local.model.PageList;
import com.huawei.esdk.fusioncompute.local.model.SDKCommonResp;
import com.huawei.esdk.fusioncompute.local.model.VRMTask;
import com.huawei.esdk.fusioncompute.local.model.vm.CmdexeReq;
import com.huawei.esdk.fusioncompute.local.model.vm.CreatVmReq;
import com.huawei.esdk.fusioncompute.local.model.vm.ExportVmTempReq;
import com.huawei.esdk.fusioncompute.local.model.vm.ExportVmTempResp;
import com.huawei.esdk.fusioncompute.local.model.vm.ImportVmTempReq;
import com.huawei.esdk.fusioncompute.local.model.vm.ImportVmTempResp;
import com.huawei.esdk.fusioncompute.local.model.vm.MigrateVmVol;
import com.huawei.esdk.fusioncompute.local.model.vm.ModifyVmReq;
import com.huawei.esdk.fusioncompute.local.model.vm.ModifyVmSnapshotReq;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryOsVersionsResp;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmSnapshotByIdResp;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmSnapshotResp;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmStatResp;
import com.huawei.esdk.fusioncompute.local.model.vm.QueryVmsReq;
import com.huawei.esdk.fusioncompute.local.model.vm.RecycleVolReq;
import com.huawei.esdk.fusioncompute.local.model.vm.UploadVmDataReq;
import com.huawei.esdk.fusioncompute.local.model.vm.VmCloneTempReq;
import com.huawei.esdk.fusioncompute.local.model.vm.VmCustomization;
import com.huawei.esdk.fusioncompute.local.model.vm.VmInfo;
import com.huawei.esdk.fusioncompute.local.resources.vm.VmResource;

public class VmResourceImpl implements VmResource
{
	//    private static final Logger LOGGER = Logger.getLogger(VmResourceImpl.class);

	private static VmResourceImpl instance = null;

	private Gson gson = new GsonBuilder().serializeNulls().create();

	private SDKClient sdkRestClient;

	private ClientProviderBean bean;

	private ESDKURL esdkUrl = new ESDKURL();

	public static synchronized VmResourceImpl getInstance(ClientProviderBean bean)
	{
		if (null == instance)
		{
			instance = new VmResourceImpl();
		}

		instance.init(bean);
		return instance;
	}

	private VmResourceImpl()
	{
	}

	private void init(ClientProviderBean bean)
	{
		this.bean = bean;
		sdkRestClient = (SDKClient) ClientProvider.getClient(bean);
	}

	@Override
	public FCSDKResponse<VRMTask> createVM(String siteUri, CreatVmReq creatVmReq)
	{
		//LOGGER.info("createVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		//        String tempVncPwd = null;
		//        String osPwd = null;
		//        if (null != creatVmReq)
		//        {
		//            if (null != creatVmReq.getVncAccessInfo())
		//            {
		//                tempVncPwd = creatVmReq.getVncAccessInfo().getVncPassword();
		//                creatVmReq.getVncAccessInfo().setVncPassword("********");
		//            }
		//            if (null != creatVmReq.getOsOptions())
		//            {
		//                osPwd = creatVmReq.getOsOptions().getPassword();
		//                creatVmReq.getOsOptions().setPassword("********");
		//            }
		//            //LOGGER.info("request body:" + gson.toJson(creatVmReq));
		//            
		//            if (null != creatVmReq.getVncAccessInfo())
		//            {
		//                creatVmReq.getVncAccessInfo().setVncPassword(tempVncPwd);
		//            }
		//            if (null != creatVmReq.getOsOptions())
		//            {
		//                creatVmReq.getOsOptions().setPassword(osPwd);
		//            }
		//        }
		try
		{
			String json = sdkRestClient.invokeNoLog(Method.POST,
			        URLUtils.makeUrl(bean, esdkUrl.getCreateVmUrl(), new String[] { siteUri }), creatVmReq, "CreateVM");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("createVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("createVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("createVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> deleteVM(String vmUri, Integer isReserveDisks, Integer isFormat, Integer holdTime)
	{
		//LOGGERnfo("deleteVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		try
		{
			String json =

			sdkRestClient.delete(
			        URLUtils.makeUrl(bean, esdkUrl.getDeleteVmUrl(), new String[] { vmUri, StringUtils.convertString(isReserveDisks),
			                StringUtils.convertString(isFormat), StringUtils.convertString(holdTime) }), "DeleteVM");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("deleteVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("deleteVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("deleteVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VmInfo> queryVM(String vmUri)
	{
		//LOGGER.info("queryVM() begin");
		FCSDKResponse<VmInfo> resp = null;
		try
		{
			String json = sdkRestClient.invokeNoLog(Method.GET, URLUtils.makeUrl(bean, esdkUrl.getQueryVmUrl(), new String[] { vmUri }),
			        null, "QueryVM");

			VmInfo result = gson.fromJson(json, VmInfo.class);

			String tempVncPwd = null;
			String tempVncOldPwd = null;
			String osPwd = null;
			if (null != result)
			{
				if (null != result.getVncAcessInfo())
				{
					tempVncPwd = result.getVncAcessInfo().getVncPassword();
					result.getVncAcessInfo().setVncPassword("********");
					tempVncOldPwd = result.getVncAcessInfo().getVncOldPassword();
					result.getVncAcessInfo().setVncOldPassword("********");
				}
				if (null != result.getOsOptions())
				{
					osPwd = result.getOsOptions().getPassword();
					result.getOsOptions().setPassword("********");
				}

				//LOGGER.info("response:" + gson.toJson(result));
				resp = new FCSDKResponse<VmInfo>();
				resp.setResult(result);
				//LOGGER.info("sdk resp: " + gson.toJson(resp));

				if (null != result.getVncAcessInfo())
				{
					result.getVncAcessInfo().setVncPassword(tempVncPwd);
					result.getVncAcessInfo().setVncOldPassword(tempVncOldPwd);
				}
				if (null != result.getOsOptions())
				{
					result.getOsOptions().setPassword(osPwd);
				}
			}
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("queryVM EsdkVRMException", e);
			resp = new FCSDKResponse<VmInfo>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
			//LOGGER.info("sdk resp: " + gson.toJson(resp));
		}
		catch (Exception e)
		{
			//LOGGER.error("queryVM Exception", e);
			resp = new FCSDKResponse<VmInfo>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
			//LOGGER.info("sdk resp: " + gson.toJson(resp));
		}
		//LOGGER.info("queryVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<PageList<VmInfo>> queryVMs(QueryVmsReq queryVmsReq, String siteUri)
	{
		FCSDKResponse<PageList<VmInfo>> resp = null;
		if (null == queryVmsReq)
		{
			queryVmsReq = new QueryVmsReq();
		}
		try
		{
			String url = URLUtils.makeUrl(
			        bean,
			        esdkUrl.getQueryVMsUrl(),
			        new String[] { siteUri, StringUtils.convertString(queryVmsReq.getLimit()),
			                StringUtils.convertString(queryVmsReq.getOffset()), queryVmsReq.getName(), queryVmsReq.getGroup(),
			                queryVmsReq.getScope(), StringUtils.convertString(queryVmsReq.getIsTemplate()),
			                StringUtils.convertString(queryVmsReq.getIsLinkClone()), queryVmsReq.getTemplateUrn(),
			                queryVmsReq.getPvDriverStatus(), queryVmsReq.getStatus(), queryVmsReq.getIp(), queryVmsReq.getMac(),
			                queryVmsReq.getVmId(), queryVmsReq.getUuid(), StringUtils.convertString(queryVmsReq.getResourceGroupFlag()),
			                StringUtils.convertString(queryVmsReq.getDetail()), queryVmsReq.getDescription(),
			                queryVmsReq.getExternalUuid(), StringUtils.convertString(queryVmsReq.getVmType()),
			                StringUtils.convertString(queryVmsReq.getDrsRuleIndex()) });
			if (null != queryVmsReq.getVmurns())
			{
				for (String vmUrn : queryVmsReq.getVmurns())
				{
					if (null != vmUrn)
					{
						url = url.concat("&vmurns=").concat(vmUrn);
					}
				}
			}
			if (url.indexOf("vms&vmurns") > -1)
			{
				url = url.replaceFirst("&", "?");
			}
			String json = sdkRestClient.get(url, "QueryVMs");
			QueryVMsResp queryVMsResp = gson.fromJson(json, QueryVMsResp.class);
			resp = new FCSDKResponse<PageList<VmInfo>>();

			if (null != queryVMsResp)
			{
				PageList<VmInfo> result = new PageList<VmInfo>();
				result.setList(queryVMsResp.getVms());
				result.setTotal(queryVMsResp.getTotal());

				resp.setResult(result);
			}
		}
		catch (EsdkVRMException e)
		{
			resp = new FCSDKResponse<PageList<VmInfo>>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (RuntimeException e)
		{
			resp = new FCSDKResponse<PageList<VmInfo>>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}
		catch (Exception e)
		{
			resp = new FCSDKResponse<PageList<VmInfo>>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> startVM(String vmUri)
	{
		//LOGGER.info("startVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		try
		{
			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getStartVmUrl(), new String[] { vmUri }), null, "StartVM");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("startVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("startVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("startVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> stopVM(String vmUri, String mode)
	{
		//LOGGER.info("stopVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		StopVMReq req = new StopVMReq();
		req.setMode(mode);
		try
		{
			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getStopVmUrl(), new String[] { vmUri }), req, "StopVM");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("stopVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("stopVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("stopVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> rebootVM(String vmUri, String mode)
	{
		//LOGGER.info("rebootVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		try
		{
			RebootVMReq req = new RebootVMReq();
			req.setMode(mode);

			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getRebootVmUrl(), new String[] { vmUri }), req, "RebootVM");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("rebootVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("rebootVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("rebootVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> pauseVM(String vmUri)
	{
		//LOGGER.info("pauseVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		try
		{
			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getPauseVmUrl(), new String[] { vmUri }), null, "PauseVM");
			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("pauseVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("pauseVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("pauseVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> resumeVM(String vmUri)
	{
		//LOGGER.info("resumeVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		try
		{
			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getResumeVmUrl(), new String[] { vmUri }), null, "ResumeVM");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("resumeVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("resumeVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("resumeVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> hibernateVM(String vmUri)
	{
		//LOGGER.info("hibernateVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		try
		{
			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getHibernateVmUrl(), new String[] { vmUri }), null,
			        "HibernateVM");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("hibernateVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("hibernateVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("hibernateVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> modifyVM(String vmUri, ModifyVmReq modifyVMReq)
	{
		//LOGGER.info("modifyVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		//修改时使用的字段少,赋值null TODO
		if (null != modifyVMReq && null != modifyVMReq.getProperties())
		{
			modifyVMReq.getProperties().setReoverByHost(null);
			modifyVMReq.getProperties().setIsEnableMemVol(null);
			modifyVMReq.getProperties().setAttachType(null);
			modifyVMReq.getProperties().setGpuShareType(null);
		}

		//        String tempVncPwd = null;
		//        String tempVncOldPwd = null;
		//        String osPwd = null;
		//        if (null != modifyVMReq)
		//        {
		//            if (null != modifyVMReq.getVncAccessInfo())
		//            {
		//                tempVncPwd = modifyVMReq.getVncAccessInfo().getVncPassword();
		//                modifyVMReq.getVncAccessInfo().setVncPassword("********");
		//                tempVncOldPwd = modifyVMReq.getVncAccessInfo().getVncOldPassword();
		//                modifyVMReq.getVncAccessInfo().setVncOldPassword("********");
		//            }
		//            if (null != modifyVMReq.getOsOptions())
		//            {
		//                osPwd = modifyVMReq.getOsOptions().getPassword();
		//                modifyVMReq.getOsOptions().setPassword("********");
		//            }
		//            
		//            //LOGGER.info("request body:" + gson.toJson(modifyVMReq));
		//            
		//            if (null != modifyVMReq.getVncAccessInfo())
		//            {
		//                modifyVMReq.getVncAccessInfo().setVncPassword(tempVncPwd);
		//                modifyVMReq.getVncAccessInfo().setVncOldPassword(tempVncOldPwd);
		//            }
		//            if (null != modifyVMReq.getOsOptions())
		//            {
		//                modifyVMReq.getOsOptions().setPassword(osPwd);
		//            }
		//        }
		try
		{

			String json = sdkRestClient.invokeNoLog(Method.PUT, URLUtils.makeUrl(bean, esdkUrl.getModifyVmUrl(), new String[] { vmUri }),
			        modifyVMReq, "ModifyVM");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("modifyVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("modifyVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("modifyVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> migrateVM(String vmUri, String location, Boolean isBindingHost, Boolean enableMemoryCompression)
	{
		//LOGGER.info("migrateVM() begin");
		FCSDKResponse<VRMTask> resp = null;
		try
		{
			MigrateVMReq req = new MigrateVMReq();
			req.setLocation(location);
			req.setBindingHost(isBindingHost);
			req.setEnableMemoryCompression(enableMemoryCompression);

			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getMigrateVmUrl(), new String[] { vmUri }), req, "MigrateVM");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("migrateVM EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("migrateVM Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("migrateVM() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> migrateVMVol(String vmUri, List<MigrateVmVol> disks, Integer speed)
	{
		//LOGGER.info("migrateVMVol() begin");
		FCSDKResponse<VRMTask> resp = null;
		try
		{
			MigrateVMVolReq req = new MigrateVMVolReq();
			req.setDisks(disks);
			req.setSpeed(speed);

			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getMigrateVmVolUrl(), new String[] { vmUri }), req,
			        "MigrateVMVol");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("migrateVMVol EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("migrateVMVol Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("migrateVMVol() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> vmCloneTemp(String vmUri, VmCloneTempReq vmCloneTempReq)
	{
		//LOGGER.info("vmCloneTemp() begin");
		FCSDKResponse<VRMTask> result = null;

		//        String pwd = null;
		//        String dpwd = null;
		//        String vpwd = null;
		//        if (null != vmCloneTempReq)
		//        {
		//            if (null != vmCloneTempReq.getVmCustomization())
		//            {
		//                pwd = vmCloneTempReq.getVmCustomization().getPassword();
		//                vmCloneTempReq.getVmCustomization().setPassword("********");
		//                dpwd = vmCloneTempReq.getVmCustomization().getDomainPassword();
		//                vmCloneTempReq.getVmCustomization().setDomainPassword("********");
		//            }
		//            if (null != vmCloneTempReq.getVncAccessInfo())
		//            {
		//                vpwd = vmCloneTempReq.getVncAccessInfo().getVncPassword();
		//                vmCloneTempReq.getVncAccessInfo().setVncPassword("********");
		//            }
		//            
		//            //LOGGER.info("request body:" + gson.toJson(vmCloneTempReq));
		//            
		//            if (null != vmCloneTempReq.getVmCustomization())
		//            {
		//                vmCloneTempReq.getVmCustomization().setPassword(pwd);
		//                vmCloneTempReq.getVmCustomization().setDomainPassword(dpwd);
		//            }
		//            if (null != vmCloneTempReq.getVncAccessInfo())
		//            {
		//                vmCloneTempReq.getVncAccessInfo().setVncPassword(vpwd);
		//            }
		//        }

		try
		{

			String json = sdkRestClient.invokeNoLog(Method.POST,
			        URLUtils.makeUrl(bean, esdkUrl.getVmResourceVmCloneTemp(), new String[] { vmUri }), vmCloneTempReq, "VmCloneTemp");

			//LOGGER.info("response:" + json);

			VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
			result = new FCSDKResponse<VRMTask>();
			result.setResult(vrmTask);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("vmCloneTemp EsdkVRMException", e);
			result = new FCSDKResponse<VRMTask>();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("vmCloneTemp Exception", e);
			result = new FCSDKResponse<VRMTask>();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(result));
		//LOGGER.info("vmCloneTemp() end");
		return result;
	}

	@Override
	public FCSDKResponse<ImportVmTempResp> importTemplate(String siteUri, ImportVmTempReq importVmTempReq)
	{
		//LOGGER.info("importTemplate() begin");
		FCSDKResponse<ImportVmTempResp> result = null;

		//        String pwd = null;
		//        String opwd = null;
		//        String cpwd = null;
		//        String dpwd = null;
		//        String vpwd = null;
		//        if (null != importVmTempReq)
		//        {
		//            pwd = importVmTempReq.getPassword();
		//            importVmTempReq.setPassword("********");
		//            if (null != importVmTempReq.getOsOptions())
		//            {
		//                opwd = importVmTempReq.getOsOptions().getPassword();
		//                importVmTempReq.getOsOptions().setPassword("********");
		//            }
		//            if (null != importVmTempReq.getVmCustomization())
		//            {
		//                cpwd = importVmTempReq.getVmCustomization().getPassword();
		//                importVmTempReq.getVmCustomization().setPassword("********");
		//                dpwd = importVmTempReq.getVmCustomization().getDomainPassword();
		//                importVmTempReq.getVmCustomization().setDomainPassword("********");
		//            }
		//            if (null != importVmTempReq.getVncAccessInfo())
		//            {
		//                vpwd = importVmTempReq.getVncAccessInfo().getVncPassword();
		//                importVmTempReq.getVncAccessInfo().setVncPassword("********");
		//            }
		//            
		//            //LOGGER.info("request body:" + gson.toJson(importVmTempReq));
		//            
		//            importVmTempReq.setPassword(pwd);
		//            if (null != importVmTempReq.getOsOptions())
		//            {
		//                importVmTempReq.getOsOptions().setPassword(opwd);
		//            }
		//            if (null != importVmTempReq.getVmCustomization())
		//            {
		//                importVmTempReq.getVmCustomization().setPassword(cpwd);
		//                importVmTempReq.getVmCustomization().setDomainPassword(dpwd);
		//            }
		//            if (null != importVmTempReq.getVncAccessInfo())
		//            {
		//                importVmTempReq.getVncAccessInfo().setVncPassword(vpwd);
		//            }
		//        }

		try
		{
			String json = sdkRestClient.invokeNoLog(Method.POST,
			        URLUtils.makeUrl(bean, esdkUrl.getVmResourceImportTemplate(), new String[] { siteUri }), importVmTempReq,
			        "ImportTemplate");

			//LOGGER.info("response:" + json);

			ImportVmTempResp resp = gson.fromJson(json, ImportVmTempResp.class);
			result = new FCSDKResponse<ImportVmTempResp>();
			result.setResult(resp);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("importTemplate EsdkVRMException", e);
			result = new FCSDKResponse<ImportVmTempResp>();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("importTemplate Exception", e);
			result = new FCSDKResponse<ImportVmTempResp>();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(result));
		//LOGGER.info("importTemplate() end");
		return result;
	}

	@Override
	public FCSDKResponse<ExportVmTempResp> exportTemplate(String vmUri, ExportVmTempReq exportVmTempReq)
	{
		//LOGGER.info("exportTemplate() begin");
		FCSDKResponse<ExportVmTempResp> result = null;

		//        String pwd = null;
		//        if (null != exportVmTempReq)
		//        {
		//            pwd = exportVmTempReq.getPassword();
		//            exportVmTempReq.setPassword("********");
		//            
		//            //LOGGER.info("request body:" + gson.toJson(exportVmTempReq));
		//            
		//            exportVmTempReq.setPassword(pwd);
		//        }

		try
		{

			String json = sdkRestClient.invokeNoLog(Method.POST,
			        URLUtils.makeUrl(bean, esdkUrl.getVmResourceExportTemplate(), new String[] { vmUri }), exportVmTempReq,
			        "ExportTemplate");

			//LOGGER.info("response:" + json);

			ExportVmTempResp resp = gson.fromJson(json, ExportVmTempResp.class);
			result = new FCSDKResponse<ExportVmTempResp>();
			result.setResult(resp);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("exportTemplate EsdkVRMException", e);
			result = new FCSDKResponse<ExportVmTempResp>();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("exportTemplate Exception", e);
			result = new FCSDKResponse<ExportVmTempResp>();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(result));
		//LOGGER.info("exportTemplate() end");
		return result;
	}

	@Override
	public FCSDKResponse<VRMTask> createVmSnapshot(String vmUri, String name, String description, String type, Boolean needMemoryShot,
	        Boolean isConsistent)
	{
		//LOGGER.info("createVmSnapshot() begin");
		FCSDKResponse<VRMTask> result = null;

		CreateVmSnapshotReq createVmSnapshotReq = new CreateVmSnapshotReq();
		createVmSnapshotReq.setName(name);
		createVmSnapshotReq.setDescription(description);
		createVmSnapshotReq.setType(type);
		createVmSnapshotReq.setNeedMemoryShot(needMemoryShot);
		createVmSnapshotReq.setIsConsistent(isConsistent);

		try
		{
			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getVmResourceCreateVmSnapshot(), new String[] { vmUri }),
			        createVmSnapshotReq, "CreateVmSnapshot");

			VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
			result = new FCSDKResponse<VRMTask>();
			result.setResult(vrmTask);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("createVmSnapshot EsdkVRMException", e);
			result = new FCSDKResponse<VRMTask>();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("createVmSnapshot Exception", e);
			result = new FCSDKResponse<VRMTask>();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(result));
		//LOGGER.info("createVmSnapshot() end");
		return result;
	}

	@Override
	public SDKCommonResp modifyVmSnapshot(String name, String description, String vmSnapshotUri)
	{
		//LOGGER.info("modifyVmSnapshot() begin");
		SDKCommonResp resp = null;

		ModifyVmSnapshotReq req = new ModifyVmSnapshotReq();
		req.setDescription(description);
		req.setName(name);

		try
		{
			sdkRestClient.put(URLUtils.makeUrl(bean, esdkUrl.getModifyVmSnapshotUrl(), new String[] { vmSnapshotUri }), req,
			        "ModifyVmSnapshot");

			resp = new SDKCommonResp();
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("modifyVmSnapshot EsdkVRMException", e);
			resp = new SDKCommonResp();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("modifyVmSnapshot Exception", e);
			resp = new SDKCommonResp();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			resp.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("modifyVmSnapshot() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> deleteVmSnapshot(String vmSnapshotUri)
	{
		//LOGGER.info("deleteVmSnapshot() begin");
		FCSDKResponse<VRMTask> result = null;
		try
		{
			String json = sdkRestClient.delete(
			        URLUtils.makeUrl(bean, esdkUrl.getVmResourceDeleteVmSnapshot(), new String[] { vmSnapshotUri }), "DeleteVmSnapshot");

			VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
			result = new FCSDKResponse<VRMTask>();
			result.setResult(vrmTask);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("deleteVmSnapshot EsdkVRMException", e);
			result = new FCSDKResponse<VRMTask>();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("deleteVmSnapshot Exception", e);
			result = new FCSDKResponse<VRMTask>();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(result));
		//LOGGER.info("deleteVmSnapshot() end");
		return result;
	}

	@Override
	public FCSDKResponse<VRMTask> createVmCustomization(String siteUri, VmCustomization vmCustomization)
	{
		//LOGGER.info("createVmCustomization() begin");
		FCSDKResponse<VRMTask> result = null;
		if (null != vmCustomization)
		{
			vmCustomization.setUri(null);
			vmCustomization.setUrn(null);
			//            
			//            String tempPwd = vmCustomization.getPassword();
			//            String tempDomainPwd = vmCustomization.getDomainPassword();
			//            
			//            vmCustomization.setPassword("********");
			//            vmCustomization.setDomainPassword("********");
			//            //LOGGER.info("request body:" + gson.toJson(vmCustomization));
			//            vmCustomization.setPassword(tempPwd);
			//            vmCustomization.setDomainPassword(tempDomainPwd);
		}

		try
		{
			String json = sdkRestClient.invokeNoLog(Method.POST,
			        URLUtils.makeUrl(bean, esdkUrl.getVmResourceCreateVmCustomization(), new String[] { siteUri }), vmCustomization,
			        "CreateVmCustomization");

			//LOGGER.info("response:" + json);
			VRMTask vrmTask = gson.fromJson(json, VRMTask.class);
			result = new FCSDKResponse<VRMTask>();
			result.setResult(vrmTask);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("createVmCustomization EsdkVRMException", e);
			result = new FCSDKResponse<VRMTask>();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("createVmCustomization Exception", e);
			result = new FCSDKResponse<VRMTask>();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(result));
		//LOGGER.info("createVmCustomization() end");
		return result;
	}

	@Override
	public SDKCommonResp removeVmCustomization(String vmCustomizationUri)
	{
		//LOGGER.info("removeVmCustomization() begin");
		SDKCommonResp result = null;
		try
		{
			sdkRestClient.delete(URLUtils.makeUrl(bean, esdkUrl.getVmResourceRemoveVmCustomization(), new String[] { vmCustomizationUri }),
			        "RemoveVmCustomization");

			result = new SDKCommonResp();
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("removeVmCustomization EsdkVRMException", e);
			result = new SDKCommonResp();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("removeVmCustomization Exception", e);
			result = new SDKCommonResp();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(result));
		//LOGGER.info("removeVmCustomization() end");
		return result;
	}

	@Override
	public SDKCommonResp modifyVmCustomization(String vmCustomizationUri, VmCustomization vmCustomization)
	{
		//LOGGER.info("modifyVmCustomization() begin");
		SDKCommonResp result = null;

		if (null != vmCustomization)
		{
			vmCustomization.setUri(null);
			vmCustomization.setUrn(null);

			//            String tempPwd = vmCustomization.getPassword();
			//            String tempDomainPwd = vmCustomization.getDomainPassword();
			//            
			//            vmCustomization.setPassword("********");
			//            vmCustomization.setDomainPassword("********");
			//            //LOGGER.info("request body:" + gson.toJson(vmCustomization));
			//            vmCustomization.setPassword(tempPwd);
			//            vmCustomization.setDomainPassword(tempDomainPwd);
		}

		try
		{
			sdkRestClient.invokeNoLog(Method.PUT,
			        URLUtils.makeUrl(bean, esdkUrl.getVmResourceModifyVmCustomization(), new String[] { vmCustomizationUri }),
			        vmCustomization, "ModifyVmCustomization");

			result = new SDKCommonResp();
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("modifyVmCustomization EsdkVRMException", e);
			result = new SDKCommonResp();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("modifyVmCustomization Exception", e);
			result = new SDKCommonResp();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(result));
		//LOGGER.info("modifyVmCustomization() end");
		return result;
	}

	@Override
	public FCSDKResponse<VmCustomization> queryVmCustomization(String vmCustomizationUri)
	{
		//LOGGER.info("queryVmCustomization() begin");
		FCSDKResponse<VmCustomization> result = null;

		try
		{
			//LOGGER.info("request body:null");

			String json = sdkRestClient.invokeNoLog(Method.GET,
			        URLUtils.makeUrl(bean, esdkUrl.getVmResourceQueryVmCustomization(), new String[] { vmCustomizationUri }), null,
			        "QueryVmCustomization");

			VmCustomization vmCustomization = gson.fromJson(json, VmCustomization.class);

			//            String pwd = null;
			//            String dpwd = null;
			//            if (null != vmCustomization)
			//            {
			//                pwd = vmCustomization.getPassword();
			//                vmCustomization.setPassword("********");
			//                dpwd = vmCustomization.getDomainPassword();
			//                vmCustomization.setDomainPassword("********");
			//                
			//                //LOGGER.info("response:" + gson.toJson(vmCustomization));
			//                
			//                result = new FCSDKResponse<VmCustomization>();
			//                result.setResult(vmCustomization);
			//                //LOGGER.info("sdk resp: " + gson.toJson(result));
			//                
			//                vmCustomization.setPassword(pwd);
			//                vmCustomization.setDomainPassword(dpwd);
			//            }

			result = new FCSDKResponse<VmCustomization>();
			result.setResult(vmCustomization);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("queryVmCustomization EsdkVRMException", e);
			result = new FCSDKResponse<VmCustomization>();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
			//LOGGER.info("sdk resp: " + gson.toJson(result));
		}
		catch (Exception e)
		{
			//LOGGER.error("queryVmCustomization Exception", e);
			result = new FCSDKResponse<VmCustomization>();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
			//LOGGER.info("sdk resp: " + gson.toJson(result));
		}
		//LOGGER.info("queryVmCustomization() end");
		return result;
	}

	@Override
	public FCSDKResponse<PageList<VmCustomization>> queryVmCustomizations(String siteUri, Integer limit, Integer offset, String name)
	{
		//LOGGER.info("queryVmCustomizations() begin");
		FCSDKResponse<PageList<VmCustomization>> result = null;
		try
		{
			String url = URLUtils.makeUrl(bean, esdkUrl.getVmResourceQueryVmCustomizations(),
			        new String[] { siteUri, StringUtils.convertString(limit), StringUtils.convertString(offset), name });
			String json = sdkRestClient.invokeNoLog(Method.GET, url, null, "QueryVmCustomizations");

			QueryVmCustomizationsResp resp = gson.fromJson(json, QueryVmCustomizationsResp.class);

			PageList<VmCustomization> pageList = new PageList<VmCustomization>();
			if (null != resp)
			{
				pageList.setList(resp.getVmCustomizations());
				pageList.setTotal(resp.getTotal());
				result = new FCSDKResponse<PageList<VmCustomization>>();
				result.setResult(pageList);
			}
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("queryVmCustomizations EsdkVRMException", e);
			result = new FCSDKResponse<PageList<VmCustomization>>();
			result.setErrorCode(e.getErrInfo().getErrorCode());
			result.setErrorDes(e.getErrInfo().getErrorDes());
			//LOGGER.info("sdk resp: " + gson.toJson(result));
		}
		catch (Exception e)
		{
			//LOGGER.error("queryVmCustomizations Exception", e);
			result = new FCSDKResponse<PageList<VmCustomization>>();
			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
			//LOGGER.info("sdk resp: " + gson.toJson(result));
		}
		//LOGGER.info("queryVmCustomizations() end");
		return result;
	}

	@Override
	public FCSDKResponse<QueryVmSnapshotResp> queryVmSnapshot(String vmUri)
	{
		//LOGGER.info("queryVmSnapshot() begin");
		FCSDKResponse<QueryVmSnapshotResp> resp = null;

		try
		{
			String json = sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryVmSnapshotUrl(), new String[] { vmUri }),
			        "QueryVmSnapshot");

			QueryVmSnapshotResp result = gson.fromJson(json, QueryVmSnapshotResp.class);
			resp = new FCSDKResponse<QueryVmSnapshotResp>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("queryVmSnapshot EsdkVRMException", e);
			resp = new FCSDKResponse<QueryVmSnapshotResp>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("queryVmSnapshot Exception", e);
			resp = new FCSDKResponse<QueryVmSnapshotResp>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("queryVmSnapshot() end");
		return resp;
	}

	@Override
	public FCSDKResponse<QueryOsVersionsResp> queryOsVersions(String siteUri)
	{
		//LOGGER.info("queryOsVersions() begin");
		FCSDKResponse<QueryOsVersionsResp> resp = null;

		try
		{
			String json = sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryOsVersionsUrl(), new String[] { siteUri }),
			        "QueryOsVersions");

			QueryOsVersionsResp result = gson.fromJson(json, QueryOsVersionsResp.class);
			resp = new FCSDKResponse<QueryOsVersionsResp>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("queryOsVersions EsdkVRMException", e);
			resp = new FCSDKResponse<QueryOsVersionsResp>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("queryOsVersions Exception", e);
			resp = new FCSDKResponse<QueryOsVersionsResp>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("queryOsVersions() end");
		return resp;
	}

	@Override
	public FCSDKResponse<QueryVmSnapshotByIdResp> queryVmSnapshotById(String vmSnapshotUri, Boolean refreshflag)
	{
		//LOGGER.info("queryVmSnapshotById() begin");
		FCSDKResponse<QueryVmSnapshotByIdResp> resp = null;

		try
		{
			String json = sdkRestClient.get(
			        URLUtils.makeUrl(bean, esdkUrl.getQueryVmSnapshotByIdUrl(),
			                new String[] { vmSnapshotUri, StringUtils.convertString(refreshflag) }), "QueryVmSnapshotById");

			QueryVmSnapshotByIdResp result = gson.fromJson(json, QueryVmSnapshotByIdResp.class);
			resp = new FCSDKResponse<QueryVmSnapshotByIdResp>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("queryVmSnapshotById EsdkVRMException", e);
			resp = new FCSDKResponse<QueryVmSnapshotByIdResp>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("queryVmSnapshotById Exception", e);
			resp = new FCSDKResponse<QueryVmSnapshotByIdResp>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("queryVmSnapshotById() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> restoreVmBySnapshot(String vmSnapshotUri)
	{
		//LOGGER.info("restoreVmBySnapshot() begin");
		FCSDKResponse<VRMTask> resp = null;

		try
		{
			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getRestoreVmBySnapshotUrl(), new String[] { vmSnapshotUri }),
			        null, "RestoreVmBySnapshot");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("restoreVmBySnapshot EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("restoreVmBySnapshot Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("restoreVmBySnapshot() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> recycle(String vmUri)
	{
		//LOGGER.info("recycle() begin");
		FCSDKResponse<VRMTask> resp = null;

		try
		{
			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getRecycle(), new String[] { vmUri }), null, "Recycle");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("recycle EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("recycle Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("recycle() end");
		return resp;
	}

	@Override
	public FCSDKResponse<VRMTask> recycleVol(String vmUri, RecycleVolReq RecycleVolReq)
	{
		//LOGGER.info("recycleVol() begin");
		FCSDKResponse<VRMTask> resp = null;

		try
		{
			String json = sdkRestClient.post(URLUtils.makeUrl(bean, esdkUrl.getRecycleVol(), new String[] { vmUri }), RecycleVolReq,
			        "RecycleVol");

			VRMTask result = gson.fromJson(json, VRMTask.class);
			resp = new FCSDKResponse<VRMTask>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("recycleVol EsdkVRMException", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("recycleVol Exception", e);
			resp = new FCSDKResponse<VRMTask>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("recycleVol() end");
		return resp;
	}

	@Override
	public FCSDKResponse<QueryVmStatResp> queryVmStat(String siteUri, String scope)
	{
		//LOGGER.info("queryVmStat() begin");
		FCSDKResponse<QueryVmStatResp> resp = null;

		try
		{
			String json = sdkRestClient.get(URLUtils.makeUrl(bean, esdkUrl.getQueryVmStat(), new String[] { siteUri, scope }),
			        "QueryVmStat");

			QueryVmStatResp result = gson.fromJson(json, QueryVmStatResp.class);
			resp = new FCSDKResponse<QueryVmStatResp>();
			resp.setResult(result);
		}
		catch (EsdkVRMException e)
		{
			//LOGGER.error("queryVmStat EsdkVRMException", e);
			resp = new FCSDKResponse<QueryVmStatResp>();
			resp.setErrorCode(e.getErrInfo().getErrorCode());
			resp.setErrorDes(e.getErrInfo().getErrorDes());
		}
		catch (Exception e)
		{
			//LOGGER.error("queryVmStat Exception", e);
			resp = new FCSDKResponse<QueryVmStatResp>();
			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
		}

		//LOGGER.info("sdk resp: " + gson.toJson(resp));
		//LOGGER.info("queryVmStat() end");
		return resp;
	}

//	@Override
//	public FCSDKResponse<VRMTask> uploadVmData(String vmUri, UploadVmDataReq req)
//	{
//		//TODO
//		FCSDKResponse<VRMTask> resp = null;
//
//		try
//		{
//			String json = sdkRestClient
//			        .post(URLUtils.makeUrl(bean, esdkUrl.getUploadVmData(), new String[] { vmUri }), req, "UploadVmData");
//
//			VRMTask result = gson.fromJson(json, VRMTask.class);
//			resp = new FCSDKResponse<VRMTask>();
//			resp.setResult(result);
//		}
//		catch (EsdkVRMException e)
//		{
//			resp = new FCSDKResponse<VRMTask>();
//			resp.setErrorCode(e.getErrInfo().getErrorCode());
//			resp.setErrorDes(e.getErrInfo().getErrorDes());
//		}
//		catch (Exception e)
//		{
//			resp = new FCSDKResponse<VRMTask>();
//			resp.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
//		}
//
//		return resp;
//	}

//	@Override
//	public SDKCommonResp cmdexe(String vmUri, CmdexeReq req)
//	{
//		//TODO
//		SDKCommonResp result = null;
//
//		try
//		{
//			sdkRestClient.invokeNoLog(Method.POST, URLUtils.makeUrl(bean, esdkUrl.getCmdexe(), new String[] { vmUri }), req, "Cmdexe");
//
//			result = new SDKCommonResp();
//		}
//		catch (EsdkVRMException e)
//		{
//			result = new SDKCommonResp();
//			result.setErrorCode(e.getErrInfo().getErrorCode());
//			result.setErrorDes(e.getErrInfo().getErrorDes());
//		}
//		catch (Exception e)
//		{
//			result = new SDKCommonResp();
//			result.setErrorCode(NativeConstant.NATIVE_EXCEPTION);
//			result.setErrorDes(NativeConstant.NATIVE_EXCEPTION_DES);
//		}
//
//		return result;
//	}
}
