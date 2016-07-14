package com.battcn.platform.constant;

public interface Constant
{
	String LOGIN_ERROR_CODE_100001 = "100001";
	String LOGIN_ERROR_MESSAGE_USERERROR = "账号或密码错误，请重新输入！";

	String LOGIN_ERROR_CODE_100002 = "100002";
	String LOGIN_ERROR_MESSAGE_SYSTEMERROR = "用户已经被锁定不能登录，请与管理员联系！";

	String LOGIN_ERROR_CODE_100003 = "100003";
	String LOGIN_ERROR_MESSAGE_MAXERROR = "登录失败次数过多,锁定10分钟！";

	String LOGIN_ERROR_CODE_100004 = "100004";
	String LOGIN_ERROR_MESSAGE_FORCELOGOUT = "您已经被管理员强制退出，请重新登录";

	public static final String[] DATE_PATTERNS = { "yyyy", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd",
			"yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss" };
	public static final String SHOPXX_XML_PATH = "/config/shopxx.xml";
	public static final String SHOPXX_PROPERTIES_PATH = "/config/cfg.properties";
	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "UTF-8";
	public static final String GB2312 = "GB2312";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String NORIGHT = "noright";
	public static final String MESSAGE = "errors";
	public static final String TITLE = "title";

	/** 密码最大长度 */
	public static int PASSWORD_MAX_LENGTH = 16;
	/** 密码最小长度 */
	public static int PASSWORD_MIN_LENGTH = 6;

	/**
	 * 认证码
	 */
	public static final String AUTHCODE = "authcode";
	public static final String AUTHCODE_SEPERATOR = "_";

	/**
	 * HTTP method
	 */
	public static final String POST = "POST";
	public static final String GET = "GET";

	public static final Integer ORDERNO = new Integer(999);
	public static final String VALUE_SEP = ",";
	public static final String TOKEN = "token";
	public static final String SYS_CONFIG_KEY = "cfg";
	public static final String USER_IN_REQUEST = "USER";
	public static final String OP_IN_REQUEST = "OP";
	public static final String USERID_IN_SESSION = "USERID_IN_SESSION";
	public static final String USERID_IN_COOKIE = "USERID_IN_COOKIE";
	public static final String SITESMSCOUNT_IN_REQUEST = "SITESMSCOUNT_IN_REQUEST";
	public static final String DATE_IN_REQUEST = "DATE_IN_REQUEST";
	public static final String REDIRECTURL = "redirectURL";

	public static final String SITENAME = "sitename";
	public static final String SITEURL = "siteurl";
	public static final String SITEINDEX = "siteindex";
	public static final String SITELOGO = "sitelogo";
	public static final String SITEPOWERBY = "sitepowerby";
	public static final String SITEBEIAN = "sitebeian";
	public static final String SITEPHONE = "sitephone";
	public static final String NOPICIMG = "nopicImg";
	public static final String SERVICETERMS = "serviceterms";
	public static final String TEMPLATEFOLDER = "templateFolder";
	public static final String TRAFFIC = "traffic";
	public static final String OPENREG = "openReg";
	public static final String NOTALLOWACCOUNT = "notallowaccount";
	public static final String OPENMEMBERAUDIT = "openMemberaudit";// 会员注册是否需要人工审核
	public static final String OPENEMAILACTIVE = "openEmailactive";// 会员注册是否需要邮箱激活
	public static final String OPENUPLOAD = "openUpload";
	public static final String MAXUPLOADIMAGESIZE = "maxUploadImageSize";
	public static final String UPLOADIMAGEPATH = "uploadImagePath";
	public static final String UPLOADIMAGETYPE = "uploadImageType";
	public static final String INDEXIMAGEWIDTH = "indexImageWidth";
	public static final String INDEXIMAGEHEIGHT = "indexImageHeight";
	public static final String INDEXIMAGEPATH = "indexImagePath";
	public static final String BIGIMAGEWIDTH = "bigImageWidth";
	public static final String BIGIMAGEHEIGHT = "bigImageHeight";
	public static final String BIGIMAGEPATH = "bigImagePath";
	public static final String SMALLIMAGEWIDTH = "smallImageWidth";
	public static final String SMALLIMAGEHEIGHT = "smallImageHeight";
	public static final String SMALLIMAGEPATH = "smallImagePath";
	public static final String THUMBIMAGEWIDTH = "thumbImageWidth";
	public static final String THUMBIMAGEHEIGHT = "thumbImageHeight";
	public static final String THUMBIMAGEPATH = "thumbImagePath";
	public static final String MAXUPLOADVIDEOSIZE = "maxUploadVideoSize";
	public static final String UPLOADVIDEOPATH = "uploadVideoPath";
	public static final String UPLOADVIDEOTYPE = "uploadVideoType";
	public static final String BIGVIDEOWIDTH = "bigVideoWidth";
	public static final String BIGVIDEOHEIGHT = "bigVideoHeight";
	public static final String BIGVIDEOPATH = "bigVideoPath";
	public static final String SMALLVIDEOWIDTH = "smallVideoWidth";
	public static final String SMALLVIDEOHEIGHT = "smallVideoHeight";
	public static final String SMALLVIDEOPATH = "smallVideoPath";
	public static final String THUMBVIDEOWIDTH = "thumbVideoWidth";
	public static final String THUMBVIDEOHEIGHT = "thumbVideoHeight";
	public static final String THUMBVIDEOPATH = "thumbVideoPath";
	public static final String MAXUPLOADMAGAZINESIZE = "maxUploadMagazineSize";
	public static final String UPLOADMAGAZINEPATH = "uploadMagazinePath";
	public static final String UPLOADMAGAZINETYPE = "uploadMagazineType";
	public static final String OPENIMAGEMARK = "openImagemark";
	public static final String OPENWORDMARK = "openWordmark";
	public static final String MARKIMG = "markImg";
	public static final String MARKWORD = "markWord";
	public static final String MARKALPHA = "markAlpha";
	public static final String MARKDEGREE = "markDegree";
	/**
	 * 性能选项
	 */
	public static final String OPENSYSLOG = "openSyslog";
	public static final String OPENBANIP = "openBanip";
	public static final String BANIP = "banip";
	public static final String OPENFILTERWORD = "openFilterword";
	public static final String FILTERWORD = "filterword";
	public static final String EXCLUDEFILTER = "excludefilter";
	public static final String FILTERWORDREPLACE = "**";
	public static final String OPENQTZUPDATECHANNEL = "openQtzUpdateChannel";
	/**
	 * 邮箱配置
	 */
	public static final String SMTPFROMMAIL = "smtpFromMail";
	public static final String SMTPHOST = "smtpHost";
	public static final String SMTPPORT = "smtpPort";
	public static final String SMTPUSERNAME = "smtpUsername";
	public static final String SMTPPASSWORD = "smtpPassword";

}
