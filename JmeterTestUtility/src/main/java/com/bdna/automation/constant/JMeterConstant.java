package com.bdna.automation.constant;

import java.util.HashMap;
import java.util.Map;

public class JMeterConstant {

	private static Map<String, String> queryString = new HashMap<String, String>();

	static {
		queryString.put("DIM_N_CPU", "select count(*) from DIM_N_CPU$");
		queryString.put("DIM_N_CPU_LICENSING", "select count(*) from DIM_N_CPU_LICENSING$");
		queryString.put("DIM_N_DEGEN", "select count(*) from DIM_N_DEGEN$");
		queryString.put("DIM_N_ENT", "select count(*) from DIM_N_ENT$");
		queryString.put("DIM_N_ENT_DATES", "select count(*) from DIM_N_ENT_DATES$");
		queryString.put("DIM_N_HW", "select count(*) from DIM_N_HW$");
		queryString.put("DIM_N_HW_CPE", "select count(*) from DIM_N_HW_CPE$");
		queryString.put("DIM_N_HW_CVE", "select count(*) from DIM_N_HW_CVE$");
		queryString.put("DIM_N_HW_IT", "select count(*) from DIM_N_HW_IT$");
		queryString.put("DIM_N_HW_LIC_ADDITIONAL_HW", "select count(*) from DIM_N_HW_LIC_ADDITIONAL_HW$");
		queryString.put("DIM_N_HW_LIC_ADDITIONAL_SW", "select count(*) from DIM_N_HW_LIC_ADDITIONAL_SW$");
		queryString.put("DIM_N_HW_LIC_CPU_CHARS", "select count(*) from DIM_N_HW_LIC_CPU_CHARS$");
		queryString.put("DIM_N_HW_LIC_MFRPARTNO_LPRICE", "select count(*) from DIM_N_HW_LIC_MFRPARTNO_LPRICE$");
		queryString.put("DIM_N_HW_LIC_MODEL$", "select count(*) from DIM_N_HW_LIC_MODEL$");
		queryString.put("DIM_N_HW_PO$", "select count(*) from DIM_N_HW_PO$");
		queryString.put("DIM_N_HW_POWER$", "select count(*) from DIM_N_HW_POWER$");
		queryString.put("DIM_N_HW_PRICING$", "select count(*) from DIM_N_HW_PRICING$");
		queryString.put("DIM_N_HW_PRODUCT_TAG_MAP$", "select count(*) from DIM_N_HW_PRODUCT_TAG_MAP$");
		queryString.put("DIM_N_INV_TASK$", "select count(*) from DIM_N_INV_TASK$");
		queryString.put("DIM_N_MUPT_USR_DU", "select count(*) from DIM_N_MUPT_USR_DU");
		queryString.put("DIM_N_OPENSRC_SW$", "select count(*) from DIM_N_OPENSRC_SW$");
		queryString.put("DIM_N_OS$", "select count(*) from DIM_N_OS$");
		queryString.put("DIM_N_OS_CPE$", "select count(*) from DIM_N_OS_CPE$");
		queryString.put("DIM_N_OS_CVE$", "select count(*) from DIM_N_OS_CVE$");
		queryString.put("DIM_N_OS_SYS_REQS_WIN_ORDER$", "select count(*) from DIM_N_OS_SYS_REQS_WIN_ORDER$");
		queryString.put("DIM_N_OS_SYSTEM_REQUIREMENTS$", "select count(*) from DIM_N_OS_SYSTEM_REQUIREMENTS$");
		queryString.put("DIM_N_OS_WIN_ORDER$", "select count(*) from DIM_N_OS_WIN_ORDER$");
		queryString.put("DIM_N_PO$", "select count(*) from DIM_N_PO$");
		queryString.put("DIM_N_SW$", "select count(*) from DIM_N_SW$");
		queryString.put("DIM_N_SW_CPE$", "select count(*) from DIM_N_SW_CPE$");
		queryString.put("DIM_N_SW_CVE$", "select count(*) from DIM_N_SW_CVE$");
		queryString.put("DIM_N_SW_INSTANCE$", "select count(*) from DIM_N_SW_INSTANCE$");
		queryString.put("DIM_N_SW_IT$", "select count(*) from DIM_N_SW_IT$");
		queryString.put("DIM_N_SW_LIC_ADDITIONAL_SW$", "select count(*) from DIM_N_SW_LIC_ADDITIONAL_SW$");
		queryString.put("DIM_N_SW_LIC_DIST_MEDIA$", "select count(*) from DIM_N_SW_LIC_DIST_MEDIA$");
		queryString.put("DIM_N_SW_LIC_ENVIRONMENT$", "select count(*) from DIM_N_SW_LIC_ENVIRONMENT$");
		queryString.put("DIM_N_SW_LIC_LANGUAGE$", "select count(*) from DIM_N_SW_LIC_LANGUAGE$");
		queryString.put("DIM_N_SW_LIC_MAINT_GRADE$", "select count(*) from DIM_N_SW_LIC_MAINT_GRADE$");
		queryString.put("DIM_N_SW_LIC_METRIC$", "select count(*) from DIM_N_SW_LIC_METRIC$");
		queryString.put("DIM_N_SW_LIC_MFRPARTNO_LPRICE$", "select count(*) from DIM_N_SW_LIC_MFRPARTNO_LPRICE$");
		queryString.put("DIM_N_SW_LIC_PRICE_LEVEL$", "select count(*) from DIM_N_SW_LIC_PRICE_LEVEL$");
		queryString.put("DIM_N_SW_LIC_PRICING$", "select count(*) from DIM_N_SW_LIC_PRICING$");
		queryString.put("DIM_N_SW_LIC_PROGRAM$", "select count(*) from DIM_N_SW_LIC_PROGRAM$");
		queryString.put("DIM_N_SW_LIC_RELEASE$", "select count(*) from DIM_N_SW_LIC_RELEASE$");
		queryString.put("DIM_N_SW_LIC_TYPE$", "select count(*) from DIM_N_SW_LIC_TYPE$");
		queryString.put("DIM_N_SW_LIC_UPGRADE_FROM$", "select count(*) from DIM_N_SW_LIC_UPGRADE_FROM$");
		queryString.put("DIM_N_SW_PO$", "select count(*) from DIM_N_SW_PO$");
		queryString.put("DIM_N_SW_PRICING$", "select count(*) from DIM_N_SW_PRICING$");
		queryString.put("DIM_N_SW_PRODUCT_LINK$", "select count(*) from DIM_N_SW_PRODUCT_LINK$");
		queryString.put("DIM_N_SW_PRODUCT_LINK_IT$", "select count(*) from DIM_N_SW_PRODUCT_LINK_IT$");
		queryString.put("DIM_N_SW_PRODUCT_LINK_PO$", "select count(*) from DIM_N_SW_PRODUCT_LINK_PO$");
		queryString.put("DIM_N_SW_PRODUCT_TAG_MAP$", "select count(*) from DIM_N_SW_PRODUCT_TAG_MAP$");
		queryString.put("DIM_N_SW_REL_PLATFORM$", "select count(*) from DIM_N_SW_REL_PLATFORM$");
		queryString.put("DIM_N_SW_RELEASE_LINK$", "select count(*) from DIM_N_SW_RELEASE_LINK$");
		queryString.put("DIM_N_SW_SUITE$", "select count(*) from DIM_N_SW_SUITE$");
		queryString.put("DIM_N_SW_SUITE_IT$", "select count(*) from DIM_N_SW_SUITE_IT$");
		queryString.put("DIM_N_SW_SUITE_PO$", "select count(*) from DIM_N_SW_SUITE_PO$");
		queryString.put("DIM_N_SW_SUPPORT_POLICY$", "select count(*) from DIM_N_SW_SUPPORT_POLICY$");
		queryString.put("DIM_N_SW_VIRTUAL_COMP$", "select count(*) from DIM_N_SW_VIRTUAL_COMP$");
		queryString.put("DIM_N_SW_WIN_READINESS$", "select count(*) from DIM_N_SW_WIN_READINESS$");
		queryString.put("DIM_N_SYSTEM$", "select count(*) from DIM_N_SYSTEM$");
		queryString.put("DIM_N_SYSTEM_USER$", "select count(*) from DIM_N_SYSTEM_USER$");
		queryString.put("DIM_N_TPC_MAPPING$", "select count(*) from DIM_N_TPC_MAPPING$");
		queryString.put("DIM_N_TPC_UUID_ALL$", "select count(*) from DIM_N_TPC_UUID_ALL$");
		queryString.put("DIM_N_TPC_UUID_ALL_ASSETS$", "select count(*) from DIM_N_TPC_UUID_ALL_ASSETS$");
		queryString.put("DIM_N_TPC_UUID_ALL_PROC$", "select count(*) from DIM_N_TPC_UUID_ALL_PROC$");
		queryString.put("DIM_N_TPC_UUID_IT$", "select count(*) from DIM_N_TPC_UUID_IT$");
		queryString.put("DIM_N_TPC_UUID_IT_ASSETS$", "select count(*) from DIM_N_TPC_UUID_IT_ASSETS$");
		queryString.put("DIM_N_TPC_UUID_IT_PROC$", "select count(*) from DIM_N_TPC_UUID_IT_PROC$");
		queryString.put("DIM_N_TPC_UUID_IT_SEC_SUMM$", "select count(*) from DIM_N_TPC_UUID_IT_SEC_SUMM$");
		queryString.put("DIM_N_TPC_UUID_MD$", "select count(*) from DIM_N_TPC_UUID_MD$");
		queryString.put("DIM_N_TPC_UUID_MD_ASSETS$", "select count(*) from DIM_N_TPC_UUID_MD_ASSETS$");
		queryString.put("DIM_N_TPC_UUID_MD_PROC$", "select count(*) from DIM_N_TPC_UUID_MD_PROC$");
	}

	public static String getValue(String key) {

		return queryString.get(key);
	}

	public static final String PROPERTIES_FILENAME = "jmeter.properties";

}
