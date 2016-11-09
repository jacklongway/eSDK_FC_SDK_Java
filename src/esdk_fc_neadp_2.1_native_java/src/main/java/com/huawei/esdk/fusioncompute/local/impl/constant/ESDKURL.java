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
package com.huawei.esdk.fusioncompute.local.impl.constant;

/**
 * 
 * url常量类
 * <p>
 * @since eSDK Cloud V100R003C50
 */
public class ESDKURL
{
    private String[] authenticateUrl = {"/service/session"};
    
    public String[] getAuthenticateUrl()
    {
        return authenticateUrl.clone();
    }
    
    private String[] versionUrl = {"/service/versions"};
    
    public String[] getVersionUrl()
    {
        return versionUrl.clone();
    }
    
    private String[] vmResourceCreateVm = {"/vms"};
    
    public String[] getCreateVmUrl()
    {
        return vmResourceCreateVm.clone();
    }
    
    private String[] vmResourceQueryVm = {""};
    
    public String[] getQueryVmUrl()
    {
        return vmResourceQueryVm.clone();
    }
    
    private String[] vmResourceQueryVms = {"/vms?", "limit", "offset", "name", "group", "scope", "isTemplate",
        "isLinkClone", "templateUrn", "pvDriverStatus", "status", "ip", "mac", "vmId", "uuid", "resourceGroupFlag",
        "detail", "description", "externalUuid", "vmType", "drsRuleIndex"};
    
    public String[] getQueryVMsUrl()
    {
        return vmResourceQueryVms.clone();
    }
    
    private String[] vmResourceDeleteVm = {"?", "isReserveDisks", "isFormat", "holdTime"};
    
    public String[] getDeleteVmUrl()
    {
        return vmResourceDeleteVm.clone();
    }
    
    private String[] vmResourceStartVm = {"/action/start"};
    
    public String[] getStartVmUrl()
    {
        return vmResourceStartVm.clone();
    }
    
    private String[] vmResourceStopVm = {"/action/stop"};
    
    public String[] getStopVmUrl()
    {
        return vmResourceStopVm.clone();
    }
    
    private String[] vmResourceModifyVm = {""};
    
    public String[] getModifyVmUrl()
    {
        return vmResourceModifyVm.clone();
    }
    
    private String[] vmResourceRebootVm = {"/action/reboot"};
    
    public String[] getRebootVmUrl()
    {
        return vmResourceRebootVm.clone();
    }
    
    private String[] vmResourcePauseVm = {"/action/pause"};
    
    public String[] getPauseVmUrl()
    {
        return vmResourcePauseVm.clone();
    }
    
    private String[] vmResourceResumeVm = {"/action/resume"};
    
    public String[] getResumeVmUrl()
    {
        return vmResourceResumeVm.clone();
    }
    
    private String[] vmResourceHibernateVm = {"/action/hibernate"};
    
    public String[] getHibernateVmUrl()
    {
        return vmResourceHibernateVm.clone();
    }
    
    private String[] vmResourceMigrateVm = {"/action/migrate"};
    
    public String[] getMigrateVmUrl()
    {
        return vmResourceMigrateVm.clone();
    }
    
    private String[] vmResourceMigrateVmVol = {"/action/migratevol"};
    
    public String[] getMigrateVmVolUrl()
    {
        return vmResourceMigrateVmVol.clone();
    }
    
    private String[] equipmentResourceAddNic = {"/virtualNics"};
    
    public String[] getEquipmentResourceAddNic()
    {
        return equipmentResourceAddNic.clone();
    }
    
    private String[] equipmentResourceRemoveNic = {"", "/virtualNics/"};
    
    public String[] getEquipmentResourceRemoveNic()
    {
        return equipmentResourceRemoveNic.clone();
    }
    
    private String[] equipmentResourceAttachCdRom = {"/action/attachCdrom"};
    
    public String[] getEquipmentResourceAttachCdRom()
    {
        return equipmentResourceAttachCdRom.clone();
    }
    
    private String[] equipmentResourceDetachCdRom = {"/action/detachCdrom"};
    
    public String[] getEquipmentResourceDetachCdRom()
    {
        return equipmentResourceDetachCdRom.clone();
    }
    
    private String[] equipmentResourceQueryCdRom = {"/action/describeCdrom"};
    
