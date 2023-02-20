package com.assessment.constant;

public class UrlMapping {


    // Company URL
    public static final String BASE_URL = "api/v1";
    public static final String COMPANY = BASE_URL+"/company";

    public static final String GET_COMPANY_BY_ID = "/{id}";

    public static final String GET_COMPANY = "/all";

    public static final String DELETE_COMPANY_BY_ID = "delete/{id}";

    public static final String UPDATE_COMPANY = "/update/{id}";


    // Employee URL

    public static final String EMPLOYEE = BASE_URL+"/employee";

    public static final String GET_EMPLOYEE_BY_ID = "/{id}";

    public static final String GET_EMPLOYEE = "/all";

    public static final String DELETE_EMPLOYEE_BY_ID = "delete/{id}";

    public static final String UPDATE_EMPLOYEE = "/update/{id}";

    // Department URL

    public static final String DEPARTMENT = BASE_URL+"/department";

    public static final String GET_DEPARTMENT_BY_ID = "/{id}";

    public static final String GET_DEPARTMENT = "/all";

    public static final String DELETE_DEPARTMENT_BY_ID = "delete/{id}";

    public static final String UPDATE_DEPARTMENT = "/update/{id}";

    // User URL

    public static final String USER = "/user";

    public static final String GET_ID = "/data";

    //Swagger

    private static final String API_VERSION_V1 = "/api/v1";
    public static final String SWAGGER_API_DOCS ="/v2/api-docs/**";
    public static final String SWAGGER_JSON = "/swagger.json";
    public static final String SWAGGER_UI_HTML = "/swagger-ui.html";
    public static final String SWAGGER_WEBJARS = "/webjars/**";
    public static final String SWAGGER_RESOURCES = "/swagger-resources/**";

}
