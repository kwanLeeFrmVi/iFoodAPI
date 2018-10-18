package com.ifood.config;

/**
 * Application constants.
 */
public final class Constants {

    //Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String STATUS_DELETED = "DELETED";

    public static final String FACEBOOK_TYPE = "facebook";

    public static final String REDIRECT_URL = "redirect_uri";
    public static final String OAUTH_2_CALLBACK = "oauth2callback.jsp";
    public static final String RESPONSE_TYPE = "response_type";
    public static final String TOKEN = "token";
    public static final String CLIENT_ID = "client_id";
    public static final String USD= "USD";
    public static final String _SUCCESS= "success";
    public static final String MESSAGE= "message";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String PRODUCT_TOKEN_HEADER = "X-Auth-Token";
    public static final String DEFAULT = "default";


    public static String NONE = "NONE";
    public static String UNFOUND = "UNFOUND";
    public static String FORMAT_SIMPLE = "simple";

   public static final String ERROR = "ERROR";
    public static final String RESULT = "RESULT";
    public static final String DATA = "DATA";

    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "SUCCESS";
    public static final String CUSTOMER_NOT_FOUND = "AuthenticationError.CUSTOMER_NOT_FOUND";
    public static final String INVALID_AD_ID = "INVALID_AD_ID";
    public static final String INVALID_STATUS = "INVALID_STATUS";
    public static final String UN_KNOWN = "UN_KNOWN";
    public static final String INVALID_AD_GROUP_ID = "INVALID_AD_GROUP_ID";
    public static final String INVALID_ADVERTISER = "INVALID_ADVERTISER";

    public static final int PAGE_SIZE = 100;

    private Constants() {
    }
}