    public String[] getEquipmentResourceQueryCdRom()
    {
        return equipmentResourceQueryCdRom.clone();
    }
    
    private String[] equipmentResourceAttachVolume = {"/action/attachvol"};
    
    public String[] getEquipmentResourceAttachVolume()
    {
        return equipmentResourceAttachVolume.clone();
    }
    
    private String[] equipmentResourceDetachVolume = {"/action/detachvol"};
    
    public String[] getEquipmentResourceDetachVolume()
    {
        return equipmentResourceDetachVolume.clone();
    }
    
    private String[] equipmentResourceInstallTools = {"/action/installtools"};
    
    public String[] getEquipmentResourceInstallTools()
    {
        return equipmentResourceInstallTools.clone();
    }
    
    String[] equipmentResourceUninstallTools = {"/action/uninstalltools"};
    
    public String[] getUninstallToolsUrl()
    {
        return equipmentResourceUninstallTools.clone();
    }
    
    String[] equipmentResourceModifyNic = {""};
    
    public String[] getModifyNicUrl()
    {
        return equipmentResourceModifyNic.clone();
    }
    
    String[] equipmentResourceModifyNics = {"/nics"};
    
    public String[] getModifyNicsUrl()
    {
        return equipmentResourceModifyNics.clone();
    }
    
    String[] equipmentResourceAttachGpu = {"/action/attachgpu"};
    
    public String[] getAttachGpuUrl()
    {
        return equipmentResourceAttachGpu.clone();
    }
    
    String[] equipmentResourceListGpus = {"/gpus?", "limit", "offset", "scope", "allocateStatus", "workStatus",
        "deviceId", "vmName", "vmId"};
    
    public String[] getListGpusUrl()
    {
        return equipmentResourceListGpus.clone();
    }
    
    String[] equipmentResourceQueryGpu = {""};
    
    public String[] getQueryGpuUrl()
    {
        return equipmentResourceQueryGpu.clone();
    }
    
    String[] equipmentResourceDetachGpu = {"/action/detachgpu"};
    
    public String[] getDetachGpuUrl()
    {
        return equipmentResourceDetachGpu.clone();
    }
    
    private String[] vmResourceVmCloneTemp = {"/action/clone"};
    
    public String[] getVmResourceVmCloneTemp()
    {
        return vmResourceVmCloneTemp.clone();
    }
    
    private String[] vmResourceImportTemplate = {"/vms/action/import"};
    
    public String[] getVmResourceImportTemplate()
    {
        return vmResourceImportTemplate.clone();
    }
    
    private String[] vmResourceExportTemplate = {"/action/export"};
    
    public String[] getVmResourceExportTemplate()
    {
        return vmResourceExportTemplate.clone();
    }
    
    private String[] vmResourceCreateVmCustomization = {"/vmcustomizations"};
    
    public String[] getVmResourceCreateVmCustomization()
    {
        return vmResourceCreateVmCustomization.clone();
    }
    
    private String[] vmResourceRemoveVmCustomization = {""};
    
    public String[] getVmResourceRemoveVmCustomization()
    {
        return vmResourceRemoveVmCustomization.clone();
    }
    
    private String[] vmResourceModifyVmCustomization = {""};
    
    public String[] getVmResourceModifyVmCustomization()
    {
        return vmResourceModifyVmCustomization.clone();
    }
    
    private String[] vmResourceQueryVmCustomization = {""};
    
    public String[] getVmResourceQueryVmCustomization()
    {
        return vmResourceQueryVmCustomization.clone();
    }
    
    private String[] vmResourceQueryVmCustomizations = {"/vmcustomizations?", "limit", "offset", "name"};
    
    public String[] getVmResourceQueryVmCustomizations()
    {
        return vmResourceQueryVmCustomizations.clone();
    }
    
    private String[] vmResourceCreateVmSnapshot = {"/snapshots"};
    
    public String[] getVmResourceCreateVmSnapshot()
    {
        return vmResourceCreateVmSnapshot.clone();
    }
    
    private String[] vmResourceModifyVmSnapshot = {""};
    
    public String[] getModifyVmSnapshotUrl()
    {
        return vmResourceModifyVmSnapshot.clone();
    }
    
    private String[] vmResourceDeleteVmSnapshot = {""};
    
    public String[] getVmResourceDeleteVmSnapshot()
    {
        return vmResourceDeleteVmSnapshot.clone();
    }
    
    private String[] vmResourceQueryVmSnapshotUrl = {"/snapshots"};
    
    public String[] getQueryVmSnapshotUrl()
    {
        return vmResourceQueryVmSnapshotUrl.clone();
    }
    
    private String[] vmResourceQueryOsVersionsUrl = {"/vms/osversions"};
    
    public String[] getQueryOsVersionsUrl()
    {
        return vmResourceQueryOsVersionsUrl.clone();
    }
    
    private String[] vmResourceQueryVmSnapshotByIdUrl = {"?", "refreshflag"};
    
    public String[] getQueryVmSnapshotByIdUrl()
    {
        return vmResourceQueryVmSnapshotByIdUrl.clone();
    }
    
    private String[] vmResourceRestoreVmBySnapshotUrl = {"/action/resumevm"};
    
    public String[] getRestoreVmBySnapshotUrl()
    {
        return vmResourceRestoreVmBySnapshotUrl.clone();
    }
    
    private String[] vmResourceRecycle = {"/action/recycle"};
    
    public String[] getRecycle()
    {
        return vmResourceRecycle.clone();
    }
    
    private String[] vmResourceResetVNC = {"/action/resetvnc"};
    
    public String[] getResetVNC()
    {
        return vmResourceResetVNC.clone();
    }
    
    private String[] vmResourceRecycleVol = {"/action/recyclevol"};
    
    public String[] getRecycleVol()
    {
        return vmResourceRecycleVol.clone();
    }
    
    private String[] vmResourceQueryVmStat = {"/vms/statistics?", "scope"};
    
    public String[] getQueryVmStat()
    {
        return vmResourceQueryVmStat.clone();
    }
    
    private String[] vmResourceUploadVmData = {"/action/uploadVmData"};
    
    public String[] getUploadVmData()
    {
        return vmResourceUploadVmData.clone();
    }
    
    private String[] vmResourceCmdexe = {"/action/cmdexe"};
    
    public String[] getCmdexe()
    {
        return vmResourceCmdexe.clone();
    }
    
    /**
     * 虚拟存储
     */
    private String[] dataStorageResourceQueryDataStores = {"/datastores?", "limit", "offset", "scope", "status",
        "name", "exceptDatastoreType", "accessible"};
    
    public String[] getDataStorageResourceQueryDataStores()
    {
        return dataStorageResourceQueryDataStores.clone();
    }
    
    private String[] dataStorageResourceQueryDataStore = {""};
    
    public String[] getDataStorageResourceQueryDataStore()
    {
        return dataStorageResourceQueryDataStore.clone();
    }
    
    private String[] dataStorageResourceQueryAvailableDataStore = {"/datastores/queryavailabledatastore?", "limit",
        "offset", "scope", "datastoreURN", "dataStoreStorageType"};
    
    public String[] getDataStorageResourceQueryAvailableDataStore()
    {
        return dataStorageResourceQueryAvailableDataStore.clone();
    }
    
    private String[] volumeResourceCreateVolume = {"/volumes"};
    
    public String[] getVolumeResourceCreateVolume()
    {
        return volumeResourceCreateVolume.clone();
    }
    
    private String[] volumeResourceRemoveVolume = {"?", "isFormat", "isOnlyDelDB"};
    
    public String[] getVolumeResourceRemoveVolume()
    {
        return volumeResourceRemoveVolume.clone();
    }
    
    private String[] volumeResourceQueryVolumes = {"/volumes?", "limit", "offset", "scope", "name", "refreshflag",
        "pciType", "drFlag", "attachstatus", "uuid", "customProperty"};
    
    public String[] getVolumeResourceQueryVolumes()
    {
        return volumeResourceQueryVolumes.clone();
    }
    
    private String[] volumeResourceQueryVolume = {"?", "refreshflag"};
    
    public String[] getVolumeResourceQueryVolume()
    {
        return volumeResourceQueryVolume.clone();
    }
    
    private String[] volumeResourceResumeVolume = {"/resumevolume"};
    
    public String[] getVolumeResourceResumeVolume()
    {
        return volumeResourceResumeVolume.clone();
    }
    
    private String[] volumeResourceMigrateVolume = {"/action/migratevol"};
    
    public String[] getVolumeResourceMigrateVolume()
    {
        return volumeResourceMigrateVolume.clone();
    }
    
    private String[] volumeResourceQueryDatastoreVolumes = {"/volumes/querydatastorevolumes?", "limit", "offset",
        "dsUrn"};
    
    public String[] getVolumeResourceQueryDatastoreVolumes()
    {
        return volumeResourceQueryDatastoreVolumes.clone();
    }
    
    private String[] volumeResourceModifyIOpropertyOfVolume = {"/modifyIOpropertyOfVolume"};
    
    public String[] getVolumeResourceModifyIOpropertyOfVolume()
    {
        return volumeResourceModifyIOpropertyOfVolume.clone();
    }
    
    private String[] volumeResourceCanMigratevol = {"/volumes/canMigratevol"};
    
    public String[] getVolumeResourceCanMigratevol()
    {
        return volumeResourceCanMigratevol.clone();
    }
    
    private String[] volumeResourceModifyVolume = {""};
    
    public String[] getVolumeResourceModifyVolume()
    {
        return volumeResourceModifyVolume.clone();
    }
    
    private String[] volumeResourceBackupVolume = {"/backup"};
    
    public String[] getVolumeResourceBackupVolume()
    {
        return volumeResourceBackupVolume.clone();
    }
    
    private String[] volumeResourceQueryBackupVolume = {"/querybackup"};
    
    public String[] getVolumeResourceQueryBackupVolume()
    {
        return volumeResourceQueryBackupVolume.clone();
    }
    
    private String[] volumeResourceExchangeVolume = {"/exchangevolume"};
    
    public String[] getVolumeResourceExchangeVolume()
    {
        return volumeResourceExchangeVolume.clone();
    }
    
    /**
     * 虚拟网络
     */
    
    private String[] portGroupResourceCreatePortGroup = {"/portgroups"};
    
    public String[] getPortGroupResourceCreatePortGroup()
    {
        return portGroupResourceCreatePortGroup.clone();
    }
    
    private String[] portGroupResourceQueryPortGroup = {""};
    
    public String[] getPortGroupResourceQueryPortGroup()
    {
        return portGroupResourceQueryPortGroup.clone();
    }
    
    private String[] portGroupResourceQueryPortGroups = {"/portgroups?", "limit", "offset", "portGroupName", "vlan",
        "vxlan"};
    
    public String[] getPortGroupResourceQueryPortGroups()
    {
        return portGroupResourceQueryPortGroups.clone();
    }
    
    private String[] portGroupResourceQueryAllSitePortGroups = {"/portgroups"};
    
    public String[] getPortGroupResourceQueryAllSitePortGroups()
    {
        return portGroupResourceQueryAllSitePortGroups.clone();
    }
    
    private String[] portGroupResourceModifyPortGroup = {""};
    
    public String[] getPortGroupResourceModifyPortGroup()
    {
        return portGroupResourceModifyPortGroup.clone();
    }
    
    private String[] portGroupResourceRemoveGroup = {""};
    
    public String[] getPortGroupResourceRemoveGroup()
    {
        return portGroupResourceRemoveGroup.clone();
    }
    
    private String[] subnetResourceCreateSubnet = {"/subnets"};
    
    public String[] getSubnetResourceCreateSubnet()
    {
        return subnetResourceCreateSubnet.clone();
    }
    
    private String[] subnetResourceQuerySubnet = {""};
    
    public String[] getSubnetResourceQuerySubnet()
    {
        return subnetResourceQuerySubnet.clone();
    }
    
    private String[] subnetResourceQueryAllSubnets = {"/subnets?", "type"};
    
    public String[] getSubnetResourceQueryAllSubnets()
    {
        return subnetResourceQueryAllSubnets.clone();
    }
    
    private String[] subnetResourceModifySubnet = {""};
    
    public String[] getSubnetResourceModifySubnet()
    {
        return subnetResourceModifySubnet.clone();
    }
    
    private String[] subnetResourceRemoveSubnet = {""};
    
    public String[] getSubnetResourceRemoveSubnet()
    {
        return subnetResourceRemoveSubnet.clone();
    }
    
    private String[] VSPResourceQueryVSP = {"/vsps?", "limit", "offset", "scope", "mirrorPortType", "vmName", "mac"};
    
    public String[] getVSPResourceQueryVSP()
    {
        return VSPResourceQueryVSP.clone();
    }
    
    private String[] VSPResourceQueryVspsCount = {"/vsps/getVspsCount?", "vlanId"};
    
    public String[] getVSPResourceQueryVspsCount()
    {
        return VSPResourceQueryVspsCount.clone();
    }
    
    private String[] VSPResourceBindIpMac = {"/bindipmac"};
    
    public String[] getVSPResourceBindIpMac()
    {
        return VSPResourceBindIpMac.clone();
    }
    
    private String[] VSPResourceUnBindIpMac = {"/unbindipmac"};
    
    public String[] getVSPResourceUnBindIpMac()
    {
        return VSPResourceUnBindIpMac.clone();
    }
    
    private String[] DVSwitchResourceQueryDVSwitchs = {"/dvswitchs?", "location", "name"};
    
    public String[] getDVSwitchResourceQueryDVSwitchs()
    {
        return DVSwitchResourceQueryDVSwitchs.clone();
    }
    
    private String[] DVSwitchResourceQueryDVSwitch = {""};
    
    public String[] getDVSwitchResourceQueryDVSwitch()
    {
        return DVSwitchResourceQueryDVSwitch.clone();
    }
    
    private String[] DVSwitchResourceAddVlanpool = {"/action/addvlanpool"};
    
    public String[] getDVSwitchResourceAddVlanpool()
    {
        return DVSwitchResourceAddVlanpool.clone();
    }
    
    private String[] DVSwitchResourceRemoveVlanpool = {"/action/delvlanpool"};
    
    public String[] getDVSwitchResourceRemoveVlanpool()
    {
        return DVSwitchResourceRemoveVlanpool.clone();
    }
    
    private String[] DVSwitchResourceAddvxlanpool = {"/action/addvxlanpool"};
    
    public String[] getDVSwitchResourceAddvxlanpool()
    {
        return DVSwitchResourceAddvxlanpool.clone();
    }
    
    private String[] DVSwitchResourceRemovevxlanpool = {"/action/delvxlanpool"};
    
    public String[] getDVSwitchResourceRemovevxlanpool()
    {
        return DVSwitchResourceRemovevxlanpool.clone();
    }
    
    private String[] DVSwitchResourceModifyVtep = {"/vtep/action/modify"};
    
    public String[] getDVSwitchResourceModifyVtep()
    {
        return DVSwitchResourceModifyVtep.clone();
    }
    
    /**
     * 告警
     */
    private String[] alarmResourceQueryActiveAlarms = {"/alarms/activeAlarms"};
    
    public String[] getAlarmResourceQueryActiveAlarms()
    {
        return alarmResourceQueryActiveAlarms.clone();
    }
    
    private String[] alarmResourceQueryHistoryAlarms = {"/alarms/historyAlarms"};
    
    public String[] getAlarmResourceQueryHistoryAlarms()
    {
        return alarmResourceQueryHistoryAlarms.clone();
    }
    
    private String[] alarmResourceQueryEvents = {"/alarms/events"};
    
    public String[] getAlarmResourceQueryEvents()
    {
        return alarmResourceQueryEvents.clone();
    }
    
    private String[] alarmResourceQueryThresholds = {"/monitors/AlarmThreshold/queryAll"};
    
    public String[] getAlarmResourceQueryThresholds()
    {
        return alarmResourceQueryThresholds.clone();
    }
    
    private String[] alarmResourceModifyThreshold = {"/monitors/AlarmThreshold/modify"};
    
    public String[] getAlarmResourceModifyThreshold()
    {
        return alarmResourceModifyThreshold.clone();
    }
    
    private String[] hostResourceQueryHost = {""};
    
    public String[] getQueryHostUrl()
    {
        return hostResourceQueryHost.clone();
    }
    
    private String[] hostResourceQueryHostList = {"/hosts?", "limit", "offset", "scope", "name", "ip",
        "resourceGroupFlag", "drsRuleIndex", "hostRealName"};
    
    public String[] getQueryHostListUrl()
    {
        return hostResourceQueryHostList.clone();
    }
    
    private String[] hostResourceQueryHostUsage = {"/computeResourceStatics"};
    
    public String[] getQueryHostUsageUrl()
    {
        return hostResourceQueryHostUsage.clone();
    }
    
    private String[] hostResourceQueryHostsUsage = {"/hosts/statistics?", "scope"};
    
    public String[] getQueryHostsUsageUrl()
    {
        return hostResourceQueryHostsUsage.clone();
    }
    
    private String[] hostResourceReboot = {"/action/reboot"};
    
    public String[] getRebootUrl()
    {
        return hostResourceReboot.clone();
    }
    
    private String[] hostResourceCreateHost = {"/hosts"};
    
    public String[] getCreateHostUrl()
    {
        return hostResourceCreateHost.clone();
    }
    
    private String[] hostResourceModifyHost = {""};
    
    public String[] getModifyHostUrl()
    {
        return hostResourceModifyHost.clone();
    }
    
    private String[] hostResourcePowerOn = {"/action/poweron"};
    
    public String[] getPowerOnUrl()
    {
        return hostResourcePowerOn.clone();
    }
    
    private String[] hostResourcePowerOff = {"/action/poweroff"};
    
    public String[] getPowerOffUrl()
    {
        return hostResourcePowerOff.clone();
    }
    
    private String[] hostResourceEnterMaintenanceMode = {"/action/enterMaintenanceMode"};
    
    public String[] getEnterMaintenanceModeUrl()
    {
        return hostResourceEnterMaintenanceMode.clone();
    }
    
    private String[] hostResourceExitMaintenanceMode = {"/action/exitMaintenanceMode"};
    
    public String[] getExitMaintenanceModeUrl()
    {
        return hostResourceExitMaintenanceMode.clone();
    }
    
    private String[] hostResourceRemoveHost = {"?", "isForce"};
    
    public String[] getRemoveHost()
    {
        return hostResourceRemoveHost.clone();
    }
    
    private String[] hostResourceMigrateAllVms = {"/action/MigrateAllVms"};
    
    public String[] getMigrateAllVms()
    {
        return hostResourceMigrateAllVms.clone();
    }
    
    private String[] vmResourceQueryBackupResource = {"/backupresources"};
    
    public String[] getQueryBackupResourceUrl()
    {
        return vmResourceQueryBackupResource.clone();
    }
    
    private String[] clusterResourceQueryCluster = {""};
    
    public String[] getQueryClusterUrl()
    {
        return clusterResourceQueryCluster.clone();
    }
    
    //    private String[] clusterResourceQueryDrsBalance = {"/drsBalance"};
    //    
    //    public String[] getQueryDrsBalanceUrl()
    //    {
    //        return clusterResourceQueryDrsBalance.clone();
    //    }
    
    //    private String[] clusterResourceQueryVmDRS = {"/action/getVmDRS?", "enableVmDrs", "behavior", "id", "name",
    //        "limit", "offset"};
    //    
    //    public String[] getQueryVmDRSUrl()
    //    {
    //        return clusterResourceQueryVmDRS.clone();
    //    }
    
    //    private String[] clusterResourceApplyDRS = {"/action/apply"};
    //    
    //    public String[] getApplyDRSUrl()
    //    {
    //        return clusterResourceApplyDRS.clone();
    //    }
    
    //    private String[] clusterResourceCreateDRS = {"/resourcegroups"};
    //    
    //    public String[] getCreateDRSUrl()
    //    {
    //        return clusterResourceCreateDRS.clone();
    //    }
    
    //    private String[] clusterResourceModifyDRS = {""};
    //    
    //    public String[] getModifyDRSUrl()
    //    {
    //        return clusterResourceModifyDRS.clone();
    //    }
    
    //    private String[] clusterResourceRefreshDrsBalance = {"/drsBalance/action/refresh"};
    //    
    //    public String[] getRefreshDrsBalanceUrl()
    //    {
    //        return clusterResourceRefreshDrsBalance.clone();
    //    }
    
    //    private String[] clusterResourceRemoveDRS = {""};
    //    
    //    public String[] getRemoveDRSUrl()
    //    {
    //        return clusterResourceRemoveDRS.clone();
    //    }
    
    //    private String[] clusterResourceApplyDRSs = {"/drsrecommendations/action/apply"};
    //    
    //    public String[] getApplyDRSsUrl()
    //    {
    //        return clusterResourceApplyDRSs.clone();
    //    }
    
    //    private String[] clusterResourceQueryDRS = {"/resourcegroups?", "type"};
    //    
    //    public String[] getQueryDRSUrl()
    //    {
    //        return clusterResourceQueryDRS.clone();
    //    }
    
    //    private String[] clusterResourceQueryDRSById = {""};
    //    
    //    public String[] getQueryDRSByIdUrl()
    //    {
    //        return clusterResourceQueryDRSById.clone();
    //    }
    
    private String[] clusterResourceQueryClusters = {"/clusters?", "tag", "name", "parentObjUrn"};
    
    public String[] getQueryClustersUrl()
    {
        return clusterResourceQueryClusters.clone();
    }
    
    private String[] clusterResourceQueryComputeResource = {"/computeresource"};
    
    public String[] getQueryComputeResourceUrl()
    {
        return clusterResourceQueryComputeResource.clone();
    }
    
    private String[] clusterResourceCreateCluster = {"/clusters"};
    
    public String[] getCreateCluster()
    {
        return clusterResourceCreateCluster.clone();
    }
    
    private String[] clusterResourceModifyCluster = {""};
    
    public String[] getModifyCluster()
    {
        return clusterResourceModifyCluster.clone();
    }
    
    private String[] clusterResourceRemoveCluster = {""};
    
    public String[] getRemoveCluster()
    {
        return clusterResourceRemoveCluster.clone();
    }
    
    private String[] siteResourceQuerySites = {"/service/sites"};
    
    public String[] getSiteResourceQuerySites()
    {
        return siteResourceQuerySites.clone();
    }
    
    private String[] monitorResourceQueryObjectmetric = {"/monitors/objectmetric-realtimedata"};
    
    public String[] getMonitorResourceQueryObjectmetric()
    {
        return monitorResourceQueryObjectmetric.clone();
    }
    
    private String[] monitorResourceQueryObjectmetricCurvedata = {"/monitors/objectmetric-curvedata"};
    
    public String[] getMonitorResourceQueryObjectmetricCurvedata()
    {
        return monitorResourceQueryObjectmetricCurvedata.clone();
    }
    
    private String[] monitorResourceQueryTopoStatistic = {"/monitors/TopoStatistic/objectmetric-curvedata"};
    
    public String[] getMonitorResourceQueryTopoStatistic()
    {
        return monitorResourceQueryTopoStatistic.clone();
    }
    
    private String[] monitorResourceQuerySysCurrentTime = {"/monitors/getSysCurrentTime"};
    
    public String[] getMonitorResourceQuerySysCurrentTime()
    {
        return monitorResourceQuerySysCurrentTime.clone();
    }
    
    /**
     * 任务管理
     */
    private String[] taskResourceCancel = {"/cancel"};
    
    public String[] getTaskResourceCancel()
    {
        return taskResourceCancel.clone();
    }
    
    /**
     * 备份管理
     */
    private String[] backupResourceCreate = {"/backupresources"};
    
    public String[] getBackupResourceCreate()
    {
        return backupResourceCreate.clone();
    }
    
    private String[] backupResourceQuery = {""};
    
    public String[] getBackupResourceQuery()
    {
        return backupResourceQuery.clone();
    }
    
    private String[] queryVMVolumeCBT = {"/getcbt"};
    
    public String[] getQueryVMVolumeCBT()
    {
        return queryVMVolumeCBT.clone();
    }
    
    /**
     * 文件夹管理
     */
    private String[] folderResourceQueryFolders = {"/folder?", "parentObjUrn", "type"};
    
    public String[] getQueryFoldersUrl()
    {
        return folderResourceQueryFolders.clone();
    }
    
    private String[] folderResourceQueryFolder = {""};
    
    public String[] getQueryFolderUrl()
    {
        return folderResourceQueryFolder.clone();
    }
    
    private String[] folderResourceQueryFolderVMInfo = {"/resource"};
    
    public String[] getQueryFolderVMInfoUrl()
    {
        return folderResourceQueryFolderVMInfo.clone();
    }
    
    private String[] folderResourceCreateFolder = {"/folder"};
    
    public String[] getCreateFolderUrl()
    {
        return folderResourceCreateFolder.clone();
    }
    
    private String[] folderResourceModifyFolder = {""};
    
    public String[] getModifyFolderUrl()
    {
        return folderResourceModifyFolder.clone();
    }
    
    private String[] folderResourceIntoFolder = {"/folder/action/move-into-folder"};
    
    public String[] getIntoFolderUrl()
    {
        return folderResourceIntoFolder.clone();
    }
    
    private String[] folderResourceRemoveFolder = {""};
    
    public String[] getRemoveFolderUrl()
    {
        return folderResourceRemoveFolder.clone();
    }
}
